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
    * Obtiene todas las salas que coinciden con el id de laboratorio
    *
    * @param id
    */
  def getSalasPorLaboratorio(id: Long): Option[HashMap[Room, Set[Computer]]]


  /**
    * Adiciona una sala
    *
    * @param sala Room a agregar
    * @return String con el mensaje del resultado
    */
  def add(sala: Room): Future[String]

  /**
    * Obtiene una sala según el id
    *
    * @param id Identificador del sala
    * @return Room encontrado o None si no se encontró
    */
  def get(id: Long): Future[Option[Room]]

  /**
    * Elimina una sala de la base de datos
    *
    * @param id Identificador del sala
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
