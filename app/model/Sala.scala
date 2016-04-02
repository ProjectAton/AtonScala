package model

/**
  * POJO con la información básica de Sala (Utilizada por el DAO, Service y Controller de sala)
  */
case class Sala(id: Long, nombre: String, mediosAudiovisuales: String, enseres: String, idLaboratorio: Long)
