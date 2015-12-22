package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class VehicleRouteStopDetails(
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
    RouteId : Int,
    No_of_Stops : Int,
    Route_Name : String,
    StopDetailsList : List[StopDetail]


)

object VehicleRouteStopDetails {
  
  implicit val vehicleRouteStopDetailsWrites = new Writes[VehicleRouteStopDetails] {
    def writes(vrsd: VehicleRouteStopDetails): JsValue = Json.obj(
      "id" -> vrsd.id,
      "Vehicle_no" -> vrsd.Vehicle_no,
      "Vehicle_code" -> vrsd.Vehicle_code,
      "No_of_Seat" -> vrsd.No_of_Seat,
      "Maximum_capacity" -> vrsd.Maximum_capacity,
      "insurance" -> vrsd.insurance,
      "tax_remitted" -> vrsd.tax_remitted,
      "permit" -> vrsd.permit,
      "status" -> vrsd.status,
      "Vehicle_type_id" -> vrsd.Vehicle_type_id,      
      "RouteId" -> vrsd.RouteId,
      "No_of_Stops" -> vrsd.No_of_Stops,
      "Route_Name" -> vrsd.Route_Name,
      "StopDetailsList" -> vrsd.StopDetailsList)
  }
  
   implicit val reads: Reads[VehicleRouteStopDetails] = (
    (__ \ "id").read[Int] ~
    (__ \ "Vehicle_no").read[String] ~
    (__ \ "Vehicle_code").read[String] ~
    (__ \ "No_of_Seat").read[Int] ~
    (__ \ "Maximum_capacity").read[Int] ~
    (__ \ "insurance").read[String] ~
    (__ \ "tax_remitted").read[String] ~
    (__ \ "permit").read[String] ~
    (__ \ "status").read[String] ~
    (__ \ "Vehicle_type_id").read[Int] ~
    (__ \ "RouteId").read[Int] ~
    (__ \ "No_of_Stops").read[Int] ~
    (__ \ "Route_Name").read[String] ~
    (__ \ "StopDetailsList").read[List[StopDetail]])(VehicleRouteStopDetails.apply( _, _, _, _, _, _, _, _, _, _, _, _, _, _))
}