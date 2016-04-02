package model.table

import java.sql.Timestamp

import model.Suggestion
import slick.driver.MySQLDriver.api._
import slick.lifted.ProvenShape

/**
  * Mapeo de la tabla Suggestion con Slick
  *
  * @param tag
  */
class SuggestionTable(tag: Tag) extends Table[Suggestion](tag, "Suggestion") {

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * : ProvenShape[Suggestion] =
    (id, sugerencia, fecha) <>(Suggestion.tupled, Suggestion.unapply)

  // Clave primaria
  def id = column[Long]("sugerencia_id", O.PrimaryKey, O.AutoInc)

  // Otras columnas/atributos
  def sugerencia = column[String]("sugerencia_sugerencia")

  def fecha = column[Timestamp]("sugerencia_fecha")//(DateMapper.utilDateToSQLTimeStamp)
}
