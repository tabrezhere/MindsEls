package models.users

import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class StaffClassMap (id : Long,classId : Long,userId : Long)

object StaffClassMap {
  
  implicit val staffClassMapWrites = new Writes[StaffClassMap] {
    def writes(b: StaffClassMap): JsValue = Json.obj(
      "id" -> b.id,
      "classId" -> b.classId,
      "userId" -> b.userId)
  }
  
   implicit val reads: Reads[StaffClassMap] = (
    (__ \ "id").read[Long] ~
    (__ \ "classId").read[Long] ~
    (__ \ "userId").read[Long])(StaffClassMap.apply(_, _, _))
}
