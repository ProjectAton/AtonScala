package service

import java.sql.Timestamp

import com.google.inject.ImplementedBy
import model.Estado
import service.impl.EstadoServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[EstadoServiceImpl])
trait EstadoService {
  def addEstado(estado: Estado): Future[String]

  def getEstado(ip: String, fecha: Timestamp): Future[Option[Estado]]

  def deleteEstado(ip: String, fecha: Timestamp): Future[Int]

  def listAllEstados: Future[Seq[Estado]]
}
