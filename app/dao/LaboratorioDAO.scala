package dao

import com.google.inject.ImplementedBy
import dao.impl.LaboratorioDAOImpl
import model.{Equipo, Laboratorio, Sala}

import scala.collection.immutable.HashMap
import scala.concurrent.Future

/**
  * Controla las acciones sobre la base de datos.
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
@ImplementedBy(classOf[LaboratorioDAOImpl])
trait LaboratorioDAO {

  /**
    * Obtiene el laboratorio con todos las salas y PC asociadas
    *
    * @param id
    * @return
    */
  def getWithChildren(id: Long): Future[(Option[Laboratorio], Option[HashMap[Sala, Set[Equipo]]])]


  /**
    * Adiciona un laboratorio
    *
    * @param laboratorio Laboratorio a agregar
    * @return String con el mensaje del resultado
    */
  def add(laboratorio: Laboratorio): Future[String]

  /**
    * Obtiene un laboratorio según el id
    *
    * @param id Identificador del laboratorio
    * @return Laboratorio encontrado o None si no se encontró
    */
  def get(id: Long): Future[Option[Laboratorio]]

  /**
    * Elimina un laboratorio de la base de datos
    *
    * @param id Identificador del laboratorio
    * @return Resultado de la operación
    */
  def delete(id: Long): Future[Int]

  /**
    * Lista todos los laboratorios en la base de datos
    *
    * @return Todos los laboratorios
    */
  def listAll: Future[Seq[Laboratorio]]
}
