package security.models

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper

case class StaffDetail (id:Long,user_id:Long,vehicleId: Option[Long])

object StaffDetail {
  
   implicit val staffDetailWrites = new Writes[StaffDetail] {
     
       def writes(sd: StaffDetail): JsValue = Json.obj(
        "id" -> sd.id,
        "user_id" -> sd.user_id,
        "vehicleId" -> sd.vehicleId)
  }
   
    implicit val staffDetailReads: Reads[StaffDetail] = (
      (__ \ "id").read[Long] ~
      (__ \ "user_id").read[Long] ~
      (__ \ "vehicleId").read[Option[Long]]) (StaffDetail.apply(_, _, _))
  
}