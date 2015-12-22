package controllers

import models.users.User
import com.mohiva.play.silhouette.core.{ LogoutEvent, Environment, Silhouette }
import com.mohiva.play.silhouette.contrib.authenticators.HeaderAuthenticator
import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json._
import javax.inject.Inject
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.mvc.Action
//import it.innove.play.pdf.PdfGenerator
import play.api.mvc.RequestHeader


/**
 * The basic application controller.
 *
 * @param env The Silhouette environment.
 */
class ApplicationController @Inject() (implicit val env: Environment[User, HeaderAuthenticator])
  extends Silhouette[User, HeaderAuthenticator] {

  def index = Action {
    Ok(views.html.index())
  }
  
  private def host(implicit request: RequestHeader): String = {
    s"http://${request.host}/"
  }
  
  /*def letter: Action[AnyContent] = Action { implicit request =>
    Ok(PdfGenerator.toBytes(views.html.letter("Play!ng PDF"), host)).as("application/pdf")
  }*/

  /**
   * This action has been used to generate example 1 pdf from the newsletter template
   *
   * @return
   */
  /*def newsletter: Action[AnyContent] = Action { implicit request =>
    Ok(PdfGenerator.toBytes(views.html.newsletter("Play!ng PDF"), host)).as("application/pdf")
  }*/
  
}
