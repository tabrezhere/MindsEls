package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class VehicleType(id : Int, vehicleName : String)

object VehicleType{
  
  implicit val vehicleTypeWrites = new Writes[VehicleType] {
    def writes(vtyp: VehicleType): JsValue = Json.obj(
      "id" -> vtyp.id,
      "vehicleName" -> vtyp.vehicleName)
  }
  
   implicit val reads: Reads[VehicleType] = (
    (__ \ "id").read[Int] ~
    (__ \ "vehicleName").read[String])(VehicleType.apply( _, _))
}




