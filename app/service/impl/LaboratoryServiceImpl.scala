package service.impl

import javax.inject.{Inject, Singleton}

import dao.LaboratoryDAO
import model.{Computer, Laboratory, Room}
import play.Logger
import service.LaboratoryService

import scala.collection.immutable.HashMap
import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class LaboratoryServiceImpl @Inject()(laboratorioDAO: LaboratoryDAO) extends LaboratoryService {
  override def addLaboratory(laboratorio: Laboratory): Future[String] = {
    Logger.debug("Laboratory a agregar: " + laboratorio)
    laboratorioDAO.add(laboratorio)
  }

  override def deleteLaboratory(id: Long): Future[Int] = {
    Logger.debug("Laboratory a eliminar: " + id)
    laboratorioDAO.delete(id)
  }

  override def listAllLaboratories: Future[Seq[Laboratory]] = {
    Logger.debug("Listando todos los laboratorios...")
    laboratorioDAO.listAll
  }

  override def getLaboratory(id: Long): Future[Option[Laboratory]] = {
    Logger.debug("Laboratory a buscar: " + id)
    laboratorioDAO.get(id)
  }

  override def getLaboratoryWithChildrenRooms(id: Long): Future[Seq[(Computer, Room)]] = {
    Logger.debug("Laboratory a buscar con hijos: " + id)
    laboratorioDAO.getWithChildren(id)
  }
}
