package model

/**
  * POJO con la información básica de Laboratory (Utilizada por el DAO, Service y Controller de laboratorio)
  */
case class Laboratory(id: Long, nombre: String, ubicacion: String, administracion: String)
