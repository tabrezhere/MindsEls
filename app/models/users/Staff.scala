package models.users


//import dtos.StaffDTO
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Staff(
  id: Long,
  userId : Long,
  vehicleId : Option[Long]
  ) 

object Staff {
  
  implicit val staffWrites = new Writes[Staff] {
    def writes(s: Staff): JsValue = Json.obj(
      "id" -> s.id,
      "userId" -> s.userId,
      "vehicleId" -> s.vehicleId)
  }
  
   implicit val staffreads: Reads[Staff] = (
    (__ \ "id").read[Long] ~
    (__ \ "userId").read[Long] ~
    (__ \ "vehicleId").read[Option[Long]])(Staff.apply(_, _, _))
   
}
