package service

import java.sql.Timestamp

import com.google.inject.ImplementedBy
import model.Sesion
import service.impl.SesionServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[SesionServiceImpl])
trait SesionService {
  def addSesion(sesion: Sesion): Future[String]

  def getSesion(ip: String, fecha: Timestamp): Future[Option[Sesion]]

  def deleteSesion(ip: String, fecha: Timestamp): Future[Int]

  def listAllSesions: Future[Seq[Sesion]]
}
