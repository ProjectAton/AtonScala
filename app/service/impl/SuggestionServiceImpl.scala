package service.impl

import javax.inject.{Inject, Singleton}

import dao.SuggestionDAO
import model.Suggestion
import service.SuggestionService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class SuggestionServiceImpl @Inject()(sugerenciaDAO: SuggestionDAO) extends SuggestionService {
  override def addSugerencia(sugerencia: Suggestion): Future[String] = {
    sugerenciaDAO.add(sugerencia)
  }

  override def deleteSugerencia(id: Long): Future[Int] = {
    sugerenciaDAO.delete(id)
  }

  override def listAllSugerencias: Future[Seq[Suggestion]] = {
    sugerenciaDAO.listAll
  }

  override def getSugerencia(id: Long): Future[Option[Suggestion]] = {
    sugerenciaDAO.get(id)
  }
}
