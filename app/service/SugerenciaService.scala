package service

import com.google.inject.ImplementedBy
import model.Sugerencia
import service.impl.SugerenciaServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[SugerenciaServiceImpl])
trait SugerenciaService {
  def addSugerencia(sugerencia: Sugerencia): Future[String]

  def getSugerencia(id: Long): Future[Option[Sugerencia]]

  def deleteSugerencia(id: Long): Future[Int]

  def listAllSugerencias: Future[Seq[Sugerencia]]
}
