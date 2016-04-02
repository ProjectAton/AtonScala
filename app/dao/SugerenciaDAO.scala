package dao

import com.google.inject.ImplementedBy
import dao.impl.SugerenciaDAOImpl
import model.Sugerencia

import scala.concurrent.Future

/**
  * Controla las acciones sobre la base de datos.
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
@ImplementedBy(classOf[SugerenciaDAOImpl])
trait SugerenciaDAO {

  /**
    * Adiciona una sugerencia
    *
    * @param sugerencia Sugerencia a agregar
    * @return String con el mensaje del resultado
    */
  def add(sugerencia: Sugerencia): Future[String]

  /**
    * Obtiene un sugerencia según el id
    *
    * @param id Identificador del sugerencia
    * @return Sugerencia encontrado o None si no se encontró
    */
  def get(id: Long): Future[Option[Sugerencia]]

  /**
    * Elimina un sugerencia de la base de datos
    *
    * @param id Identificador del sugerencia
    * @return Resultado de la operación
    */
  def delete(id: Long): Future[Int]

  /**
    * Lista todos los sugerencias en la base de datos
    *
    * @return Todos los sugerencias
    */
  def listAll: Future[Seq[Sugerencia]]
}
