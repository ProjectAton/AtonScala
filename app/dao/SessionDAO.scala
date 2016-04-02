package dao

import java.sql.Timestamp

import com.google.inject.ImplementedBy
import dao.impl.SessionDAOImpl
import model.Session

import scala.concurrent.Future

/**
  * Controla las acciones sobre la base de datos.
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
@ImplementedBy(classOf[SessionDAOImpl])
trait SessionDAO {

  /**
    * Adiciona una sesion
    *
    * @param sesion Session a agregar
    * @return String con el mensaje del resultado
    */
  def add(sesion: Session): Future[String]

  /**
    * Obtiene una sesion según el id
    *
    * @param ip    Dirección IP de la sesion
    * @param fecha Fecha de la sesion
    * @return Session encontrado o None si no se encontró
    */
  def get(ip: String, fecha: Timestamp): Future[Option[Session]]

  /**
    * Elimina una sesion de la base de datos
    *
    * @param ip    Dirección IP de la sesion
    * @param fecha Fecha de la sesion
    * @return Resultado de la operación
    */
  def delete(ip: String, fecha: Timestamp): Future[Int]

  /**
    * Lista todas las sesiones en la base de datos
    *
    * @return Todas los sesiones
    */
  def listAll: Future[Seq[Session]]
}
