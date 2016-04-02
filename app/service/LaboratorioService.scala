package service

import com.google.inject.ImplementedBy
import model.{Equipo, Laboratorio, Sala}
import service.impl.LaboratorioServiceImpl

import scala.collection.immutable.HashMap
import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[LaboratorioServiceImpl])
trait LaboratorioService {
  def addLaboratorio(laboratorio: Laboratorio): Future[String]

  def getLaboratorio(id: Long): Future[Option[Laboratorio]]

  def getLaboratorioConHijos(id: Long): Future[(Option[Laboratorio],Option[HashMap[Sala,Equipo]])]

  def deleteLaboratorio(id: Long): Future[Int]

  def listAllLaboratorios: Future[Seq[Laboratorio]]
}
