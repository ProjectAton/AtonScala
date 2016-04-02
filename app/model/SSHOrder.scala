package model

/**
  * POJO con la información básica de SSHOrder (Utilizada por el DAO, Service y Controller de ordenes ssh)
  */
case class SSHOrder(id: Long, sudo: Boolean, interrumpir: Boolean, ordenSSH: String, resultado: String, codigoSalida: Int)
