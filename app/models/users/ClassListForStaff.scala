package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
 * @ClassListForStaff ilyas
 */
case class ClassListForStaff (
   classId : Long,
   className : String
)

object ClassListForStaff {
  
  implicit val ClassListForStaffWrites = new Writes[ClassListForStaff] {
    def writes(a: ClassListForStaff): JsValue = Json.obj(
      "classId" -> a.classId,
      "className" -> a.className)
  }
  
   implicit val ClassListForStaffreads: Reads[ClassListForStaff] = (
    (__ \ "classId").read[Long] ~
    (__ \ "className").read[String])(ClassListForStaff.apply(_, _))
}