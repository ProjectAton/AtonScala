package dao

import com.google.inject.ImplementedBy
import dao.impl.RoomDAOImpl
import model.{Computer, Room}

import scala.collection.immutable.HashMap
import scala.concurrent.Future

/**
  * Controla las acciones sobre la base de datos.
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
@ImplementedBy(classOf[RoomDAOImpl])
trait RoomDAO {

  /**
    * Obtiene todas las salas que coinciden con el id de laboratory
    *
    * @param id
    */
  def getSalasPorLaboratorio(id: Long): Option[HashMap[Room, Set[Computer]]]


  /**
    * Adiciona una room
    *
    * @param sala Room a agregar
    * @return String con el mensaje del result
    */
  def add(sala: Room): Future[String]

  /**
    * Obtiene una room según el id
    *
    * @param id Identificador del room
    * @return Room encontrado o None si no se encontró
    */
  def get(id: Long): Future[Option[Room]]

  /**
    * Elimina una room de la base de datos
    *
    * @param id Identificador del room
    * @return Resultado de la operación
    */
  def delete(id: Long): Future[Int]

  /**
    * Lista todas las salas en la base de datos
    *
    * @return Todas las salas
    */
  def listAll: Future[Seq[Room]]
}
