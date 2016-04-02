package model.table

import java.sql.Timestamp

import model.ComputerState
import slick.driver.MySQLDriver.api._

/**
  * Mapeo de la tabla ComputerState con Slick
  *
  * @param tag
  */
class ComputerStateTable(tag: Tag) extends Table[ComputerState](tag, "ComputerState") {
  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  def * = (ipEquipo, fecha, descripcion) <>(ComputerState.tupled, ComputerState.unapply)

  def descripcion = column[String]("estado_descripcion")

  // Clave primaria
  def pk = primaryKey("estado_pk", (ipEquipo, fecha))

  // Otras columnas/atributos
  def ipEquipo = column[String]("estado_equipo_ip")

  // Fecha se mapea a java.sql.TimeStamp.
  // Ver: http://stackoverflow.com/questions/31351361/storing-date-and-time-into-mysql-using-slick-scala
  def fecha = column[Timestamp]("estado_fecha")

  // Clave foránea hacia Computer
  def equipo = foreignKey("equipo_sala_id", ipEquipo, TableQuery[ComputerTable])(_.ip)
}
