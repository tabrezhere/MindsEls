package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class ExamClassMap (
ecmId : Long,
examId : Long,
classId : Long,
termId : Long,
var createdAt : String,
var updateAt : String
)

object ExamClassMap {
  
  implicit val examClassMapWrites = new Writes[ExamClassMap] {
    def writes(exm: ExamClassMap): JsValue = Json.obj(
      "ecmId" -> exm.ecmId,
      "examId" -> exm.examId,
      "classId" -> exm.classId,
      "termId" -> exm.termId,
      "createAt" -> exm.createdAt,
      "updateAt" -> exm.updateAt)
  }
 
 implicit val reads: Reads[ExamClassMap] = (
    (__ \ "ecmId").read[Long] ~
    (__ \ "examId").read[Long] ~
    (__ \ "classId").read[Long] ~
    (__ \ "termId").read[Long] ~
    (__ \ "createdAt").read[String] ~
    (__ \ "updateAt").read[String])(ExamClassMap.apply( _, _, _, _, _, _))
}
