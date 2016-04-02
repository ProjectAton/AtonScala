package service

import com.google.inject.ImplementedBy
import model.Room
import service.impl.RoomServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[RoomServiceImpl])
trait RoomService {
  def addSala(sala: Room): Future[String]

  def getSala(id: Long): Future[Option[Room]]

  def deleteSala(id: Long): Future[Int]

  def listAllSalas: Future[Seq[Room]]
}

