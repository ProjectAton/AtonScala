package views.forms

import play.api.data.Form
import play.api.data.Forms._

case class LoginFormData(usuario: String, password: String)

/**
  * Created by camilo on 23/03/16.
  */
object LoginForm {
  val form = Form(
    mapping(
      "userName" -> nonEmptyText(3, 32),
      "password" -> nonEmptyText
    )(LoginFormData.apply)(LoginFormData.unapply)
  )
}
