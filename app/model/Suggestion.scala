package model

/**
  * POJO con la información básica de Suggestion (Utilizada por el DAO, Service y Controller de sugerencia)
  */
case class Suggestion(id: Long, sugerencia: String, fecha: java.sql.Timestamp)
