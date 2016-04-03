package dao.impl

import javax.inject.Inject

import com.google.inject.Singleton
import dao.{LaboratoryDAO, RoomDAO}
import model.table.LaboratoryTable
import model.{Computer, Laboratory, Room}
import play.Logger
import play.api.db.slick.DatabaseConfigProvider
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
class LaboratoryDAOImpl @Inject()
(dbConfigProvider: DatabaseConfigProvider, salaDAO: RoomDAO) extends LaboratoryDAO {
  /**
    * Configuración de la base de datos
    */
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import driver.api._



  /**
    * Tabla con "todos los laboratorios", similar a select * from laboratorio
    */
  implicit val laboratorios = TableQuery[LaboratoryTable]

  /**
    * Adiciona un laboratorio
    *
    * @param laboratorio Laboratory a agregar
    * @return String con el mensaje del result
    */
  override def add(laboratorio: Laboratory): Future[String] = {
    // Se realiza un insert y por cada insert se crea un String
    Logger.debug("Agregando el laboratorio [" + laboratorio + "] en la base de datos.")
    db.run(laboratorios += laboratorio).map(res => "Laboratory agregado correctamente").recover {
      case ex: Exception => {
        Logger.error("Ocurrió un error al adicionar en la base de datos", ex)
        ex.getCause.getMessage
      }
    }
  }

  /**
    * Elimina un laboratorio de la base de datos
    *
    * @param id Identificador del laboratorio
    * @return Resultado de la operación
    */
  override def delete(id: Long): Future[Int] = {
    db.run(search(id).delete)
  }

  /**
    * Lista todas los laboratorios en la base de datos
    *
    * @return Todos los laboratorios
    */
  override def listAll: Future[Seq[Laboratory]] = {
    db.run(laboratorios.result)
  }

  /**
    * Obtiene el laboratorio con todos las salas y PC asociadas
    *
    * @param id
    * @return
    */
  override def getWithChildren(id: Long): Future[(Option[Laboratory], Option[HashMap[Room, Set[Computer]]])] = {
    val laboratorio = get(id)
    val salas = salaDAO.getSalasPorLaboratorio(id)
    (laboratorio, salas)
  }

  /**
    * Obtiene un laboratorio según el id
    *
    * @param id Identificador del laboratorio
    * @return Laboratory encontrado o None si no se encontró
    */
  override def get(id: Long): Future[Option[Laboratory]] = {
    // Se realiza un select * from laboratorio where id = $id
    db.run(search(id).result.headOption)
  }

  private def search(id: Long) = laboratorios.filter(_.id === id)
}