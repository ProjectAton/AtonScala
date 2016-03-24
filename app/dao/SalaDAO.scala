package dao

import com.google.inject.ImplementedBy
import dao.impl.SalaDAOImpl
import model.Sala

import scala.concurrent.Future

/**
  * Controla las acciones sobre la base de datos.
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
@ImplementedBy(classOf[SalaDAOImpl])
trait SalaDAO {

  /**
    * Adiciona una sala
    *
    * @param sala Sala a agregar
    * @return String con el mensaje del resultado
    */
  def add(sala: Sala): Future[String]

  /**
    * Obtiene una sala según el id
    *
    * @param id Identificador del sala
    * @return Sala encontrado o None si no se encontró
    */
  def get(id: Long): Future[Option[Sala]]

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
  def listAll: Future[Seq[Sala]]
}
