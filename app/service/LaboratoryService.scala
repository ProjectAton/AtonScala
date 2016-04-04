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
  def addLaboratory(laboratory: Laboratory): Future[String]

  def getLaboratory(id: Long): Future[Option[Laboratory]]

  def getLaboratoryWithChildrenRooms(id: Long): Future[(Option[Laboratory], Option[HashMap[Room, Computer]])]

  def deleteLaboratory(id: Long): Future[Int]

  def listAllLaboratories: Future[Seq[Laboratory]]
}
