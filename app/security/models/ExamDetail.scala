package security.models
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class ExamDetail(
examId : Long,
termId : Int,
classId : Long
)

object ExamDetail {
  implicit val reads: Reads[ExamDetail] = (
    (JsPath \ "examId").read[Long] ~
    (JsPath \ "termId").read[Int] ~
    (JsPath \ "classId").read[Long])(ExamDetail.apply( _, _, _))
}