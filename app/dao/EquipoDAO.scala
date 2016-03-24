package dao

import com.google.inject.ImplementedBy
import dao.impl.EquipoDAOImpl
import model.Equipo

import scala.concurrent.Future

/**
  * Controla las acciones sobre la base de datos.
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
@ImplementedBy(classOf[EquipoDAOImpl])
trait EquipoDAO {

  /**
    * Adiciona un inicio
    *
    * @param equipo Equipo a agregar
    * @return String con el mensaje del resultado
    */
  def add(equipo: Equipo): Future[String]

  /**
    * Obtiene un inicio según la ip
    *
    * @param ip Dirección IP del inicio
    * @return Equipo encontrado o None si no se encontró
    */
  def get(ip: String): Future[Option[Equipo]]

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
  def listAll: Future[Seq[Equipo]]
}

