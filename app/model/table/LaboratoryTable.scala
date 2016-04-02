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

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * : ProvenShape[Laboratory] =
    (id, nombre, ubicacion, administracion) <>(Laboratory.tupled, Laboratory.unapply)

  // Clave primaria
  def id = column[Long]("laboratorio_id", O.PrimaryKey, O.AutoInc)

  // Otras columnas/atributos
  def nombre = column[String]("laboratorio_nombre")

  def ubicacion = column[String]("laboratorio_ubicacion")

  def administracion = column[String]("laboratorio_administracion")
}
