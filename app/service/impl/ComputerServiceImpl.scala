package service.impl

import javax.inject.{Inject, Singleton}

import dao.ComputerDAO
import model.Computer
import service.ComputerService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class ComputerServiceImpl @Inject()(equipoDAO: ComputerDAO) extends ComputerService {
  override def addEquipo(equipo: Computer): Future[String] = {
    equipoDAO.add(equipo)
  }

  override def deleteEquipo(ip: String): Future[Int] = {
    equipoDAO.delete(ip)
  }

  override def listAllEquipos: Future[Seq[Computer]] = {
    equipoDAO.listAll
  }

  override def getEquipo(ip: String): Future[Option[Computer]] = {
    equipoDAO.get(ip)
  }
}
