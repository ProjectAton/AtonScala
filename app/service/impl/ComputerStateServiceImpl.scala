package service.impl

import java.sql.Timestamp
import javax.inject.{Inject, Singleton}

import dao.ComputerStateDAO
import model.ComputerState
import service.ComputerStateService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class ComputerStateServiceImpl @Inject()(estadoDAO: ComputerStateDAO) extends ComputerStateService {
  override def addEstado(estado: ComputerState): Future[String] = {
    estadoDAO.add(estado)
  }

  override def deleteEstado(ip: String, fecha: Timestamp): Future[Int] = {
    estadoDAO.delete(ip,fecha)
  }

  override def listAllEstados: Future[Seq[ComputerState]] = {
    estadoDAO.listAll
  }

  override def getEstado(ip: String, fecha: Timestamp): Future[Option[ComputerState]] = {
    estadoDAO.get(ip,fecha)
  }
}
