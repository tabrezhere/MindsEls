package security.models
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.sql.Date

case class SendSMS(
phonenumber : Long,
message : String)

object SendSMS {
  implicit val reads: Reads[SendSMS] = (
    (JsPath \ "phonenumber").read[Long] ~
    (JsPath \ "message").read[String])(SendSMS.apply( _, _))
}