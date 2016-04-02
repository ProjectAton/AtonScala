package model

/**
  * POJO con la información básica de Equipo (Utilizada por el DAO, Service y Controller de inicio)
  */
case class Equipo(ip: String, nombre: String, mac: String, usuarioSSH: String, passwordSSH: String, descripcion: String, idSala: Long)
