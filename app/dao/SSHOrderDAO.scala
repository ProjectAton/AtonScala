package dao

import com.google.inject.ImplementedBy
import dao.impl.SSHOrderDAOImpl
import model.SSHOrder

import scala.concurrent.Future

/**
  * Controla las acciones sobre la base de datos.
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
@ImplementedBy(classOf[SSHOrderDAOImpl])
trait SSHOrderDAO {

  /**
    * Adiciona una orden SSH
    *
    * @param ordenSSH command a agregar
    * @return String con el mensaje del result
    */
  def add(ordenSSH: SSHOrder): Future[String]

  /**
    * Obtiene una orden SSH según el id
    *
    * @param id Identificador del command
    * @return command encontrado o None si no se encontró
    */
  def get(id: Long): Future[Option[SSHOrder]]

  /**
    * Elimina una orden SSH de la base de datos
    *
    * @param id Identificador del command
    * @return Resultado de la operación
    */
  def delete(id: Long): Future[Int]

  /**
    * Lista todas los ordenes SSH en la base de datos
    *
    * @return Todos las ordenes SSH
    */
  def listAll: Future[Seq[SSHOrder]]
}
