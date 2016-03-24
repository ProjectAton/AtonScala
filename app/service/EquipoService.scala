package service

import com.google.inject.ImplementedBy
import model.Equipo
import service.impl.EquipoServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[EquipoServiceImpl])
trait EquipoService {
  def addEquipo(equipo: Equipo): Future[String]

  def getEquipo(ip: String): Future[Option[Equipo]]

  def deleteEquipo(ip: String): Future[Int]

  def listAllEquipos: Future[Seq[Equipo]]
}

