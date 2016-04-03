package model.table

import model.Room
import slick.driver.MySQLDriver.api._
import slick.lifted.ProvenShape

/**
  * Room table map with Slick
  *
  * @param tag
  */
class RoomTable(tag: Tag) extends Table[Room](tag, "room") {

  // Laboratory foreign key
  def laboratory = foreignKey("room_laboratory_fk", laboratoryId, TableQuery[LaboratoryTable])(_.id)

  // All tables need the * method with the type that it was created the table with.
  override def * : ProvenShape[Room] =
    (id, name, audiovisualResources, basicTools, laboratoryId) <>(Room.tupled, Room.unapply)

  // Primary key
  def id = column[Long]("id", O.PrimaryKey)

  // Other columns/attributes
  def name = column[String]("name")

  def audiovisualResources = column[String]("audiovisual_resources")

  def basicTools = column[String]("basic_tools")

  def laboratoryId = column[Long]("laboratory_id")
}
