package model

/**
  * POJO con la información básica de Estado (Utilizada por el DAO, Service y Controller de estado)
  */
case class Estado(ipEquipo: String, fecha: java.sql.Timestamp, descripcion: String)
