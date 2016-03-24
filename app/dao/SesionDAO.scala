package dao

import java.sql.Timestamp
import java.util.Date

import com.google.inject.ImplementedBy
import dao.impl.SesionDAOImpl
import model.Sesion

import scala.concurrent.Future

/**
  * Controla las acciones sobre la base de datos.
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
@ImplementedBy(classOf[SesionDAOImpl])
trait SesionDAO {

  /**
    * Adiciona una sesion
    *
    * @param sesion Sesion a agregar
    * @return String con el mensaje del resultado
    */
  def add(sesion: Sesion): Future[String]

  /**
    * Obtiene una sesion según el id
    *
    * @param ip    Dirección IP de la sesion
    * @param fecha Fecha de la sesion
    * @return Sesion encontrado o None si no se encontró
    */
  def get(ip: String, fecha: Timestamp): Future[Option[Sesion]]

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
  def listAll: Future[Seq[Sesion]]
}
