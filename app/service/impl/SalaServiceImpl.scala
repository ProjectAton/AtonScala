package service.impl

import javax.inject.{Inject, Singleton}

import dao.SalaDAO
import model.Sala
import service.SalaService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class SalaServiceImpl @Inject()(salaDAO: SalaDAO) extends SalaService {
  override def addSala(sala: Sala): Future[String] = {
    salaDAO.add(sala)
  }

  override def deleteSala(id: Long): Future[Int] = {
    salaDAO.delete(id)
  }

  override def listAllSalas: Future[Seq[Sala]] = {
    salaDAO.listAll
  }

  override def getSala(id: Long): Future[Option[Sala]] = {
    salaDAO.get(id)
  }
}
