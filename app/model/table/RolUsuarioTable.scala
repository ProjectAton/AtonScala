package model.table

import model.RolUsuario
import slick.lifted.ProvenShape
import slick.driver.MySQLDriver.api._

/**
  * Mapeo de la tabla RolUsuario con Slick
  *
  * @param tag
  */
class RolUsuarioTable(tag: Tag) extends Table[RolUsuario](tag, "RolUsuario") {

  // Clave primaria
  def id = column[Long]("rolusuario_id", O.PrimaryKey, O.AutoInc)

  // Otras columnas/atributos
  def rol = column[String]("rolusuario_rol")

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * : ProvenShape[RolUsuario] =
    (id, rol) <>(RolUsuario.tupled, RolUsuario.unapply)
}
