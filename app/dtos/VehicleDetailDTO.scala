package dtos

import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import models.users.VehicleDetail

case class VehicleDetailDTO (
    val id : Long, 
    val Vehicle_no : String, 
    val Vehicle_code : String,
    val No_of_Seat : Int, 
    val Maximum_capacity : Int, 
    val insurance : String,
    val tax_remitted : String,
    val permit : String,
    val status : String, 
    val Vehicle_type_id : Int
   )

object VehicleDetailDTO {
  
  implicit val VehicleDetailDTOWrites: Writes[VehicleDetailDTO]  = new Writes[VehicleDetailDTO] {
    def writes(vdl: VehicleDetailDTO): JsValue  = {
      Json.obj(
      "id" -> vdl.id,
      "Vehicle_no" -> vdl.Vehicle_no,
      "Vehicle_code" -> vdl.Vehicle_code,
      "No_of_Seat" -> vdl.No_of_Seat,
      "Maximum_capacity" -> vdl.Maximum_capacity,
      "insurance" -> vdl.insurance,
      "tax_remitted" -> vdl.tax_remitted,
      "permit" -> vdl.permit,
      "status" -> vdl.status,
      "Vehicle_type_id" -> vdl.Vehicle_type_id)
  }
  }
  
 /* def apply(u: VehicleDetail): VehicleDetailDTO = VehicleDetailDTO(
      id = u.id,
      Vehicle_no = u.Vehicle_no,
      Vehicle_code = u.Vehicle_code,
      No_of_Seat = u.No_of_Seat,
      Maximum_capacity = u.Maximum_capacity,
      tax_remitted = u.tax_remitted,
      permit = u.permit,
      status = u.status,
      Vehicle_type_id = u.Vehicle_type_id)*/
}