package dao

import com.google.inject.ImplementedBy
import dao.impl.OrdenSSHDAOImpl
import model.OrdenSSH

import scala.concurrent.Future

/**
  * Controla las acciones sobre la base de datos.
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
@ImplementedBy(classOf[OrdenSSHDAOImpl])
trait OrdenSSHDAO {

  /**
    * Adiciona una orden SSH
    *
    * @param ordenSSH OrdenSSH a agregar
    * @return String con el mensaje del resultado
    */
  def add(ordenSSH: OrdenSSH): Future[String]

  /**
    * Obtiene una orden SSH según el id
    *
    * @param id Identificador del ordenSSH
    * @return OrdenSSH encontrado o None si no se encontró
    */
  def get(id: Long): Future[Option[OrdenSSH]]

  /**
    * Elimina una orden SSH de la base de datos
    *
    * @param id Identificador del ordenSSH
    * @return Resultado de la operación
    */
  def delete(id: Long): Future[Int]

  /**
    * Lista todas los ordenes SSH en la base de datos
    *
    * @return Todos las ordenes SSH
    */
  def listAll: Future[Seq[OrdenSSH]]
}
