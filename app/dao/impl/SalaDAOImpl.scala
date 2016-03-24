package dao.impl

import javax.inject.Inject

import com.google.inject.Singleton
import dao.SalaDAO
import model.Sala
import model.table.SalaTable
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits._
import slick.driver.JdbcProfile

import scala.concurrent.Future

/**
  * Se encarga de implementar las acciones sobre la base de datos
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  * @param dbConfigProvider Inyección del gestor de la base de datos
  */
@Singleton
class SalaDAOImpl @Inject()
(dbConfigProvider: DatabaseConfigProvider) extends SalaDAO {
  /**
    * Configuración de la base de datos
    */
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import driver.api._


  /**
    * Tabla con "todos los salas", similar a select * from sala
    */
  implicit val salas = TableQuery[SalaTable]

  /**
    * Adiciona una sala
    *
    * @param sala Sala a agregar
    * @return String con el mensaje del resultado
    */
  override def add(sala: Sala): Future[String] = {
    // Se realiza un insert y por cada insert se crea un String
    db.run(salas += sala).map(res => "Sala agregada correctamente").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  /**
    * Obtiene una sala según el id
    *
    * @param id Identificador del sala
    * @return Sala encontrado o None si no se encontró
    */
  override def get(id: Long): Future[Option[Sala]] = {
    // Se realiza un select * from sala where id = $id
    db.run(search(id).result.headOption)
  }

  /**
    * Elimina una sala de la base de datos
    *
    * @param id Identificador de la sala
    * @return Resultado de la operación
    */
  override def delete(id: Long): Future[Int] = {
    db.run(search(id).delete)
  }

  /**
    * Lista todas los salas en la base de datos
    *
    * @return Todas las salas
    */
  override def listAll: Future[Seq[Sala]] = {
    db.run(salas.result)
  }

  private def search(id: Long) = salas.filter(_.id === id)
}

