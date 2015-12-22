package utils.responses.rest

import play.api.libs.json._
import play.api.libs.functional.syntax._

sealed class MsgStatus protected (val status: String, val success: Boolean)
case class MsgStatusOK() extends MsgStatus("OK", true)
case class MsgStatusError() extends MsgStatus("ERROR", false)

object MsgStatus {
  implicit val msgWrites = new Writes[MsgStatus] {
    override def writes(s: MsgStatus): JsValue = {
      Json.obj(
        "status" -> s.status,
        "success" -> s.success)
    }
  }
}
