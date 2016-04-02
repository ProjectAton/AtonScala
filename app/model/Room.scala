package model

/**
  * POJO con la información básica de Room (Utilizada por el DAO, Service y Controller de sala)
  */
case class Room(id: Long, nombre: String, mediosAudiovisuales: String, enseres: String, idLaboratorio: Long)
