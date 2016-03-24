package model.table

import model.{RolUsuario, UsuarioWeb}
import slick.driver.MySQLDriver.api._
import slick.lifted.ProvenShape

/**
  * Mapeo de la tabla UsuarioWeb con Slick
  *
  * @param tag
  */
class UsuarioWebTable(tag: Tag) extends Table[UsuarioWeb](tag, "UsuarioWeb") {

  // Clave primaria
  def usuario = column[Long]("usuarioweb_usuario", O.PrimaryKey)

  // Otras columnas/atributos
  def password = column[String]("usuarioweb_password")

  def idRolUsuario = column[Long]("usuarioweb_rolusuario_id")

  // Clave foránea hacia RolUsuario
  def rolUsuario = foreignKey("usuarioweb_rolusuario_fk", idRolUsuario, TableQuery[RolUsuarioTable])(_.id)

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * : ProvenShape[UsuarioWeb] =
    (id, nombre, mediosaudiovisuales, enseres, idRolUsuario) <>(UsuarioWeb.tupled, UsuarioWeb.unapply)
}
