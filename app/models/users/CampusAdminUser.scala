package models.users

import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class CampusAdminUser (
    
  id: Long,
  email: String,
  firstName: Option[String],
  lastName: Option[String],
  middleName: Option[String],
  address1: Option[String],
  address2: Option[String],
  city : Option[String],
  state : Option[String],
  Deleted : Option[Long],
  context : String,
  phoneNumber : Option[Long],
  campusId : Long,
  campusName : String,
  orgId : Long,
  orgName : String
)

object CampusAdminUser {
  
  implicit val CampusAdminUserWrites = new Writes[CampusAdminUser] {
    def writes(camAdmUsr: CampusAdminUser): JsValue = Json.obj(
      "id" -> camAdmUsr.id,
      "email" -> camAdmUsr.email,
      "firstName" -> camAdmUsr.firstName,
      "lastName" -> camAdmUsr.lastName,
      "middleName" -> camAdmUsr.middleName,
      "address1" -> camAdmUsr.address1,
      "address2" -> camAdmUsr.address2,
      "city" -> camAdmUsr.city,
      "state" -> camAdmUsr.state,
      "Deleted" -> camAdmUsr.Deleted,
      "context" -> camAdmUsr.context,
      "phoneNumber" -> camAdmUsr.phoneNumber,
      "campusId" -> camAdmUsr.campusId,
      "campusName" -> camAdmUsr.campusName,
      "orgId" -> camAdmUsr.orgId,
      "orgName" -> camAdmUsr.orgName)
  }
  
   implicit val reads: Reads[CampusAdminUser] = (
    (__ \ "id").read[Long] ~
    /*(__ \ "loginInfo").read[LoginInfo] ~*/
    (__ \ "email").read[String] ~
    /*(__ \ "socials").read[Option[Seq[LoginInfo]]] ~*/
    (__ \ "firstName").read[Option[String]] ~    
    (__ \ "lastName").read[Option[String]] ~
    (__ \ "middleName").read[Option[String]] ~
    (__ \ "address1").read[Option[String]] ~
    (__ \ "address2").read[Option[String]] ~
    (__ \ "city").read[Option[String]] ~
    (__ \ "state").read[Option[String]] ~
    (__ \ "Deleted").read[Option[Long]] ~
    (__ \ "context").read[String] ~
    (__ \ "phoneNumber").read[Option[Long]] ~
    (__ \ "campusId").read[Long] ~
    (__ \ "campusName").read[String] ~
    (__ \ "orgId").read[Long] ~
    (__ \ "orgName").read[String])(CampusAdminUser.apply( _,_, _, _, _, _, _, _, _, _, _, _, _, _, _, _))
  
  
}