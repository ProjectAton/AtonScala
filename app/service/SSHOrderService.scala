package service

import com.google.inject.ImplementedBy
import model.SSHOrder
import service.impl.SSHOrderServiceImpl

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@ImplementedBy(classOf[SSHOrderServiceImpl])
trait SSHOrderService {
  def addOrdenSSH(ordenSSH: SSHOrder): Future[String]

  def getOrdenSSH(id: Long): Future[Option[SSHOrder]]

  def deleteOrdenSSH(id: Long): Future[Int]

  def listAllOrdenSSHs: Future[Seq[SSHOrder]]
}
