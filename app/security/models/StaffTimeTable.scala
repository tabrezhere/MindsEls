package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class StaffTimeTable (classId : Long,subjectId : Long, staffId : Long)

object StaffTimeTable {
  implicit val reads: Reads[StaffTimeTable] = (
    (JsPath \ "classId").read[Long] ~
    (JsPath \ "subjectId").read[Long] ~
    (JsPath \ "staffId").read[Long])(StaffTimeTable.apply( _, _, _))
  
}