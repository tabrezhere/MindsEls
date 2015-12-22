package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class MarksUser (
    marksId : Long,
    examId : Long,
    examName : String,
    classId : Long,
    className : String,
    studentId : Long,
    studentName : String,
    subjectId: Long,
    subjectName : String,
    maxMarks: Long,
    minMarks: Long,
    marksObtained: Long,
    marksInWords : String,
    remarks : String
)

object MarksUser {
  implicit val MarksWrites = new Writes[MarksUser] {
  def writes(mark: MarksUser): JsValue = Json.obj(
      "marksId" -> mark.marksId,
      "examId" -> mark.examId,
      "examName" -> mark.examName,
      "classId" -> mark.classId,
      "className" -> mark.className,
      "studentId" -> mark.studentId,
      "studentName" -> mark.studentName,
      "subjectId" -> mark.subjectId,
      "subjectName" -> mark.subjectName,
      "maxMarks" -> mark.maxMarks,
      "minMarks" -> mark.minMarks,
      "marksObtained" -> mark.marksObtained,
      "marksInWords" -> mark.marksInWords,
      "remarks" -> mark.remarks)
  }
 implicit val reads: Reads[MarksUser] = (
    (__ \ "marksId").read[Long] ~
    (__ \ "examId").read[Long] ~
    (__ \ "examName").read[String] ~
    (__ \ "classId").read[Long] ~
    (__ \ "className").read[String] ~
    (__ \ "studentId").read[Long] ~
    (__ \ "studentName").read[String] ~
    (__ \ "subjectId").read[Long] ~
    (__ \ "subjectName").read[String] ~
    (__ \ "maxMarks").read[Long] ~
    (__ \ "minMarks").read[Long] ~
    (__ \ "marksObtained").read[Long] ~
    (__ \ "marksInWords").read[String] ~
    (__ \ "remarks").read[String])(MarksUser.apply( _, _, _, _, _, _, _, _, _, _, _, _, _, _))
}