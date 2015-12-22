package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._


case class  HolidayUpdate (hoildayId : Int,holidayDate : String,holidayName: String,hoildayDesc : String,campusId : Long)


object  HolidayUpdate {
  implicit val reads: Reads[HolidayUpdate] = (
    (JsPath \ "hoildayId").read[Int] ~
    (JsPath \ "holidayDate").read[String] ~
    (JsPath \ "holidayName").read[String] ~
    (JsPath \ "hoildayDesc").read[String] ~
    (JsPath \ "campusId").read[Long])(HolidayUpdate.apply(_, _, _, _, _))
  
}
