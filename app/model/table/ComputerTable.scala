package model.table

import model.{Computer, Room}
import slick.driver.MySQLDriver.api._
import slick.lifted.{ForeignKeyQuery, ProvenShape}

/**
  * Mapeo de la tabla Computer con Slick
  *
  * @param tag
  */
class ComputerTable(tag: Tag) extends Table[Computer](tag, "Computer") {

  // Otras columnas/atributos
  def nombre = column[String]("equipo_nombre")

  // Clave foránea hacia Room
  def sala: ForeignKeyQuery[RoomTable, Room] = foreignKey("equipo_sala_id", idSala, TableQuery[RoomTable])(_.id)

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * : ProvenShape[Computer] =
    (ip, mac, usuarioSSH, passwordSSH, descripcion, idSala) <>(Computer.tupled, Computer.unapply)

  // Clave primaria
  def ip = column[String]("equipo_ip", O.PrimaryKey)

  def mac = column[String]("equipo_mac")

  def usuarioSSH = column[String]("equipo_usuario_ssh")

  def passwordSSH = column[String]("equipo_password_ssh")

  def descripcion = column[String]("equipo_descripcion")

  def idSala = column[Long]("equipo_sala_id")
}
