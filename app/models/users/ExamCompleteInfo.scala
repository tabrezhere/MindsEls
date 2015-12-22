package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
/**
 * @author ilyas
 */
case class ExamCompleteInfo (
EttId : Long,
subjectId : Long,
subjectName : String,
ecmapId : Long,
classId : Long,
class_name : String,
termId : Long,
term_type : String,
examDate: String,
fromTime: String,
toTime: String,
status : Int,
createdAt : String,
updatedAt : String
)

object ExamCompleteInfo {
  
 implicit val examCompleteInfoWrites = new Writes[ExamCompleteInfo] {
  def writes(exm: ExamCompleteInfo): JsValue = Json.obj(
      "EttId" -> exm.EttId,
      "subjectId" -> exm.subjectId,
      "subjectName" -> exm.subjectName,
      "ecmapId" -> exm.ecmapId,
      "classId" -> exm.classId,
      "class_name" -> exm.class_name,
      "termId" -> exm.termId,
      "term_type" -> exm.term_type,
      "examDate" -> exm.examDate,
      "fromTime" -> exm.fromTime,
      "toTime" -> exm.toTime,
      "status" -> exm.status,
      "createdAt" -> exm.createdAt,
      "updatedAt" -> exm.updatedAt)
 }
 
 implicit val reads: Reads[ExamCompleteInfo] = (
    (__ \ "id").read[Long] ~
    (__ \ "subjectId").read[Long] ~
    (__ \ "subjectName").read[String] ~
    (__ \ "ecmapId").read[Long] ~
    (__ \ "classId").read[Long] ~
    (__ \ "class_name").read[String] ~
    (__ \ "termId").read[Long] ~
    (__ \ "term_type").read[String] ~
    (__ \ "examDate").read[String] ~
    (__ \ "fromTime").read[String] ~
    (__ \ "toTime").read[String] ~
    (__ \ "status").read[Int] ~
    (__ \ "createdAt").read[String] ~
    (__ \ "updatedAt").read[String])(ExamCompleteInfo.apply( _, _, _, _, _, _, _, _, _, _, _, _, _, _))
}

  
