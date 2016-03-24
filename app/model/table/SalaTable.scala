package model.table

import model.{Laboratorio, Sala}
import slick.driver.MySQLDriver.api._
import slick.lifted.ProvenShape

/**
  * Mapeo de la tabla Sala con Slick
  *
  * @param tag
  */
class SalaTable(tag: Tag) extends Table[Sala](tag, "Sala") {

  // Clave primaria
  def id = column[Long]("sala_id", O.PrimaryKey)

  // Otras columnas/atributos
  def nombre = column[String]("sala_nombre")

  def mediosaudiovisuales = column[String]("sala_mediosaudiovisuales")

  def enseres = column[String]("sala_enseres")

  def idLaboratorio = column[Long]("sala_laboratorio_id")

  // Clave foránea hacia Laboratorio
  def laboratorio = foreignKey("sala_laboratorio_id", idLaboratorio, TableQuery[LaboratorioTable])(_.id)

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * : ProvenShape[Sala] =
    (id, nombre, mediosaudiovisuales, enseres, idLaboratorio) <>(Sala.tupled, Sala.unapply)
}
