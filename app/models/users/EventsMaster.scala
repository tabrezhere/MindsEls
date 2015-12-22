package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class EventsMaster (
    evId: Long,
    Name : String, 
    desc : String,
    campusId : Long,
    status : Int
 )
 
 object EventsMaster {
  
  implicit val EventsMasterWrites = new Writes[EventsMaster] {
    def writes(evnt: EventsMaster): JsValue = Json.obj(
      "evId" -> evnt.evId,
      "Name" -> evnt.Name,
      "desc" -> evnt.desc,
      "campusId" ->evnt.campusId,
      "status" -> evnt.status
      )
  }
 
 implicit val reads: Reads[EventsMaster] = (
    (__ \ "evId").read[Long] ~
    (__ \ "Name").read[String] ~
    (__ \ "desc").read[String] ~
    (__ \ "campusId").read[Long] ~
    (__ \ "status").read[Int])(EventsMaster.apply( _, _, _, _, _))
}
