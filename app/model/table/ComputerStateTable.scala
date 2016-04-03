package model.table

import java.sql.Timestamp

import model.ComputerState
import slick.driver.MySQLDriver.api._

/**
  * ComputerState table map with Slick
  *
  * @param tag
  */
class ComputerStateTable(tag: Tag) extends Table[ComputerState](tag, "computerstate") {
  // All tables need the * method with the type that it was created the table.
  def * = (computerIp, registeredDate, description) <>(ComputerState.tupled, ComputerState.unapply)

  def description = column[String]("computerstate_description")

  // Primary key
  def pk = primaryKey("computer_state_pk", (computerIp, registeredDate))

  // Other columns/attributes
  def computerIp = column[String]("computer_state_computer_ip")

  // Date mapped to java.sql.TimeStamp.
  // See: http://stackoverflow.com/questions/31351361/storing-date-and-time-into-mysql-using-slick-scala
  def registeredDate = column[Timestamp]("computerstate_registereddate")

  // Computer foreign key
  def computer = foreignKey("computerstate_computer_ip", computerIp, TableQuery[ComputerTable])(_.ip)
}
