package dao.impl

import javax.inject.Inject

import com.google.inject.Singleton
import dao.ComputerDAO
import model.table.{ComputerTable, RoomTable}
import model.{Computer, Room}
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
class ComputerDAOImpl @Inject()
(protected val dbConfigProvider: DatabaseConfigProvider, salaDAOImpl: RoomDAOImpl) extends ComputerDAO with HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._

  /**
    * Tabla con "todos los equipos", similar a select * from computer
    */
  implicit val equipos = TableQuery[ComputerTable]

  /**
    * Adiciona un computer
    *
    * @param equipo Computer a agregar
    * @return String con el mensaje del result
    */
  override def add(equipo: Computer): Future[String] = {
    // Se realiza un insert y por cada insert se crea un String
    db.run(equipos += equipo).map(res => "Computer agregado correctamente").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  /**
    * Obtiene un computer según el id
    *
    * @param ip Dirección IP del computer
    * @return Computer encontrado o None si no se encontró
    */
  override def get(ip: String): Future[Option[Computer]] = {
    // Se realiza un select * from computer where id = $id
    db.run(search(ip).result.headOption)
  }

  private def search(ip: String) = equipos.filter(_.ip === ip)

  /**
    * Elimina un computer de la base de datos
    *
    * @param ip Dirección IP del computer
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
  override def listAll: Future[Seq[Computer]] = {
    db.run(equipos.result)
  }

  /**
    * Hace un join interno en el cual se buscan los equipos de las salas
    *
    * @param salasEncontradas
    * @param salas
    * @return
    */
  override def buscarEquiposPorSalas(salasEncontradas: Future[Seq[Room]], salas: TableQuery[RoomTable]): Option[HashMap[Room, Computer]] = {
    for {
      sala <- salasEncontradas
      equipo <- equipos join salas
    } ()
  }


}

