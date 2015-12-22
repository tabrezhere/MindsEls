package models.users

import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class StaffUser (
    
  id: Long,
  /*loginInfo: LoginInfo,*/
  email: String,
  /*socials: Option[Seq[LoginInfo]] = None,*/
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
  subjectName : String,
  campusId : Long,
  campusName : String,
  orgId : Long,
  orgName : String,
  vehicleId : Option[Long]

)

object StaffUser {
  
  implicit val staffUserWrites = new Writes[StaffUser] {
    def writes(stafuser: StaffUser): JsValue = Json.obj(
      "id" -> stafuser.id,
      "email" -> stafuser.email,
      "firstName" -> stafuser.firstName,
      "lastName" -> stafuser.lastName,
      "middleName" -> stafuser.middleName,
      "address1" -> stafuser.address1,
      "address2" -> stafuser.address2,
      "city" -> stafuser.city,
      "state" -> stafuser.state,
      "Deleted" -> stafuser.Deleted,
      "context" -> stafuser.context,
      "phoneNumber" -> stafuser.phoneNumber,
      "user_id" -> stafuser.user_id,
      "subjectName" -> stafuser.subjectName,
      "campusId" -> stafuser.campusId,
      "campusName" -> stafuser.campusName,
      "orgId" -> stafuser.orgId,
      "orgName" -> stafuser.orgName,
      "vehicleId" -> stafuser.vehicleId)
  }
  
   implicit val reads: Reads[StaffUser] = (
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
    (__ \ "user_id").read[Long] ~
    (__ \ "subjectName").read[String] ~
    (__ \ "campusId").read[Long] ~
    (__ \ "campusName").read[String] ~
    (__ \ "orgId").read[Long] ~
    (__ \ "orgName").read[String] ~
    (__ \ "vehicleId").read[Option[Long]])(StaffUser.apply( _,_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _))
  
  
}