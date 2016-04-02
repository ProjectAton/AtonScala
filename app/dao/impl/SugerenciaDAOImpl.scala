package dao.impl

import javax.inject.Inject

import com.google.inject.Singleton
import dao.SugerenciaDAO
import model.Sugerencia
import model.table.SugerenciaTable
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
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
class SugerenciaDAOImpl @Inject()
(protected val dbConfigProvider: DatabaseConfigProvider) extends SugerenciaDAO with HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._


  /**
    * Tabla con "todos los sugerencias", similar a select * from sugerencia
    */
  implicit val sugerencias = TableQuery[SugerenciaTable]

  /**
    * Adiciona un sugerencia
    *
    * @param sugerencia Sugerencia a agregar
    * @return String con el mensaje del resultado
    */
  override def add(sugerencia: Sugerencia): Future[String] = {
    // Se realiza un insert y por cada insert se crea un String
    db.run(sugerencias += sugerencia).map(res => "Sugerencia agregado correctamente").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  /**
    * Obtiene un sugerencia según el id
    *
    * @param id Identificador del sugerencia
    * @return Sugerencia encontrado o None si no se encontró
    */
  override def get(id: Long): Future[Option[Sugerencia]] = {
    // Se realiza un select * from sugerencia where id = $id
    db.run(search(id).result.headOption)
  }

  private def search(id: Long) = sugerencias.filter(_.id === id)

  /**
    * Elimina un sugerencia de la base de datos
    *
    * @param id Identificador del sugerencia
    * @return Resultado de la operación
    */
  override def delete(id: Long): Future[Int] = {
    db.run(search(id).delete)
  }

  /**
    * Lista todas los sugerencias en la base de datos
    *
    * @return Todos los sugerencias
    */
  override def listAll: Future[Seq[Sugerencia]] = {
    db.run(sugerencias.result)
  }
}
