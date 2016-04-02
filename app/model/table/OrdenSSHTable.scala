package model.table

import model.OrdenSSH
import slick.driver.MySQLDriver.api._

/**
  * Mapeo de la tabla OrdenSSH con Slick
  *
  * @param tag
  */
class OrdenSSHTable(tag: Tag) extends Table[OrdenSSH](tag, "OrdenSSH") {

  // Todas las tablas necesitan el método * con el tipo con el que fue creada la tabla
  override def * =
    (id, sudo, interrumpir, ordenSSH, resultado, codigoSalida) <>(OrdenSSH.tupled, OrdenSSH.unapply)

  // Clave primaria
  def id = column[Long]("orden_id", O.PrimaryKey, O.AutoInc)

  // Otras columnas/atributos
  def sudo = column[Boolean]("orden_sudo")

  def interrumpir = column[Boolean]("orden_ubicacion")

  def ordenSSH = column[String]("orden_orden_ssh")

  def resultado = column[String]("orden_resultado")

  def codigoSalida = column[Int]("orden_codigo_salida")
}