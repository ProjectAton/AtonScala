package service.impl

import java.sql.Timestamp
import javax.inject.{Inject, Singleton}

import dao.EstadoDAO
import model.Estado
import service.EstadoService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class EstadoServiceImpl @Inject()(estadoDAO: EstadoDAO) extends EstadoService {
  override def addEstado(estado: Estado): Future[String] = {
    estadoDAO.add(estado)
  }

  override def deleteEstado(ip: String, fecha: Timestamp): Future[Int] = {
    estadoDAO.delete(ip,fecha)
  }

  override def listAllEstados: Future[Seq[Estado]] = {
    estadoDAO.listAll
  }

  override def getEstado(ip: String, fecha: Timestamp): Future[Option[Estado]] = {
    estadoDAO.get(ip,fecha)
  }
}
