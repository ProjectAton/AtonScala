package dao

import com.google.inject.ImplementedBy
import dao.impl.ComputerDAOImpl
import model.table.RoomTable
import model.{Computer, Room}
import slick.lifted.TableQuery

import scala.collection.immutable.HashMap
import scala.concurrent.Future

/**
  * Controla las acciones sobre la base de datos.
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
@ImplementedBy(classOf[ComputerDAOImpl])
trait ComputerDAO {

  /**
    * Hace un join interno en el cual se buscan los equipos de las rooms
    *
    * @param salasEncontradas
    * @param salas
    * @return
    */
  def getComputersPerRooms(salasEncontradas: Future[Seq[Room]], salas: TableQuery[RoomTable]): Option[HashMap[Room, Set[Computer]]]

  /**
    * Adiciona un inicio
    *
    * @param equipo Computer a agregar
    * @return String con el mensaje del result
    */
  def add(equipo: Computer): Future[String]

  /**
    * Obtiene un inicio según la ip
    *
    * @param ip Dirección IP del inicio
    * @return Computer encontrado o None si no se encontró
    */
  def get(ip: String): Future[Option[Computer]]

  /**
    * Elimina un inicio de la base de datos
    *
    * @param ip Dirección IP del inicio
    * @return Resultado de la operación
    */
  def delete(ip: String): Future[Int]

  /**
    * Lista todas los equipos en la base de datos
    *
    * @return Todos los equipos
    */
  def listAll: Future[Seq[Computer]]
}

