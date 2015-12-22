package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class CreateVehicleDetailUser(
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
    vehicleName : String,
    rdId : Int,
    routeName : String,
    campusId : Long,
    No_of_Stops : Int
)

object CreateVehicleDetailUser {
  
  implicit val createVehicleDetailsWrites = new Writes[CreateVehicleDetailUser] {
    def writes(cvd: CreateVehicleDetailUser): JsValue = Json.obj(
      "id" -> cvd.id,
      "Vehicle_no" -> cvd.Vehicle_no,
      "Vehicle_code" -> cvd.Vehicle_code,
      "No_of_Seat" -> cvd.No_of_Seat,
      "Maximum_capacity" -> cvd.Maximum_capacity,
      "insurance" -> cvd.insurance,
      "tax_remitted" -> cvd.tax_remitted,
      "permit" -> cvd.permit,
      "status" -> cvd.status,
      "Vehicle_type_id" -> cvd.Vehicle_type_id,   
      "vehicleName" -> cvd.vehicleName,
      "rdId" -> cvd.rdId,
      "routeName" -> cvd.routeName,
      "campusId" -> cvd.campusId,
      "No_of_Stops" -> cvd.No_of_Stops)
  }
  
   implicit val reads: Reads[CreateVehicleDetailUser] = (
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
    (__ \ "vehicleName").read[String] ~
    (__ \ "rdId").read[Int] ~
    (__ \ "routeName").read[String] ~
    (__ \ "campusId").read[Long] ~
    (__ \ "No_of_Stops").read[Int])(CreateVehicleDetailUser.apply( _, _, _, _, _, _, _, _, _, _, _, _, _, _, _))
  
}