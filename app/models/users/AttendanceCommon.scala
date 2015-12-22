package models.users


import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class AttendanceCommon (

    user_id : Long,
    Studentadminno : String,
    Firstname : String,
    className : String,
    campusName : String,
    orgName : String 
)

object AttendanceCommon{
  
   implicit val AttendanceCommonWrites = new Writes[AttendanceCommon] {
    def writes(atdUser: AttendanceCommon): JsValue = Json.obj(
     
      "user_id" -> atdUser.user_id,
      "Studentadminno" -> atdUser.Studentadminno,
      "Firstname" -> atdUser.Firstname,
      "className" -> atdUser.className,
      "campusName" -> atdUser.campusName,
      "orgName" -> atdUser.orgName)
  }
  
   implicit val reads: Reads[AttendanceCommon] = (
    
    (__ \ "user_id").read[Long] ~
    (__ \ "Studentadminno").read[String] ~
    (__ \ "Firstname").read[String] ~
    (__ \ "className").read[String] ~
    (__ \ "campusName").read[String] ~
    (__ \ "orgName").read[String])(AttendanceCommon.apply(_, _, _, _, _, _))
  
}