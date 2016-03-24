package model

/**
  * POJO con la información básica de Laboratorio (Utilizada por el DAO, Service y Controller de laboratorio)
  */
case class Laboratorio(id: Long, nombre: String, ubicacion: String, administracion: String)
