package service.impl

import javax.inject.{Inject, Singleton}

import dao.LaboratorioDAO
import model.{Equipo, Laboratorio, Sala}
import play.Logger
import service.LaboratorioService

import scala.collection.immutable.HashMap
import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class LaboratorioServiceImpl @Inject()(laboratorioDAO: LaboratorioDAO) extends LaboratorioService {
  override def addLaboratorio(laboratorio: Laboratorio): Future[String] = {
    Logger.debug("Laboratorio a agregar: " + laboratorio)
    laboratorioDAO.add(laboratorio)
  }

  override def deleteLaboratorio(id: Long): Future[Int] = {
    Logger.debug("Laboratorio a eliminar: " + id)
    laboratorioDAO.delete(id)
  }

  override def listAllLaboratorios: Future[Seq[Laboratorio]] = {
    Logger.debug("Listando todos los laboratorios...")
    laboratorioDAO.listAll
  }

  override def getLaboratorio(id: Long): Future[Option[Laboratorio]] = {
    Logger.debug("Laboratorio a buscar: " + id)
    laboratorioDAO.get(id)
  }

  override def getLaboratorioConHijos(id: Long): Future[(Option[Laboratorio], Option[HashMap[Sala, Set[Equipo]]])] = {
    Logger.debug("Laboratorio a buscar con hijos: " + id)
    laboratorioDAO.getWithChildren(id)
  }
}
