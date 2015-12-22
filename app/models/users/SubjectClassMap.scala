package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class SubjectClassMap (
SubClassId : Long,
subjectId : Long,
classId : Long)

object SubjectClassMap {
  
  implicit val subjectClassMapWrites = new Writes[SubjectClassMap] {
    def writes(exm: SubjectClassMap): JsValue = Json.obj(
      "SubClassId" -> exm.SubClassId,
      "subjectId" -> exm.subjectId,
      "classId" -> exm.classId)
  }
 
 implicit val reads: Reads[SubjectClassMap] = (
    (__ \ "SubClassId").read[Long] ~
    (__ \ "subjectId").read[Long] ~
    (__ \ "classId").read[Long])(SubjectClassMap.apply( _, _, _))
}
