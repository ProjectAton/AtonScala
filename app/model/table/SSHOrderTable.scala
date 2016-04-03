package model.table

import model.SSHOrder
import slick.driver.MySQLDriver.api._

/**
  * Mapeo de la tabla SSHOrder con Slick
  *
  * @param tag
  */
class SSHOrderTable(tag: Tag) extends Table[SSHOrder](tag, "SSHOrder") {

  // All tables need the * method with the type that it was created the table with.
  override def * =
    (id, sudo, interrumpir, ordenSSH, resultado, codigoSalida) <>(SSHOrder.tupled, SSHOrder.unapply)

  // Primary key
  def id = column[Long]("orden_id", O.PrimaryKey, O.AutoInc)

  // Other columns/attributes
  def sudo = column[Boolean]("orden_sudo")

  def interrumpir = column[Boolean]("orden_ubicacion")

  def ordenSSH = column[String]("orden_orden_ssh")

  def resultado = column[String]("orden_resultado")

  def codigoSalida = column[Int]("orden_codigo_salida")
}