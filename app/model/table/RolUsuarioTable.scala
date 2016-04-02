package model.table

import model.RolUsuario
import slick.driver.MySQLDriver.api._
import slick.lifted.ProvenShape

/**
  * Mapeo de la tabla RolUsuario con Slick
  *
  * @param tag
  */
class RolUsuarioTable(tag: Tag) extends Table[RolUsuario](tag, "RolUsuario") {

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * : ProvenShape[RolUsuario] =
    (id, rol) <>(RolUsuario.tupled, RolUsuario.unapply)

  // Clave primaria
  def id = column[Long]("rolusuario_id", O.PrimaryKey, O.AutoInc)

  // Otras columnas/atributos
  def rol = column[String]("rolusuario_rol")
}
