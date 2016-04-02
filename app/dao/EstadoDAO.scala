package dao

import java.sql.Timestamp

import com.google.inject.ImplementedBy
import dao.impl.EstadoDAOImpl
import model.Estado

import scala.concurrent.Future

/**
  * Controla las acciones sobre la base de datos.
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
@ImplementedBy(classOf[EstadoDAOImpl])
trait EstadoDAO {

  /**
    * Adiciona un estado
    *
    * @param estado Estado a agregar
    * @return String con el mensaje del resultado
    */
  def add(estado: Estado): Future[String]

  /**
    * Obtiene un estado según el identificador compuesto
    *
    * @param ip    Dirección IP del estado
    * @param fecha Fecha del estado
    * @return Estado encontrado o None si no se encontró
    */
  def get(ip: String, fecha: Timestamp): Future[Option[Estado]]

  /**
    * Elimina un estado de la base de datos
    *
    * @param ip    Dirección IP del estado
    * @param fecha Fecha del estado
    * @return Resultado de la operación
    */
  def delete(ip: String, fecha: Timestamp): Future[Int]

  /**
    * Lista todos los estados en la base de datos
    *
    * @return Todos los estados
    */
  def listAll: Future[Seq[Estado]]
}
