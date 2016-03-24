package model.table

import model.Laboratorio
import slick.driver.MySQLDriver.api._
import slick.lifted.ProvenShape

/**
  * Mapeo de la tabla Laboratorio con Slick
  *
  * @param tag
  */
class LaboratorioTable(tag: Tag) extends Table[Laboratorio](tag, "Laboratorio") {

  // Clave primaria
  def id = column[Long]("laboratorio_id", O.PrimaryKey, O.AutoInc)

  // Otras columnas/atributos
  def nombre = column[String]("laboratorio_nombre")

  def ubicacion = column[String]("laboratorio_ubicacion")

  def administracion = column[String]("laboratorio_administracion")

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * : ProvenShape[Laboratorio] =
    (id, nombre, ubicacion, administracion) <>(Laboratorio.tupled, Laboratorio.unapply)
}
