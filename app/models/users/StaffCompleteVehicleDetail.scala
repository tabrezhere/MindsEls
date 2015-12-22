package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import security.models.StaffDetail

/**
 * @author ilyas
 */
case class StaffCompleteVehicleDetail (
staffDetail : StaffDetail,
vehicleDetail : CreateVehicleDetailUser,
StopDetailsList : List[StopDetail],
vehicleType : VehicleType
) 


object StaffCompleteVehicleDetail {
  
  implicit val StaffCompleteVehicleDetailWrites = new Writes[StaffCompleteVehicleDetail] {
    def writes(vrsd: StaffCompleteVehicleDetail): JsValue = Json.obj(
      "staffDetail" -> vrsd.staffDetail,
      "vehicleDetail" -> vrsd.vehicleDetail,
      "StopDetailsList" -> vrsd.StopDetailsList,
      "vehicleType" -> vrsd.vehicleType)
  }
  
   implicit val reads: Reads[StaffCompleteVehicleDetail] = (
    (__ \ "staffDetail").read[StaffDetail] ~
    (__ \ "vehicleDetail").read[CreateVehicleDetailUser] ~
    (__ \ "StopDetailsList").read[List[StopDetail]] ~
    (__ \ "vehicleType").read[VehicleType])(StaffCompleteVehicleDetail.apply( _, _, _, _))
}