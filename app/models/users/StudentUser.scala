package models.users

import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
//import java.util.Date

case class StudentUser (
    
  id: Long,
  /*loginInfo: LoginInfo,*/
  email: String,
  /*socials: Option[Seq[LoginInfo]] = None,*/
  firstName: Option[String],
  lastName: Option[String],
  middleName: Option[String],
  //DOB : Date,
  //gender : String,
  address1: Option[String],
  address2: Option[String],
  city : Option[String],
  state : Option[String],
  Deleted : Option[Long],
  context : String,
  /*detailsId:Long,*/
  user_id: Long,
  Studentadminno : String,
  phoneNumber : Option[Long],
  class_id : Long,
  className : String,
  campusId : Long,
  campusName : String,
  orgId : Long,
  orgName : String,
  vehicleId : Option[Long]/*,
  vehicleName : String,
  termType : String,
  termStartDate : Date,
  termEndDate : Date*/
)

object StudentUser {
  
  implicit val studentUserWrites = new Writes[StudentUser] {
    def writes(stduser: StudentUser): JsValue = Json.obj(
      "id" -> stduser.id,
      "email" -> stduser.email,
      "firstName" -> stduser.firstName,
      "lastName" -> stduser.lastName,
      "middleName" -> stduser.middleName,
     // "DOB" -> stduser.DOB,
      //"gender" -> stduser.gender,
      "address1" -> stduser.address1,
      "address2" -> stduser.address2,
      "city" -> stduser.city,
      "state" -> stduser.state,
      "Deleted" -> stduser.Deleted,
      "context" -> stduser.context,
      "user_id" -> stduser.user_id,
      "Studentadminno" -> stduser.Studentadminno,
      "phoneNumber" -> stduser.phoneNumber,
      "class_id" -> stduser.class_id,
      "className" -> stduser.className,
      "campusId" -> stduser.campusId,
      "campusName" -> stduser.campusName,
      "orgId" -> stduser.orgId,
      "orgName" -> stduser.orgName,
      "vehicleId" -> stduser.vehicleId/*,
      "vehicleName" ->stduser.vehicleName,
      "termType" -> stduser.termType,
      "termStartDate" -> stduser.termStartDate,
      "termEndDate" -> stduser.termEndDate*/)
  }
  
   implicit val reads: Reads[StudentUser] = (
    (__ \ "id").read[Long] ~
    /*(__ \ "loginInfo").read[LoginInfo] ~*/
    (__ \ "email").read[String] ~
    /*(__ \ "socials").read[Option[Seq[LoginInfo]]] ~*/
    (__ \ "firstName").read[Option[String]] ~    
    (__ \ "lastName").read[Option[String]] ~
    (__ \ "middleName").read[Option[String]] ~
    //(__ \ "DOB").read[Date] ~
   // (__ \ "gender").read[String] ~
    (__ \ "address1").read[Option[String]] ~
    (__ \ "address2").read[Option[String]] ~
    (__ \ "city").read[Option[String]] ~
    (__ \ "state").read[Option[String]] ~
    (__ \ "Deleted").read[Option[Long]] ~
    (__ \ "context").read[String] ~
    (__ \ "user_id").read[Long] ~
    (__ \ "Studentadminno").read[String] ~
    (__ \ "phoneNumber").read[Option[Long]] ~
    (__ \ "class_id").read[Long] ~
    (__ \ "className").read[String] ~
    (__ \ "campusId").read[Long] ~
    (__ \ "campusName").read[String] ~
    (__ \ "orgId").read[Long] ~
    (__ \ "orgName").read[String] ~
    (__ \ "vehicleId").read[Option[Long]]/*~
    (__ \ "vehicleName").read[String]~
    (__ \ "termType").read[String] ~
    (__ \ "termStartDate").read[Date] ~
    (__ \ "termEndDate").read[Date]*/)(StudentUser.apply(_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _/*, _, _, _, _, _, _*/))
  
  
}