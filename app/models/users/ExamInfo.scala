package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class ExamInfo (
    examId : Long,
    examName : String,
    termId : Long,
    classId : Long,
    className : String
)

object ExamInfo {
  
  implicit val examInfoWrites = new Writes[ExamInfo] {
    def writes(exm: ExamInfo): JsValue = Json.obj(
      "examId" -> exm.examId,
      "examName" -> exm.examName,
      "termId" -> exm.termId,
      "classId" -> exm.classId,
      "className" -> exm.className)
  }
 
 implicit val reads: Reads[ExamInfo] = (
    (__ \ "examId").read[Long] ~
    (__ \ "examName").read[String] ~
    (__ \ "termId").read[Long] ~
    (__ \ "classId").read[Long] ~
    (__ \ "className").read[String])(ExamInfo.apply( _, _, _, _, _))
}