package service.impl

import javax.inject.{Inject, Singleton}

import dao.OrdenSSHDAO
import model.OrdenSSH
import service.OrdenSSHService

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
@Singleton
class OrdenSSHServiceImpl @Inject()(ordenSSHDAO: OrdenSSHDAO) extends OrdenSSHService {
  override def addOrdenSSH(ordenSSH: OrdenSSH): Future[String] = {
    ordenSSHDAO.add(ordenSSH)
  }

  override def deleteOrdenSSH(id: Long): Future[Int] = {
    ordenSSHDAO.delete(id)
  }

  override def listAllOrdenSSHs: Future[Seq[OrdenSSH]] = {
    ordenSSHDAO.listAll
  }

  override def getOrdenSSH(id: Long): Future[Option[OrdenSSH]] = {
    ordenSSHDAO.get(id)
  }
}
