package service

import com.google.inject.ImplementedBy
import model.Computer
import service.impl.ComputerServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[ComputerServiceImpl])
trait ComputerService {
  def addEquipo(equipo: Computer): Future[String]

  def getEquipo(ip: String): Future[Option[Computer]]

  def deleteEquipo(ip: String): Future[Int]

  def listAllEquipos: Future[Seq[Computer]]
}

