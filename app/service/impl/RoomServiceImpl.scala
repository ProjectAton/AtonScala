package service.impl

import javax.inject.{Inject, Singleton}

import dao.RoomDAO
import model.Room
import service.RoomService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class RoomServiceImpl @Inject()(salaDAO: RoomDAO) extends RoomService {
  override def addSala(sala: Room): Future[String] = {
    salaDAO.add(sala)
  }

  override def deleteSala(id: Long): Future[Int] = {
    salaDAO.delete(id)
  }

  override def listAllSalas: Future[Seq[Room]] = {
    salaDAO.listAll
  }

  override def getSala(id: Long): Future[Option[Room]] = {
    salaDAO.get(id)
  }
}
