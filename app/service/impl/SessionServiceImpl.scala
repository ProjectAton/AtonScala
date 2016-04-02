package service.impl

import java.sql.Timestamp
import javax.inject.{Inject, Singleton}

import dao.SessionDAO
import model.Session
import service.SessionService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class SessionServiceImpl @Inject()(sesionDAO: SessionDAO) extends SessionService {
  override def addSesion(sesion: Session): Future[String] = {
    sesionDAO.add(sesion)
  }

override def deleteSesion(ip: String, fecha: Timestamp): Future[Int] = {
    sesionDAO.delete(ip,fecha)
  }

  override def listAllSesions: Future[Seq[Session]] = {
    sesionDAO.listAll
  }

  override def getSesion(ip: String, fecha: Timestamp): Future[Option[Session]] = {
    sesionDAO.get(ip,fecha)
  }
}
