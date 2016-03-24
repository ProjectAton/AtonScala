package model.table

import java.sql.Timestamp
import java.util.Date

import model.Sugerencia
import slick.driver.MySQLDriver.api._
import slick.lifted.ProvenShape

/**
  * Mapeo de la tabla Sugerencia con Slick
  *
  * @param tag
  */
class SugerenciaTable(tag: Tag) extends Table[Sugerencia](tag, "Sugerencia") {

  // Clave primaria
  def id = column[Long]("sugerencia_id", O.PrimaryKey, O.AutoInc)

  // Otras columnas/atributos
  def sugerencia = column[String]("sugerencia_sugerencia")

  def fecha = column[Timestamp]("sugerencia_fecha")//(DateMapper.utilDateToSQLTimeStamp)

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * : ProvenShape[Sugerencia] =
    (id, sugerencia, fecha) <>(Sugerencia.tupled, Sugerencia.unapply)
}
