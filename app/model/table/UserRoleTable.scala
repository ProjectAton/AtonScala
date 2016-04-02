package model.table

import model.UserRole
import slick.driver.MySQLDriver.api._
import slick.lifted.ProvenShape

/**
  * Mapeo de la tabla UserRole con Slick
  *
  * @param tag
  */
class UserRoleTable(tag: Tag) extends Table[UserRole](tag, "UserRole") {

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * : ProvenShape[UserRole] =
    (id, rol) <>(UserRole.tupled, UserRole.unapply)

  // Clave primaria
  def id = column[Long]("rolusuario_id", O.PrimaryKey, O.AutoInc)

  // Otras columnas/atributos
  def rol = column[String]("rolusuario_rol")
}
