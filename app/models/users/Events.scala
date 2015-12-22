package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class Events (
    id : Int, 
    evId: Long,
    var startDate : String, 
    var endDate : String,
    studUserId : Long,
    campusId : Long,
    messageFlag : Int
 )
 
 object Events {
  
  implicit val eventsWrites = new Writes[Events] {
    def writes(evnt: Events): JsValue = Json.obj(
      "id" -> evnt.id,
      "evId" -> evnt.evId,
      "startDate" -> evnt.startDate,
      "endDate" -> evnt.endDate,
      "studUserId" -> evnt.studUserId,
      "campusId" ->evnt.campusId,
      "messageFlag" -> evnt.messageFlag
      )
  }
 
 implicit val reads: Reads[Events] = (
    (__ \ "id").read[Int] ~
    (__ \ "evId").read[Long] ~
    (__ \ "startDate").read[String] ~
    (__ \ "endDate").read[String] ~
    (__ \ "studUserId").read[Long] ~
    (__ \ "campusId").read[Long] ~
    (__ \ "messageFlag").read[Int])(Events.apply( _, _, _, _, _, _, _))
}
