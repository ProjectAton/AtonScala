package model.table

import model.Room
import slick.driver.MySQLDriver.api._
import slick.lifted.ProvenShape

/**
  * Mapeo de la tabla Room con Slick
  *
  * @param tag
  */
class RoomTable(tag: Tag) extends Table[Room](tag, "Room") {

  // Clave foránea hacia Laboratory
  def laboratorio = foreignKey("sala_laboratorio_id", idLaboratorio, TableQuery[LaboratoryTable])(_.id)

  // All tables need the * method with the type that it was created the table with.
  override def * : ProvenShape[Room] =
    (id, nombre, mediosaudiovisuales, enseres, idLaboratorio) <>(Room.tupled, Room.unapply)

  // Primary key
  def id = column[Long]("sala_id", O.PrimaryKey)

  // Other columns/attributes
  def nombre = column[String]("sala_nombre")

  def mediosaudiovisuales = column[String]("sala_mediosaudiovisuales")

  def enseres = column[String]("sala_enseres")

  def idLaboratorio = column[Long]("sala_laboratorio_id")
}
