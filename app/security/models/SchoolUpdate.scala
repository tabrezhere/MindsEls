package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class  SchoolUpdate (
    schoolLogoId : Int,
    Photo_file_name : String,
    Photo_Content_Type :String, 
    Photo_file_Size: String,
    Photo_data_blob :String,
    Campus_ID: Long,
    holidayId : Int
    )


object  SchoolUpdate {
  implicit val reads: Reads[SchoolUpdate] = (
    (JsPath \ "schoolLogoId").read[Int] ~
    (JsPath \ "Photo_file_name").read[String] ~
    (JsPath \ "Photo_Content_Type").read[String] ~
    (JsPath \ "Photo_file_Size").read[String] ~
    (JsPath \ "Photo_data_blob").read[String] ~
    (JsPath \ "Campus_ID").read[Long] ~
    (JsPath \ "holidayId").read[Int])(SchoolUpdate.apply( _, _, _, _, _, _, _))
  
}
