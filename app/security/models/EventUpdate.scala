package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class EventUpdate (eventId : Int,evId : Long,startDate : String, endDate : String,studId : Long, campusId : Long)

object EventUpdate {
  implicit val reads: Reads[EventUpdate] = (
    (JsPath \ "eventId").read[Int] ~
    (JsPath \ "evId").read[Long] ~
    (JsPath \ "startDate").read[String] ~
    (JsPath \ "endDate").read[String] ~
    (JsPath \ "studId").read[Long] ~
    (JsPath \ "campusId").read[Long])(EventUpdate.apply( _, _, _, _, _, _))
  
}