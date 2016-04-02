package model

/**
  * POJO con la información básica de Sesion (Utilizada por el DAO, Service y Controller de sesion)
  */
case class Sesion(ipEquipo: String, fecha: java.sql.Timestamp, usuarioConectado: String, activa: Boolean)
