package model.table

import java.sql.Timestamp

import model.Sesion
import slick.driver.MySQLDriver.api._

/**
  * Mapeo de la tabla Sesion con Slick
  *
  * @param tag
  */
class SesionTable(tag: Tag) extends Table[Sesion](tag, "Sesion") {
  // Clave primaria
  def pk = primaryKey("sesion_pk", (ipEquipo, fecha))

  // Fecha se mapea a java.sql.TimeStamp.
  // Ver: http://stackoverflow.com/questions/31351361/storing-date-and-time-into-mysql-using-slick-scala
  def fecha = column[Timestamp]("sesion_fecha")//(DateMapper.utilDateToSQLTimeStamp)

  // Clave foránea hacia Equipo
  def equipo = foreignKey("equipo_sala_id", ipEquipo, TableQuery[EquipoTable])(_.ip)

  // Otras columnas/atributos
  def ipEquipo = column[String]("sesion_equipo_ip")

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * =
    (ipEquipo, fecha, usuarioConectado, activa) <>(Sesion.tupled, Sesion.unapply)

  def usuarioConectado = column[String]("sesion_usuarioconectado")

  def activa = column[Boolean]("sesion_activa")
}
