package model.table

import java.sql.Timestamp

import model.Estado
import slick.driver.MySQLDriver.api._

/**
  * Mapeo de la tabla Estado con Slick
  *
  * @param tag
  */
class EstadoTable(tag: Tag) extends Table[Estado](tag, "Estado") {
  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  def * = (ipEquipo, fecha, descripcion) <>(Estado.tupled, Estado.unapply)

  def descripcion = column[String]("estado_descripcion")

  // Clave primaria
  def pk = primaryKey("estado_pk", (ipEquipo, fecha))

  // Otras columnas/atributos
  def ipEquipo = column[String]("estado_equipo_ip")

  // Fecha se mapea a java.sql.TimeStamp.
  // Ver: http://stackoverflow.com/questions/31351361/storing-date-and-time-into-mysql-using-slick-scala
  def fecha = column[Timestamp]("estado_fecha")

  // Clave foránea hacia Equipo
  def equipo = foreignKey("equipo_sala_id", ipEquipo, TableQuery[EquipoTable])(_.ip)
}
