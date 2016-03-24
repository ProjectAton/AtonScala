package dao.impl

import javax.inject.Inject

import com.google.inject.Singleton
import dao.EquipoDAO
import model.Equipo
import model.table.EquipoTable
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits._
import slick.driver.JdbcProfile

import scala.concurrent.Future

/**
  * Se encarga de implementar las acciones sobre la base de datos
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  * @param dbConfigProvider Inyección del gestor de la base de datos
  */
@Singleton
class EquipoDAOImpl @Inject()
(dbConfigProvider: DatabaseConfigProvider, salaDAOImpl: SalaDAOImpl) extends EquipoDAO {

  /**
    * Configuración de la base de datos
    */
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import driver.api._

  /**
    * Tabla con "todos los equipos", similar a select * from inicio
    */
  implicit val equipos = TableQuery[EquipoTable]

  /**
    * Adiciona un inicio
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
    * Obtiene un inicio según el id
    *
    * @param ip Dirección IP del inicio
    * @return Equipo encontrado o None si no se encontró
    */
  override def get(ip: String): Future[Option[Equipo]] = {
    // Se realiza un select * from inicio where id = $id
    db.run(search(ip).result.headOption)
  }

  /**
    * Elimina un inicio de la base de datos
    *
    * @param ip Dirección IP del inicio
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

  private def search(ip: String) = equipos.filter(_.ip === ip)
}

