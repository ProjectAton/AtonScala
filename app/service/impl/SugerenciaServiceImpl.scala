package service.impl

import javax.inject.{Inject, Singleton}

import dao.SugerenciaDAO
import model.Sugerencia
import service.SugerenciaService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class SugerenciaServiceImpl @Inject()(sugerenciaDAO: SugerenciaDAO) extends SugerenciaService {
  override def addSugerencia(sugerencia: Sugerencia): Future[String] = {
    sugerenciaDAO.add(sugerencia)
  }

  override def deleteSugerencia(id: Long): Future[Int] = {
    sugerenciaDAO.delete(id)
  }

  override def listAllSugerencias: Future[Seq[Sugerencia]] = {
    sugerenciaDAO.listAll
  }

  override def getSugerencia(id: Long): Future[Option[Sugerencia]] = {
    sugerenciaDAO.get(id)
  }
}
