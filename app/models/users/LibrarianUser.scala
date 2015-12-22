package models.users

import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class LibrarianUser (
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
  user_id:Long,
  campusId : Long,
  campusName : String,
  orgId : Long,
  orgName : String
)

object LibrarianUser {
  
  implicit val librarianUserWrites = new Writes[LibrarianUser] {
    def writes(libusr: LibrarianUser): JsValue = Json.obj(
      "id" -> libusr.id,
      "email" -> libusr.email,
      "firstName" -> libusr.firstName,
      "lastName" -> libusr.lastName,
      "middleName" -> libusr.middleName,
      "address1" -> libusr.address1,
      "address2" -> libusr.address2,
      "city" -> libusr.city,
      "state" -> libusr.state,
      "Deleted" -> libusr.Deleted,
      "context" -> libusr.context,
      "phoneNumber" -> libusr.phoneNumber,
      "user_id" -> libusr.user_id,
       "campusId" -> libusr.campusId,
      "campusName" -> libusr.campusName,
      "orgId" -> libusr.orgId,
      "orgName" -> libusr.orgName)
  }
  
   implicit val reads: Reads[LibrarianUser] = (
    (__ \ "id").read[Long] ~
    (__ \ "email").read[String] ~
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
    (__ \ "user_id").read[Long] ~
     (__ \ "campusId").read[Long] ~
    (__ \ "campusName").read[String] ~
    (__ \ "orgId").read[Long] ~
    (__ \ "orgName").read[String])(LibrarianUser.apply( _,_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _))
  
  
}

