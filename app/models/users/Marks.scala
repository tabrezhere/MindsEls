package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Marks (
    id : Long,
    ecmId : Long,
    studentId : Long,
    subjectId: Long,
    maxMarks: Long,
    minMarks: Long,
    marksObtained: Long,
    marksInWords : String,
    remarks : String
)

object Marks {
  implicit val MarksWrites = new Writes[Marks] {
  def writes(mark: Marks): JsValue = Json.obj(
      "id" -> mark.id,
      "ecmId" -> mark.ecmId,
      "studentId" -> mark.studentId,
      "subjectId" -> mark.subjectId,
      "maxMarks" -> mark.maxMarks,
      "minMarks" -> mark.minMarks,
      "marksObtained" -> mark.marksObtained,
      "marksInWords" -> mark.marksInWords,
      "remarks" -> mark.remarks)
  }
 implicit val reads: Reads[Marks] = (
    (__ \ "id").read[Long] ~
    (__ \ "ecmId").read[Long] ~
    (__ \ "studentId").read[Long] ~
    (__ \ "subjectId").read[Long] ~
    (__ \ "maxMarks").read[Long] ~
    (__ \ "minMarks").read[Long] ~
    (__ \ "marksObtained").read[Long] ~
    (__ \ "marksInWords").read[String] ~
    (__ \ "remarks").read[String])(Marks.apply( _, _, _, _, _, _, _, _, _))
}