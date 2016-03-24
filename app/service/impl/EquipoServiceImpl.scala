package service.impl

import javax.inject.{Inject, Singleton}

import dao.EquipoDAO
import model.Equipo
import service.EquipoService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class EquipoServiceImpl @Inject()(equipoDAO: EquipoDAO) extends EquipoService {
  override def addEquipo(equipo: Equipo): Future[String] = {
    equipoDAO.add(equipo)
  }

  override def deleteEquipo(ip: String): Future[Int] = {
    equipoDAO.delete(ip)
  }

  override def listAllEquipos: Future[Seq[Equipo]] = {
    equipoDAO.listAll
  }

  override def getEquipo(ip: String): Future[Option[Equipo]] = {
    equipoDAO.get(ip)
  }
}
