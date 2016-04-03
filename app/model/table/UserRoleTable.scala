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

  // All tables need the * method with the type that it was created the table with.
  override def * : ProvenShape[UserRole] =
    (id, rol) <>(UserRole.tupled, UserRole.unapply)

  // Primary key
  def id = column[Long]("rolusuario_id", O.PrimaryKey, O.AutoInc)

  // Other columns/attributes
  def rol = column[String]("rolusuario_rol")
}
