package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class AttendanceWithDOIAndUpdatedOnList (
    id : Long,
    stud_id : Long,
    Studentadminno : String,
    remark : Option[String],
    status : Int,
    attendanceDOIAndUpdatedOn : List[AttendanceDOIAndUpdatedOn]
)

object AttendanceWithDOIAndUpdatedOnList{
  implicit val attendanceWithDOIAndUpdatedOnListWrites = new Writes[AttendanceWithDOIAndUpdatedOnList] {
    def writes(attendanceList: AttendanceWithDOIAndUpdatedOnList): JsValue = Json.obj(
      "id" -> attendanceList.id,
      "stud_id" -> attendanceList.stud_id,
      "Studentadminno" -> attendanceList.Studentadminno,
      "remark" -> attendanceList.remark,
      "status" -> attendanceList.status,
      "attendanceDOIAndUpdatedOn" -> attendanceList.attendanceDOIAndUpdatedOn)
  }
  
   implicit val reads: Reads[AttendanceWithDOIAndUpdatedOnList] = (
    (__ \ "id").read[Long] ~
    (__ \ "stud_id").read[Long] ~
    (__ \ "Studentadminno").read[String] ~
    (__ \ "remark").read[Option[String]] ~
    (__ \ "status").read[Int]~
    (__ \ "attendanceDOIAndUpdatedOn").read[List[AttendanceDOIAndUpdatedOn]])(AttendanceWithDOIAndUpdatedOnList.apply(_, _, _, _, _, _))
}