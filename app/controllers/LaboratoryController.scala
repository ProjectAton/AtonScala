package controllers

import com.google.inject.Inject
import model.Laboratory
import play.Logger
import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc.{Action, Controller}
import service.LaboratoryService
import views.forms.LaboratorioForm

import scala.concurrent.Future

/**
  * Created by camilo on 20/03/16.
  */
class LaboratoryController @Inject()(laboratorioService: LaboratoryService, val messagesApi: MessagesApi) extends Controller with I18nSupport {
  def listAll = Action.async { implicit request =>
    Logger.debug("Petición de listar todos los laboratorios con el siguiente request recibida " + request)
    laboratorioService.listAllLaboratorios.map { laboratorios =>
      Ok(views.html.laboratorio(LaboratorioForm.form, laboratorios))
    }
  }

  def addLaboratorio = Action.async { implicit request =>
    LaboratorioForm.form.bindFromRequest.fold(
      errorForm => Future.successful(Ok(views.html.laboratorio(errorForm, Seq.empty[Laboratory]))),
      data => {
        Logger.debug("Petición de agregar laboratorio con la siguiente información recibida " + data)
        val nuevoLaboratorio = Laboratory(0, data.nombre, data.administracion, data.ubicacion)
        laboratorioService.addLaboratorio(nuevoLaboratorio).map(res =>
          Redirect(routes.LaboratoryController.listAll()).flashing(Messages("flass.success") -> res)
        )
      }
    )
  }

  def deleteLaboratorio(id: Long) = Action.async { implicit request =>
    laboratorioService.deleteLaboratorio(id) map { res =>
      Redirect(routes.LaboratoryController.listAll())
    }
  }

  def getLaboratorio(id: Long) = Action.async {implicit request =>
    laboratorioService.getLaboratorioConHijos(id) map { res =>
      Ok(views.html.inicio(usuario, rol, "Laboratory")(views.html.laboratorio(res)))
    }
  }
}
