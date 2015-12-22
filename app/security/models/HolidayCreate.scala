package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class  HolidayCreate (
    holidayDate : String, 
    holidayName: String,
    hoildayDesc : String,
    campusId : Long
    
    )


object  HolidayCreate {
  implicit val reads: Reads[HolidayCreate] = (
    (JsPath \ "holidayDate").read[String] ~
    (JsPath \ "holidayName").read[String] ~
    (JsPath \ "hoildayDesc").read[String] ~
    (JsPath \ "campusId").read[Long])(HolidayCreate.apply(_, _, _, _))
  
}
