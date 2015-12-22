package dtos

import models.users.Staff
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._


case class StaffDTO(
  val id: Long,
  val user_context_id : Long
)
  
object StaffDTO {
  
  //implicit val userDTOWrites: Writes[UserDTO] = new Writes[UserDTO] {
  
  implicit val userDTOWrites: Writes[StaffDTO] = new Writes[StaffDTO] {
    override def writes(s: StaffDTO): JsValue = {
      Json.obj(
        "id" -> s.id,
        "user_context_id" -> s.user_context_id)
    }
  }

 def apply(s: Staff): StaffDTO = StaffDTO(
      id = s.id,
     user_context_id=s.userId)
}   