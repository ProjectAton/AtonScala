package model.table

import model.Laboratory
import slick.driver.MySQLDriver.api._
import slick.lifted.ProvenShape

/**
  * Mapeo de la tabla Laboratory con Slick
  *
  * @param tag
  */
class LaboratoryTable(tag: Tag) extends Table[Laboratory](tag, "Laboratory") {

  // All tables need the * method with the type that it was created the table with.
  override def * : ProvenShape[Laboratory] =
    (id, nombre, ubicacion, administracion) <>(Laboratory.tupled, Laboratory.unapply)

  // Primary key
  def id = column[Long]("laboratorio_id", O.PrimaryKey, O.AutoInc)

  // Other columns/attributes
  def nombre = column[String]("laboratorio_nombre")

  def ubicacion = column[String]("laboratorio_ubicacion")

  def administracion = column[String]("laboratorio_administracion")
}
