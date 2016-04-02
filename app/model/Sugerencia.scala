package model

/**
  * POJO con la información básica de Sugerencia (Utilizada por el DAO, Service y Controller de sugerencia)
  */
case class Sugerencia(id: Long, sugerencia: String, fecha: java.sql.Timestamp)
