package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class VehicleUpdate (
    vehicleId : Long, 
    Vehicle_no : String, 
    Vehicle_code : String,
    No_of_Seat : Int, 
    Maximum_capacity : Int, 
    insurance : String,
    tax_remitted : String,
    permit : String,
    status : String, 
    Vehicle_type_id : Int,
    Route_Name : String,
    No_of_Stops : Int,
    Stop_Name : String,
    fare : String,
    Arival_Mrng : String,
    Departure_Mrng : String,
    Arival_Evng : String,
    Departure_Evng : String,
    campusId : Long
)


object VehicleUpdate {
  
  implicit val reads: Reads[VehicleUpdate] = (
    (JsPath \ "vehicleId").read[Long] ~
    (JsPath \ "Vehicle_no").read[String] ~
    (JsPath \ "Vehicle_code").read[String] ~
    (JsPath \ "No_of_Seat").read[Int] ~
    (JsPath \ "Maximum_capacity").read[Int] ~
    (JsPath \ "insurance").read[String] ~
    (JsPath \ "tax_remitted").read[String] ~
    (JsPath \ "permit").read[String] ~
    (JsPath \ "status").read[String] ~
    (JsPath \ "Vehicle_type_id").read[Int] ~
    (JsPath \ "Route_Name").read[String] ~
    (JsPath \ "No_of_Stops").read[Int] ~
    (JsPath \ "Stop_Name").read[String] ~
    (JsPath \ "fare").read[String] ~
    (JsPath \ "Arival_Mrng").read[String] ~
    (JsPath \ "Departure_Mrng").read[String] ~
    (JsPath \ "Arival_Evng").read[String] ~
    (JsPath \ "Departure_Evng").read[String] ~
    (JsPath \ "campusId").read[Long])(VehicleUpdate.apply( _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _))
  
}