package service.impl

import java.sql.Timestamp
import javax.inject.{Inject, Singleton}

import dao.SesionDAO
import model.Sesion
import service.SesionService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class SesionServiceImpl @Inject()(sesionDAO: SesionDAO) extends SesionService {
  override def addSesion(sesion: Sesion): Future[String] = {
    sesionDAO.add(sesion)
  }

override def deleteSesion(ip: String, fecha: Timestamp): Future[Int] = {
    sesionDAO.delete(ip,fecha)
  }

  override def listAllSesions: Future[Seq[Sesion]] = {
    sesionDAO.listAll
  }

  override def getSesion(ip: String, fecha: Timestamp): Future[Option[Sesion]] = {
    sesionDAO.get(ip,fecha)
  }
}
