package models.users

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper

case class School(id:Long, Photo_file_name:String, Photo_Content_Type:String, Photo_file_Size:String,Photo_data_blob:String,Campus_ID:Long,holidayId : Int)


object School {
  
 
  
   implicit val schoolWrites = new Writes[School] {
     
       def writes(uc: School): JsValue = {
         Json.obj(
        "id" -> uc.id,
        "Photo_file_name" -> uc.Photo_file_name,
        "Photo_Content_Type" -> uc.Photo_Content_Type,
        "Photo_file_Size" -> uc.Photo_file_Size,
        "Photo_data_blob"->uc.Photo_data_blob,
        "Campus_ID"->uc.Campus_ID,
        "holidayId" -> uc.holidayId)
       }
  }
   
    implicit val schoolReads: Reads[School] = (
      (__ \ "id").read[Long] ~
      (__ \ "Photo_file_name").read[String] ~
      (__ \ "Photo_Content_Type").read[String] ~
      (__ \ "Photo_file_Size").read[String]~
      (__ \ "Photo_data_blob").read[String]~
      (__ \ "Campus_ID").read[Long] ~
      (__ \ "holidayId").read[Int]) (School.apply(_, _, _, _, _, _, _))
  
}

