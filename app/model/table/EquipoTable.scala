package model.table

import model.{Equipo, Sala}
import slick.driver.MySQLDriver.api._
import slick.lifted.{ForeignKeyQuery, ProvenShape}

/**
  * Mapeo de la tabla Equipo con Slick
  *
  * @param tag
  */
class EquipoTable(tag: Tag) extends Table[Equipo](tag, "Equipo") {

  // Otras columnas/atributos
  def nombre = column[String]("equipo_nombre")

  // Clave foránea hacia Sala
  def sala: ForeignKeyQuery[SalaTable, Sala] = foreignKey("equipo_sala_id", idSala, TableQuery[SalaTable])(_.id)

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * : ProvenShape[Equipo] =
    (ip, mac, usuarioSSH, passwordSSH, descripcion, idSala) <>(Equipo.tupled, Equipo.unapply)

  // Clave primaria
  def ip = column[String]("equipo_ip", O.PrimaryKey)

  def mac = column[String]("equipo_mac")

  def usuarioSSH = column[String]("equipo_usuario_ssh")

  def passwordSSH = column[String]("equipo_password_ssh")

  def descripcion = column[String]("equipo_descripcion")

  def idSala = column[Long]("equipo_sala_id")
}
