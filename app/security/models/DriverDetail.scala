package security.models
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper

case class DriverDetail (id : Long, DLno : String, user_id : Long, vehicleid : Int)

object DriverDetail {
  
   implicit val driverDetailWrites = new Writes[DriverDetail] {
     
       def writes(dd: DriverDetail): JsValue = Json.obj(
        "id" -> dd.id,
        "DLno" -> dd.DLno,
        "user_id" -> dd.user_id,
        "vehicleid" -> dd.vehicleid)
  }
   
    implicit val driverDetailReads: Reads[DriverDetail] = (
      (__ \ "id").read[Long] ~
      (__ \ "DLno").read[String] ~
      (__ \ "user_id").read[Long] ~
      (__ \ "vehicleid").read[Int]) (DriverDetail.apply(_, _, _, _))
  
}