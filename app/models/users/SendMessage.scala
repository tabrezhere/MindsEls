package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class SendMessage(
phoneNumber : Long,
message : String 
)

object SendMessage {
  
  implicit val SendMessageWrites = new Writes[SendMessage] {
    def writes(exm: SendMessage): JsValue = Json.obj(
      "phoneNumber" -> exm.phoneNumber,
      "message" -> exm.message)
  }
 
 implicit val reads: Reads[SendMessage] = (
    (__ \ "phoneNumber").read[Long] ~
    (__ \ "message").read[String])(SendMessage.apply(_, _))
}