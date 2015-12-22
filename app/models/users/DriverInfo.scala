package models.users
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper

case class DriverInfo (id : Long, DLno : String, user_id : Long, vehicleid : Int)

object DriverInfo {
  
   implicit val driverInfolWrites = new Writes[DriverInfo] {
     
       def writes(dd: DriverInfo): JsValue = Json.obj(
        "id" -> dd.id,
        "DLno" -> dd.DLno,
        "user_id" -> dd.user_id,
        "vehicleid" -> dd.vehicleid)
  }
   
    implicit val driverInfoReads: Reads[DriverInfo] = (
      (__ \ "id").read[Long] ~
      (__ \ "DLno").read[String] ~
      (__ \ "user_id").read[Long] ~
      (__ \ "vehicleid").read[Int]) (DriverInfo.apply(_, _, _, _))
  
}