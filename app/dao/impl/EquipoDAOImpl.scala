package dao.impl

import javax.inject.Inject

import com.google.inject.Singleton
import dao.EquipoDAO
import model.table.{EquipoTable, SalaTable}
import model.{Equipo, Sala}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.libs.concurrent.Execution.Implicits._
import slick.driver.JdbcProfile

import scala.collection.immutable.HashMap
import scala.concurrent.Future

/**
  * Se encarga de implementar las acciones sobre la base de datos
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  * @param dbConfigProvider Inyección del gestor de la base de datos
  */
@Singleton
class EquipoDAOImpl @Inject()
(protected val dbConfigProvider: DatabaseConfigProvider, salaDAOImpl: SalaDAOImpl) extends EquipoDAO with HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._

  /**
    * Tabla con "todos los equipos", similar a select * from equipo
    */
  implicit val equipos = TableQuery[EquipoTable]

  /**
    * Adiciona un equipo
    *
    * @param equipo Equipo a agregar
    * @return String con el mensaje del resultado
    */
  override def add(equipo: Equipo): Future[String] = {
    // Se realiza un insert y por cada insert se crea un String
    db.run(equipos += equipo).map(res => "Equipo agregado correctamente").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  /**
    * Obtiene un equipo según el id
    *
    * @param ip Dirección IP del equipo
    * @return Equipo encontrado o None si no se encontró
    */
  override def get(ip: String): Future[Option[Equipo]] = {
    // Se realiza un select * from equipo where id = $id
    db.run(search(ip).result.headOption)
  }

  private def search(ip: String) = equipos.filter(_.ip === ip)

  /**
    * Elimina un equipo de la base de datos
    *
    * @param ip Dirección IP del equipo
    * @return Resultado de la operación
    */
  override def delete(ip: String): Future[Int] = {
    db.run(search(ip).delete)
  }

  /**
    * Lista todos los equipos en la base de datos
    *
    * @return Todos los equipos
    */
  override def listAll: Future[Seq[Equipo]] = {
    db.run(equipos.result)
  }

  /**
    * Hace un join interno en el cual se buscan los equipos de las salas
    *
    * @param salasEncontradas
    * @param salas
    * @return
    */
  override def buscarEquiposPorSalas(salasEncontradas: Future[Seq[Sala]], salas: TableQuery[SalaTable]): Option[HashMap[Sala, Equipo]] = {
    for {
      sala <- salasEncontradas
      equipo <- equipos join salas
    } ()
  }


}

