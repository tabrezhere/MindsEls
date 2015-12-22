package security.models
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class ExamTimeTableDetail(ecmapId : Long,subjectId : Long,examDate: String,fromTime: String,toTime: String,status : Int)

object ExamTimeTableDetail{
  implicit val reads: Reads[ExamTimeTableDetail] = (
    (JsPath \ "ecmapId").read[Long] ~
    (JsPath \ "subjectId").read[Long] ~
    (JsPath \ "examDate").read[String] ~
    (JsPath \ "fromTime").read[String] ~
    (JsPath \ "toTime").read[String] ~
    (JsPath \ "status").read[Int])(ExamTimeTableDetail.apply( _, _, _, _, _, _))
}