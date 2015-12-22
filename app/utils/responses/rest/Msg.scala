package utils.responses.rest

import play.api.libs.json._
import play.api.libs.functional.syntax._

sealed class Msg protected (val message: String, val data: Option[JsValue], val status: MsgStatus)
class MsgOK(message: String, data: Option[JsValue]) extends Msg(message, data, MsgStatusOK())
class MsgERR(message: String, data: Option[JsValue]) extends Msg(message, data, MsgStatusError())

object Msg {
  implicit val msgWrites = new Writes[Msg] {
    override def writes(m: Msg): JsValue = {
      Json.obj(
          "message" -> m.message,
          "staus" -> m.status,
          "data" -> m.data
      )
    }
  }

}

object MsgOK {
  def apply(message: String, data: JsValue): MsgOK = new MsgOK(message, Some(data))
  def apply(message: String): MsgOK = new MsgOK(message, None)
}

object MsgERR {
  def apply(message: String, data: JsValue): MsgERR = new MsgERR(message, Some(data))
  def apply(message: String): MsgERR = new MsgERR(message, None)
}