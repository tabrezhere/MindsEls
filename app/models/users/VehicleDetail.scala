package models.users
import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import dtos.VehicleDetailDTO

case class VehicleDetail (
    id : Long, 
    Vehicle_no : String, 
    Vehicle_code : String,
    No_of_Seat : Int, 
    Maximum_capacity : Int, 
    insurance : String,
    tax_remitted : String,
    permit : String,
    status : String, 
    Vehicle_type_id : Int,
    campusId : Long)

object VehicleDetail {
  
  /*def apply(u: VehicleDetailDTO): VehicleDetail = VehicleDetail(
      id = u.id,
      Vehicle_no = u.Vehicle_no,
      Vehicle_code = u.Vehicle_code,
      No_of_Seat = u.No_of_Seat,
      Maximum_capacity = u.Maximum_capacity,
      tax_remitted = u.tax_remitted,
      permit = u.permit,
      status = u.status,
      Vehicle_type_id = u.Vehicle_type_id)
  */
  
  implicit val vehicleDetailsWrites = new Writes[VehicleDetail] {
    def writes(vdl: VehicleDetail): JsValue = Json.obj(
      "id" -> vdl.id,
      "Vehicle_no" -> vdl.Vehicle_no,
      "Vehicle_code" -> vdl.Vehicle_code,
      "No_of_Seat" -> vdl.No_of_Seat,
      "Maximum_capacity" -> vdl.Maximum_capacity,
      "insurance" -> vdl.insurance,
      "tax_remitted" -> vdl.tax_remitted,
      "permit" -> vdl.permit,
      "status" -> vdl.status,
      "Vehicle_type_id" -> vdl.Vehicle_type_id,
      "campusId" -> vdl.campusId)
  }
  
   implicit val reads: Reads[VehicleDetail] = (
    (__ \ "id").read[Long] ~
    (__ \ "Vehicle_no").read[String] ~
    (__ \ "Vehicle_code").read[String] ~ 
    (__ \ "No_of_Seat").read[Int] ~
    (__ \ "Maximum_capacity").read[Int] ~ 
    (__ \ "insurance").read[String] ~
    (__ \ "tax_remitted").read[String] ~
    (__ \ "permit").read[String] ~ 
    (__ \ "status").read[String] ~
    (__ \ "Vehicle_type_id").read[Int] ~
    (__ \ "campusId").read[Long])(VehicleDetail.apply( _, _, _, _, _, _, _, _, _, _, _))
  
}

