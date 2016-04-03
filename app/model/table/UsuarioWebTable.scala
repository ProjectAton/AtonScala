package model.table

import model.UsuarioWeb
import slick.driver.MySQLDriver.api._
import slick.lifted.ProvenShape

/**
  * Mapeo de la tabla UsuarioWeb con Slick
  *
  * @param tag
  */
class UsuarioWebTable(tag: Tag) extends Table[UsuarioWeb](tag, "UsuarioWeb") {

  // Primary key
  def usuario = column[Long]("usuarioweb_usuario", O.PrimaryKey)

  // Other columns/attributes
  def password = column[String]("usuarioweb_password")

  // Clave foránea hacia UserRole
  def rolUsuario = foreignKey("usuarioweb_rolusuario_fk", idRolUsuario, TableQuery[UserRoleTable])(_.id)

  def idRolUsuario = column[Long]("usuarioweb_rolusuario_id")

  // All tables need the * method with the type that it was created the table with.
  override def * : ProvenShape[UsuarioWeb] =
    (id, nombre, mediosaudiovisuales, enseres, idRolUsuario) <>(UsuarioWeb.tupled, UsuarioWeb.unapply)
}
