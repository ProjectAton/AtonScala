package dao.impl

import javax.inject.Inject

import com.google.inject.Singleton
import dao.{ComputerDAO, RoomDAO}
import model.table.RoomTable
import model.{Computer, Room}
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
class RoomDAOImpl @Inject()
(dbConfigProvider: DatabaseConfigProvider, equipoDAO: ComputerDAO) extends RoomDAO {
  /**
    * Configuración de la base de datos
    */
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import driver.api._


  /**
    * Tabla con "todos los salas", similar a select * from sala
    */
  implicit val salas = TableQuery[RoomTable]

  /**
    * Adiciona una sala
    *
    * @param sala Room a agregar
    * @return String con el mensaje del resultado
    */
  override def add(sala: Room): Future[String] = {
    // Se realiza un insert y por cada insert se crea un String
    db.run(salas += sala).map(res => "Room agregada correctamente").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  /**
    * Obtiene una sala según el id
    *
    * @param id Identificador del sala
    * @return Room encontrado o None si no se encontró
    */
  override def get(id: Long): Future[Option[Room]] = {
    // Se realiza un select * from sala where id = $id
    db.run(search(id).result.headOption)
  }

  /**
    * Elimina una sala de la base de datos
    *
    * @param id Identificador de la sala
    * @return Resultado de la operación
    */
  override def delete(id: Long): Future[Int] = {
    db.run(search(id).delete)
  }

  private def search(id: Long) = salas.filter(_.id === id)

  /**
    * Lista todas los salas en la base de datos
    *
    * @return Todas las salas
    */
  override def listAll: Future[Seq[Room]] = {
    db.run(salas.result)
  }

  /**
    * Obtiene todas las salas que coinciden con el id de laboratorio
    *
    * @param id
    */
  override def getSalasPorLaboratorio(id: Long): Option[HashMap[Room, Computer]] = {
    val salasEncontradas: Future[Seq[Room]] = db.run(salas.filter(_.idLaboratorio === id).result)
    equipoDAO.buscarEquiposPorSalas(salasEncontradas, salas)
  }
}

