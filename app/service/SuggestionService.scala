package service

import com.google.inject.ImplementedBy
import model.Suggestion
import service.impl.SuggestionServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[SuggestionServiceImpl])
trait SuggestionService {
  def addSugerencia(sugerencia: Suggestion): Future[String]

  def getSugerencia(id: Long): Future[Option[Suggestion]]

  def deleteSugerencia(id: Long): Future[Int]

  def listAllSugerencias: Future[Seq[Suggestion]]
}
