package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class AttendanceUser (

    id : Long,
    stud_id : Long,
    Studentadminno : String,
    Firstname : String,
    remark : Option[String],
    status : Int,
    DOI : Date,
    updatedon:Date,
    className : String,
    campusName : String,
    orgName : String 
)

object AttendanceUser{
  
   implicit val attendanceUserWrites = new Writes[AttendanceUser] {
    def writes(atdUser: AttendanceUser): JsValue = Json.obj(
      "id" -> atdUser.id,
      "stud_id" -> atdUser.stud_id,
      "Studentadminno" -> atdUser.Studentadminno,
      "Firstname" -> atdUser.Firstname,
      "remark" -> atdUser.remark,
      "status" -> atdUser.status,
      "DOI" -> atdUser.DOI,
      "updatedon"->atdUser.updatedon,
      "className" -> atdUser.className,
      "campusName" -> atdUser.campusName,
      "orgName" -> atdUser.orgName)
  }
  
   implicit val reads: Reads[AttendanceUser] = (
    (__ \ "id").read[Long] ~
    (__ \ "stud_id").read[Long] ~
    (__ \ "Studentadminno").read[String] ~
    (__ \ "Firstname").read[String] ~
    (__ \ "remark").read[Option[String]] ~
    (__ \ "status").read[Int]~
    (__ \ "DOI").read[Date]~
    (__ \ "updatedon").read[Date] ~
    (__ \ "className").read[String] ~
    (__ \ "campusName").read[String] ~
    (__ \ "orgName").read[String])(AttendanceUser.apply(_, _, _, _, _, _, _, _, _, _, _))
  
}