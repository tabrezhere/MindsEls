package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class EventCreate (evId : Long,startDate : String, endDate : String,studId : Long, campusId : Long)

object EventCreate {
  implicit val reads: Reads[EventCreate] = (
    (JsPath \ "evId").read[Long] ~
    (JsPath \ "startDate").read[String] ~
    (JsPath \ "endDate").read[String] ~
    (JsPath \ "studId").read[Long] ~
    (JsPath \ "campusId").read[Long])(EventCreate.apply( _, _, _, _, _))
  
}