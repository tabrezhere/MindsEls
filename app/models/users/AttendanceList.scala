package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date
import com.mohiva.play.silhouette.core.LoginInfo



case class AttendanceList(
    id : Long,
    stud_id : Long,
    Studentadminno : String,
    remark : Option[String],
    status : Int,
    var DOI : String,
    var updatedon : String
    )

object AttendanceList{
  
   implicit val attendanceListWrites = new Writes[AttendanceList] {
    def writes(attendanceList: AttendanceList): JsValue = Json.obj(
      "id" -> attendanceList.id,
      "stud_id" -> attendanceList.stud_id,
      "Studentadminno" -> attendanceList.Studentadminno,
      "remark" -> attendanceList.remark,
      "status" -> attendanceList.status,
      "DOI" -> attendanceList.DOI,
      "updatedon"->attendanceList.updatedon)
  }
  
   implicit val reads: Reads[AttendanceList] = (
    (__ \ "id").read[Long] ~
    (__ \ "stud_id").read[Long] ~
    (__ \ "Studentadminno").read[String] ~
    (__ \ "remark").read[Option[String]] ~
    (__ \ "status").read[Int]~
    (__ \ "DOI").read[String]~
    (__ \ "updatedon").read[String])(AttendanceList.apply(_, _, _, _, _, _, _))
  
}