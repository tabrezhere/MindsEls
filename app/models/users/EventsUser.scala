package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class EventsUser (
    id : Int, 
    evId: Long,
    name : String,
    desc : String,
    startDate : String, 
    endDate : String,
    studUserId : Long,
    campusId : Long,
    status : Int,
    messageFlag : Int
 )
 
 object EventsUser {
  
  implicit val EventsUserWrites = new Writes[EventsUser] {
    def writes(evnt: EventsUser): JsValue = Json.obj(
      "id" -> evnt.id,
      "evId" -> evnt.evId,
      "name" -> evnt.name,
      "desc" -> evnt.desc,
      "startDate" -> evnt.startDate,
      "endDate" -> evnt.endDate,
      "studUserId" -> evnt.studUserId,
      "campusId" ->evnt.campusId,
      "status" -> evnt.status,
      "messageFlag" -> evnt.messageFlag
      )
  }
 
 implicit val reads: Reads[EventsUser] = (
    (__ \ "id").read[Int] ~
    (__ \ "evId").read[Long] ~
    (__ \ "name").read[String] ~
    (__ \ "desc").read[String] ~
    (__ \ "startDate").read[String] ~
    (__ \ "endDate").read[String] ~
    (__ \ "studUserId").read[Long] ~
    (__ \ "campusId").read[Long] ~
    (__ \ "status").read[Int] ~
    (__ \ "messageFlag").read[Int])(EventsUser.apply( _, _, _, _, _, _, _, _, _, _))
}