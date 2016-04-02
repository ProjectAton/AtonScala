package service.impl

import javax.inject.{Inject, Singleton}

import dao.SSHOrderDAO
import model.SSHOrder
import service.SSHOrderService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class SSHOrderServiceImpl @Inject()(ordenSSHDAO: SSHOrderDAO) extends SSHOrderService {
  override def addOrdenSSH(ordenSSH: SSHOrder): Future[String] = {
    ordenSSHDAO.add(ordenSSH)
  }

  override def deleteOrdenSSH(id: Long): Future[Int] = {
    ordenSSHDAO.delete(id)
  }

  override def listAllOrdenSSHs: Future[Seq[SSHOrder]] = {
    ordenSSHDAO.listAll
  }

  override def getOrdenSSH(id: Long): Future[Option[SSHOrder]] = {
    ordenSSHDAO.get(id)
  }
}
