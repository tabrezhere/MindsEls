package security.models
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.sql.Date

case class SubjectDetail(
SubClassId : Long,
subjectId : Long,
classId : Long)

object SubjectDetail {
  implicit val reads: Reads[SubjectDetail] = (
    (JsPath \ "SubClassId").read[Long] ~
    (JsPath \ "subjectId").read[Long] ~
    (JsPath \ "classId").read[Long])(SubjectDetail.apply( _, _, _))
}