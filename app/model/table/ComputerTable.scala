package model.table

import model.{Computer, Room}
import slick.driver.MySQLDriver.api._
import slick.lifted.{ForeignKeyQuery, ProvenShape}

/**
  * Computer table map with Slick
  *
  * @param tag
  */
class ComputerTable(tag: Tag) extends Table[Computer](tag, "computer") {

  // Other columns/attributes
  def name = column[String]("computer_name")

  // Room foreign key
  def room: ForeignKeyQuery[RoomTable, Room] = foreignKey("computer_room_id", roomId, TableQuery[RoomTable])(_.id)

  // All tables need the * method with the type that it was created the table.
  override def * : ProvenShape[Computer] =
    (ip, mac, SSHUser, SSHPassword, description, roomId) <>(Computer.tupled, Computer.unapply)

  // PrimaryKey
  def ip = column[String]("computer_ip", O.PrimaryKey)

  def mac = column[String]("computer_mac")

  def SSHUser = column[String]("computer_ssh_user")

  def SSHPassword = column[String]("computer_ssh_password")

  def description = column[String]("computer_description")

  def roomId = column[Long]("computer_room_id")
}
