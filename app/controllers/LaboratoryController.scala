package controllers

import com.google.inject.Inject
import play.Logger
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}
import service.LaboratoryService
import views.forms.LaboratorioForm

/**
  * Created by camilo on 20/03/16.
  */
class LaboratoryController @Inject()(laboratorioService: LaboratoryService, val messagesApi: MessagesApi) extends Controller with I18nSupport with securesocial.core.SecureSocial {
  def listAll = Action.async { implicit request =>
    Logger.debug("Petición de listar todos los laboratorios con el siguiente request recibida " + request)
    laboratorioService.listAllLaboratories.map { laboratorios =>
      Ok(views.html.inicio(None, "Lista de laboratorios")(views.html.laboratorios(LaboratorioForm.form, laboratorios)))
    }
  }

  def addLaboratorio = UserAwareAction { implicit request =>
    val userName = request.user match {
      case Some(user) => user.fullName
      case _ => "invitado"
    }

    /** LaboratorioForm.form.bindFromRequest.fold(
      * errorForm => Future.successful(Ok(views.html.laboratory(errorForm, Seq.empty[Laboratory]))),
      * data => {
      * Logger.debug("Petición de agregar laboratory con la siguiente información recibida " + data)
      * val nuevoLaboratorio = Laboratory(0, data.nombre, data.administracion, data.ubicacion)
      * laboratorioService.addLaboratory(nuevoLaboratorio).map(res =>
      * Redirect(routes.LaboratoryController.listAll()).flashing(Messages("flass.success") -> res)
      * )
      * }
      * ) */
    Ok("Hello %s".format(userName))
  }

  def deleteLaboratorio(id: Long) = Action.async { implicit request =>
    laboratorioService.deleteLaboratory(id) map { res =>
      Redirect(routes.LaboratoryController.listAll())
    }
  }

  def getLaboratorio(id: Long) = Action.async {implicit request =>
    laboratorioService.getLaboratoryWithChildrenRooms(id) map { res =>
      Ok(views.html.inicio(usuario, rol, "Laboratory")(views.html.laboratorio(res)))
    }
  }
}
