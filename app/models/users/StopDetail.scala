package models.users


import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
//import org.specs2.time.Time

case class StopDetail (
  var id : Int,
  var Stop_Name : String,
  var fare : String,
  var Arival_Mrng : String,
  var Departure_Mrng : String,
  var Arival_Evng : String,
  var Departure_Evng : String,
  var Route_details_id : Int
)

object StopDetail {
  
  implicit val stopDetailsWrites = new Writes[StopDetail] {
    def writes(sdl: StopDetail): JsValue = Json.obj(
      "id" -> sdl.id,
      "Stop_Name" -> sdl.Stop_Name,
      "fare" -> sdl.fare,
      "Arival_Mrng" -> sdl.Arival_Mrng,
      "Departure_Mrng" -> sdl.Departure_Mrng,
      "Arival_Evng" -> sdl.Arival_Evng,
      "Departure_Evng" -> sdl.Departure_Evng,
      "Route_details_id" -> sdl.Route_details_id)
  }
  
   implicit val reads: Reads[StopDetail] = (
    (__ \ "id").read[Int] ~
    (__ \ "Stop_Name").read[String] ~
    (__ \ "fare").read[String] ~
    (__ \ "Arival_Mrng").read[String] ~
    (__ \ "Departure_Mrng").read[String] ~
    (__ \ "Arival_Evng").read[String] ~
    (__ \ "Departure_Evng").read[String] ~
    (__ \ "Route_details_id").read[Int])(StopDetail.apply( _, _, _, _, _, _, _, _))
  
}