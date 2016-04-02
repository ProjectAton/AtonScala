package service

import com.google.inject.ImplementedBy
import model.{Computer, Laboratory, Room}
import service.impl.LaboratoryServiceImpl

import scala.collection.immutable.HashMap
import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[LaboratoryServiceImpl])
trait LaboratoryService {
  def addLaboratorio(laboratorio: Laboratory): Future[String]

  def getLaboratorio(id: Long): Future[Option[Laboratory]]

  def getLaboratorioConHijos(id: Long): Future[(Option[Laboratory], Option[HashMap[Room, Computer]])]

  def deleteLaboratorio(id: Long): Future[Int]

  def listAllLaboratorios: Future[Seq[Laboratory]]
}
