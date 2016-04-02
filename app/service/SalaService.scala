package service

import com.google.inject.ImplementedBy
import model.Sala
import service.impl.SalaServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[SalaServiceImpl])
trait SalaService {
  def addSala(sala: Sala): Future[String]

  def getSala(id: Long): Future[Option[Sala]]

  def deleteSala(id: Long): Future[Int]

  def listAllSalas: Future[Seq[Sala]]
}

