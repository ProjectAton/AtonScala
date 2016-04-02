package views.forms

import play.api.data.Form
import play.api.data.Forms._

/**
  * Created by camilo on 20/03/16.
  */
case class LaboratorioFormData(nombre: String, ubicacion: String, administracion: String)

object LaboratorioForm {
  val form = Form(
    mapping(
      "nombre" -> nonEmptyText,
      "ubicacion" -> nonEmptyText,
      "administracion" -> nonEmptyText
    )(LaboratorioFormData.apply)(LaboratorioFormData.unapply)
  )
}
