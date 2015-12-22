package controllers

import com.google.inject.Inject
import com.mohiva.play.silhouette.contrib.authenticators.CookieAuthenticator
import com.mohiva.play.silhouette.core.Environment
import com.mohiva.play.silhouette.core.Silhouette
import com.mohiva.play.silhouette.core.services.AuthInfoService
import com.mohiva.play.silhouette.core.services.AvatarService
import com.mohiva.play.silhouette.core.utils.PasswordHasher
import play.api.libs.concurrent.Execution.Implicits._
import models.services.MiscService
import models.users.User
import play.api.libs.json._
import play.api.libs.json.Json.toJson
import play.api.mvc.Action
import models.users.Organization
import scala.concurrent.{ Future }

class MiscController @Inject() (
  implicit val env: Environment[User, CookieAuthenticator],
  val miscService: MiscService,
  val authInfoService: AuthInfoService) extends Silhouette[User, CookieAuthenticator] {  
  
   
   def getUserRolesList = Action.async { request =>
    miscService.getUserRoles().map { userRoles =>
      Ok(toJson(userRoles))
    }
  }
   
  def getAllOrganization = Action.async { request =>
   var organizationList = miscService.getAllOrganization()
      Future(Ok(toJson(organizationList)))
     
   }
   def getAllCampusByOrganizationId(orgId : Int) = Action.async { request =>
     miscService.getAllCampusByOrganizationId(orgId).map { campusUser =>
       Ok(toJson(campusUser))       
     }    
   }
   
   

}

