package controllers

import com.google.inject.Inject
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.Controller

/**
  * Created by camilo on 23/03/16.
  */
class UsuarioWebController@Inject()(usuarioService: UsuarioService, val messagesApi: MessagesApi) extends Controller with I18nSupport{

}
