package controllers

import play.api.mvc.Controller
import view.LoginForm
import views.forms.LoginForm
import views.html.helper.form

import scala.concurrent.Future

/**
  * Created by camilo on 23/03/16.
  */
class SecurityController extends Controller {
  def login() = Ok(views.html.login)
  def autenticar = { implicit request => {
    LoginForm.form.bindFromRequest.fold(
      errorForm => Future.successful(Ok(request))
      data =>
    )
  }
  }
}
