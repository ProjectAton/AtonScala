package service

import java.sql.Timestamp

import com.google.inject.ImplementedBy
import model.ComputerState
import service.impl.ComputerStateServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[ComputerStateServiceImpl])
trait ComputerStateService {
  def addEstado(estado: ComputerState): Future[String]

  def getEstado(ip: String, fecha: Timestamp): Future[Option[ComputerState]]

  def deleteEstado(ip: String, fecha: Timestamp): Future[Int]

  def listAllEstados: Future[Seq[ComputerState]]
}
