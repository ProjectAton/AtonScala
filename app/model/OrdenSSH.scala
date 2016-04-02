package model

/**
  * POJO con la información básica de OrdenSSH (Utilizada por el DAO, Service y Controller de ordenes ssh)
  */
case class OrdenSSH(id: Long, sudo: Boolean, interrumpir: Boolean, ordenSSH: String, resultado: String, codigoSalida: Int)
