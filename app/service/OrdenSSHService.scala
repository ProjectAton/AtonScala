package service

import com.google.inject.ImplementedBy
import model.OrdenSSH
import service.impl.OrdenSSHServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[OrdenSSHServiceImpl])
trait OrdenSSHService {
  def addOrdenSSH(ordenSSH: OrdenSSH): Future[String]

  def getOrdenSSH(id: Long): Future[Option[OrdenSSH]]

  def deleteOrdenSSH(id: Long): Future[Int]

  def listAllOrdenSSHs: Future[Seq[OrdenSSH]]
}
