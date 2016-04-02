package model

/**
  * POJO con la información básica de Session (Utilizada por el DAO, Service y Controller de sesion)
  */
case class Session(ipEquipo: String, fecha: java.sql.Timestamp, usuarioConectado: String, activa: Boolean)
