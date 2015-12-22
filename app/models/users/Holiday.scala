package models.users

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper
import java.util.Date

case class Holiday(hId:Int, holidayDate:String, holidayName:String, hoildayDesc:String,campusId : Long,messageFlag : Int)


object Holiday {
  
  
  
   implicit val holidayWrites = new Writes[Holiday] {
     
       def writes(ho: Holiday): JsValue = {
         Json.obj(
        "hId" -> ho.hId,
        "holidayDate" -> ho.holidayDate,
        "holidayName" -> ho.holidayName,
        "hoildayDesc" -> ho.hoildayDesc,
        "campusId" -> ho.campusId,
        "messageFlag" -> ho.messageFlag)
       }
  }
   
    implicit val holidayReads: Reads[Holiday] = (
      (__ \ "hId").read[Int] ~
      (__ \ "holidayDate").read[String] ~
      (__ \ "holidayName").read[String] ~
      (__ \ "hoildayDesc").read[String] ~
      (__ \ "campusId").read[Long] ~
      (__ \ "messageFlag").read[Int]) (Holiday.apply(_, _, _, _, _, _))
  
}

