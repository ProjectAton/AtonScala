package service

import java.sql.Timestamp

import com.google.inject.ImplementedBy
import model.Session
import service.impl.SessionServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[SessionServiceImpl])
trait SessionService {
  def addSesion(sesion: Session): Future[String]

  def getSesion(ip: String, fecha: Timestamp): Future[Option[Session]]

  def deleteSesion(ip: String, fecha: Timestamp): Future[Int]

  def listAllSesions: Future[Seq[Session]]
}
