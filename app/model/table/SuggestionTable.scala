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

  // All tables need the * method with the type that it was created the table with.
  override def * : ProvenShape[Suggestion] =
    (id, sugerencia, fecha) <>(Suggestion.tupled, Suggestion.unapply)

  // Primary key
  def id = column[Long]("sugerencia_id", O.PrimaryKey, O.AutoInc)

  // Other columns/attributes
  def sugerencia = column[String]("sugerencia_sugerencia")

  def fecha = column[Timestamp]("sugerencia_fecha")//(DateMapper.utilDateToSQLTimeStamp)
}
