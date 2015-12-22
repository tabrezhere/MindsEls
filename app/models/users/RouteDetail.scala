package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._


case class RouteDetail (
rdId : Int,
Route_Name : String,
No_of_Stops : Int,
Vehicle_id : Long
)

object RouteDetail {
  
  implicit val routeDetailsWrites = new Writes[RouteDetail] {
    def writes(rdl: RouteDetail): JsValue = Json.obj(
      "rdId" -> rdl.rdId,
      "Route_Name" -> rdl.Route_Name,
      "No_of_Stops" -> rdl.No_of_Stops,
      "Vehicle_id" -> rdl.Vehicle_id)
  }
  
   implicit val reads: Reads[RouteDetail] = (
    (__ \ "rdId").read[Int] ~
    (__ \ "Route_Name").read[String] ~
    (__ \ "No_of_Stops").read[Int] ~
    (__ \ "Vehicle_id").read[Long])(RouteDetail.apply( _, _, _, _))
  
}