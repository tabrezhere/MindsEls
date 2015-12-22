package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class ExamTimeTable (
id : Long,
subjectId : Long,
ecmapId : Long,
examDate: String,
fromTime: String,
toTime: String,
status : Int,
createdAt : String,
updatedAt : String
)

object ExamTimeTable {
  
 implicit val examTimeTableWrites = new Writes[ExamTimeTable] {
  def writes(exm: ExamTimeTable): JsValue = Json.obj(
      "id" -> exm.id,
      "subjectId" -> exm.subjectId,
      "ecmapId" -> exm.ecmapId,
      "examDate" -> exm.examDate,
      "fromTime" -> exm.fromTime,
      "toTime" -> exm.toTime,
      "status" -> exm.status,
      "createdAt" -> exm.createdAt,
      "updatedAt" -> exm.updatedAt)
 }
 
 implicit val reads: Reads[ExamTimeTable] = (
    (__ \ "id").read[Long] ~
    (__ \ "subjectId").read[Long] ~
    (__ \ "ecmapId").read[Long] ~
    (__ \ "examDate").read[String] ~
    (__ \ "fromTime").read[String] ~
    (__ \ "toTime").read[String] ~
    (__ \ "status").read[Int] ~
    (__ \ "createdAt").read[String] ~
    (__ \ "updatedAt").read[String])(ExamTimeTable.apply( _, _, _, _, _, _, _, _, _))
}