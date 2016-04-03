/**
  * == Paquete de clases de mapeo ==
  * Se utiliza para crear objetos según tablas de la base de datos
  */
package model

import slick.driver.MySQLDriver.api._
import slick.lifted.{ForeignKeyQuery, ProvenShape}

/**
  * == Laboratory de la base de datos ==
  *
  * @param tag name de la tabla
  */
class Laboratorio1(tag: Tag)
  extends Table[(Long, String, String, String)](tag, "Laboratory") {

  // All tables need the * method with the type that it was created the table with.
  def * : ProvenShape[(Long, String, String, String)] =
    (id, nombre, ubicacion, administracion)

  // Primary key
  def id = column[Long]("laboratorio_id", O.PrimaryKey)

  // Other columns/attributes
  def nombre = column[String]("laboratorio_nombre")

  def ubicacion = column[String]("laboratorio_ubicacion")

  def administracion = column[String]("laboratorio_administracion")
}

/**
  * == Room de la base de datos ==
  *
  * @param tag name de la tabla
  */
class Sala1(tag: Tag)
  extends Table[(Long, String, String, String, Long)](tag, "Room") {

  def * : ProvenShape[(Long, String, String, String, Long)] =
    (id, nombre, mediosaudiovisuales, enseres, idLaboratorio)

  // Primary key
  def id = column[Long]("sala_id", O.PrimaryKey)

  // Other columns/attributes
  def nombre = column[String]("sala_nombre")

  def mediosaudiovisuales = column[String]("sala_mediosaudiovisuales")

  def enseres = column[String]("sala_enseres")

  // Clave foránea hacia Laboratory
  def laboratorio: ForeignKeyQuery[Laboratorio1, (Long, String, String, String)] =
    foreignKey("sala_laboratorio_id", idLaboratorio, TableQuery[Laboratorio1])(_.id)

  def idLaboratorio = column[Long]("sala_laboratorio_id")
}

/**
  * == Computer de la base de datos ==
  *
  * @param tag name de la tabla
  */
class Equipo1(tag: Tag)
  extends Table[(String, String, String, String, String, Long)](tag, "Computer") {

  def * : ProvenShape[(String, String, String, String, String, Long)] =
    (ip, mac, usuarioSSH, passwordSSH, descripcion, idSala)

  // Primary key
  def ip = column[String]("equipo_ip", O.PrimaryKey)

  // Other columns/attributes
  def mac = column[String]("equipo_mac")

  def usuarioSSH = column[String]("equipo_usuario_ssh")

  def passwordSSH = column[String]("equipo_password_ssh")

  def descripcion = column[String]("equipo_descripcion")

  def idSala = column[Long]("equipo_sala_id")

  // Clave foránea hacia Laboratory
  def sala: ForeignKeyQuery[Sala1, (Long, String, String, String, Long)] =
    foreignKey("equipo_sala_id", idSala, TableQuery[Sala1])(_.id)
}