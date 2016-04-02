package model.table

import java.sql.Timestamp

import model.Session
import slick.driver.MySQLDriver.api._

/**
  * Mapeo de la tabla Session con Slick
  *
  * @param tag
  */
class SessionTable(tag: Tag) extends Table[Session](tag, "Session") {
  // Clave primaria
  def pk = primaryKey("sesion_pk", (ipEquipo, fecha))

  // Clave foránea hacia Computer
  def equipo = foreignKey("equipo_sala_id", ipEquipo, TableQuery[ComputerTable])(_.ip)

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * =
    (ipEquipo, fecha, usuarioConectado, activa) <>(Session.tupled, Session.unapply)

  // Fecha se mapea a java.sql.TimeStamp.
  // Ver: http://stackoverflow.com/questions/31351361/storing-date-and-time-into-mysql-using-slick-scala
  def fecha = column[Timestamp]("sesion_fecha")//(DateMapper.utilDateToSQLTimeStamp)

  // Otras columnas/atributos
  def ipEquipo = column[String]("sesion_equipo_ip")

  def usuarioConectado = column[String]("sesion_usuarioconectado")

  def activa = column[Boolean]("sesion_activa")
}
