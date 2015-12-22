package controllers

import services.UserService
import javax.inject.Inject
import utils.responses.rest._
import models.users.User
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.concurrent.Execution.Implicits._
import com.mohiva.play.silhouette.core._
import com.mohiva.play.silhouette.core.providers._
import com.mohiva.play.silhouette.core.exceptions._
import com.mohiva.play.silhouette.core.services.AuthInfoService
import com.mohiva.play.silhouette.contrib.authenticators.HeaderAuthenticator
import scala.concurrent.{ Future }
import com.mohiva.play.silhouette.contrib.authenticators.CookieAuthenticator
import security.models._


import models.services.StudentService


class RestStudentController @Inject() (
 implicit val env: Environment[User, CookieAuthenticator], userService : UserService, studentService : StudentService,
  val authInfoService: AuthInfoService) extends Silhouette[User, CookieAuthenticator] {
  
    implicit val restCredentialFormat = security.formatters.json.CredentialFormat.restFormat
    
   /* def save = UserAwareAction.async(parse.json) { implicit request =>
    (request.body.validate[User], request.body.validate[StudentDetails]) match {
      case (JsSuccess(user, _), JsSuccess(studentDetails, _)) =>
          Future.successful(Ok(Json.obj{"message" -> JsString(s"we've got 2 objects, $user and $studentDetails")}))
      case (_, _) => Future.successful(Ok("unexpected data"))
    }
  }*/
  
  

}