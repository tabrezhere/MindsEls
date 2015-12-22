package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class MarksStudent (
    userId : Long,
    subjectName : String,
    maxMarks: Long,
    minMarks: Long,
    marksObtained: Long,
    marksInWords : String,
    remarks : String
)

object MarksStudent {
  implicit val MarksStudentWrites = new Writes[MarksStudent] {
  def writes(mark: MarksStudent): JsValue = Json.obj(
      "userId" -> mark.userId,
      "subjectName" -> mark.subjectName,
      "maxMarks" -> mark.maxMarks,
      "minMarks" -> mark.minMarks,
      "marksObtained" -> mark.marksObtained,
      "marksInWords" -> mark.marksInWords,
      "remarks" -> mark.remarks)
  }
 implicit val reads: Reads[MarksStudent] = (
    (__ \ "userId").read[Long] ~
    (__ \ "subjectName").read[String] ~
    (__ \ "maxMarks").read[Long] ~
    (__ \ "minMarks").read[Long] ~
    (__ \ "marksObtained").read[Long] ~
    (__ \ "marksInWords").read[String] ~
    (__ \ "remarks").read[String])(MarksStudent.apply( _, _, _, _, _, _, _))
}