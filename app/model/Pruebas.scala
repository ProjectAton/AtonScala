/** package model
  * *
  * import slick.driver.MySQLDriver.api._
  * *
  * import scala.concurrent.ExecutionContext.Implicits.global
  * import scala.concurrent.Await
  * import scala.concurrent.duration.Duration
  * class Prueba {
  * def prueba = {
  * val db = Database.forConfig("mysql")
  * try {
  * val laboratorios = TableQuery[Laboratorio1]
  * val salas = TableQuery[Sala1]
  * val equipos = TableQuery[Equipo]
  * val inserciones = DBIO.seq(
  * laboratorios += (1,"Lab1","Arriba","LIS"),
  * salas += (1,"String1","String2","String3",1),
  * equipos += ("String4","String5","String6","String7","String8",1)
  * )
  * db.run(inserciones)
  * }
  * }
  * }
  */