package model

/**
  * POJO con la información básica de ComputerState (Utilizada por el DAO, Service y Controller de estado)
  */
case class ComputerState(ipEquipo: String, fecha: java.sql.Timestamp, descripcion: String)
