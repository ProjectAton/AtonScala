package model.table

import model.SSHOrder
import slick.driver.MySQLDriver.api._

/**
  * Mapeo de la tabla SSHOrder con Slick
  *
  * @param tag
  */
class SSHOrderTable(tag: Tag) extends Table[SSHOrder](tag, "SSHOrder") {

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * =
    (id, sudo, interrumpir, ordenSSH, resultado, codigoSalida) <>(SSHOrder.tupled, SSHOrder.unapply)

  // Clave primaria
  def id = column[Long]("orden_id", O.PrimaryKey, O.AutoInc)

  // Otras columnas/atributos
  def sudo = column[Boolean]("orden_sudo")

  def interrumpir = column[Boolean]("orden_ubicacion")

  def ordenSSH = column[String]("orden_orden_ssh")

  def resultado = column[String]("orden_resultado")

  def codigoSalida = column[Int]("orden_codigo_salida")
}