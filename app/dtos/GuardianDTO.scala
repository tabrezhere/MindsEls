package dtos

import models.users.Guardian
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._

case class GuardianDTO(
  val id: Long,
  val user_contextid : Long,
  val relationship : String,
  val mobile : Long,
  val income : String,
  val education : String
)
object GuardianDTO {
  
  //implicit val userDTOWrites: Writes[UserDTO] = new Writes[UserDTO] {
  
  implicit val GuardianDTOWrites: Writes[GuardianDTO] = new Writes[GuardianDTO] {
    override def writes(g: GuardianDTO): JsValue = {
      Json.obj(
        "id" -> g.id,
        "user_contextid" -> g.user_contextid,
        "relationship" -> g.relationship,
        "mobile" -> g.mobile,
        "income" -> g.income,
        "education" -> g.education)
    }
  }

 def apply(g: Guardian): GuardianDTO = GuardianDTO(
     id = g.id,
     user_contextid=g.userId,
     relationship = g.relationship,
     mobile = g.mobile,
     income = g.income,
     education = g.education)
}   