package dao.impl

import java.sql.Timestamp
import javax.inject.Inject

import com.google.inject.Singleton
import dao.SesionDAO
import model.Sesion
import model.table.SesionTable
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
class SesionDAOImpl @Inject()
(protected val dbConfigProvider: DatabaseConfigProvider, equipoDAOImpl: EquipoDAOImpl) extends SesionDAO with HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._


  /**
    * Tabla con "todos los sesions", similar a select * from sesion
    */
  implicit val sesions = TableQuery[SesionTable]

  /**
    * Adiciona un sesion
    *
    * @param sesion Sesion a agregar
    * @return String con el mensaje del resultado
    */
  override def add(sesion: Sesion): Future[String] = {
    // Se realiza un insert y por cada insert se crea un String
    db.run(sesions += sesion).map(res => "Sesion agregado correctamente").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  /**
    * Obtiene un sesion según el id
    *
    * @param ip    Dirección IP del sesion
    * @param fecha Fecha del sesion
    * @return Sesion encontrado o None si no se encontró
    */
  override def get(ip: String, fecha: Timestamp): Future[Option[Sesion]] = {
    // Se realiza un select * from sesion where id = $id
    db.run(search(ip, fecha).result.headOption)
  }

  private def search(ip: String, fecha: Timestamp) = sesions.filter(a => a.ipEquipo === ip && a.fecha == fecha)

  /**
    * Elimina un sesion de la base de datos
    *
    * @param ip    Dirección IP del sesion
    * @param fecha Fecha del sesion
    * @return Resultado de la operación
    */
  override def delete(ip: String, fecha: Timestamp): Future[Int] = {
    db.run(search(ip, fecha).delete)
  }

  /**
    * Lista todas los sesions en la base de datos
    *
    * @return Todos los sesions
    */
  override def listAll: Future[Seq[Sesion]] = {
    db.run(sesions.result)
  }
}
