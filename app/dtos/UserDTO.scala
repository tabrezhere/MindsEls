package dtos

import models.users.User
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import java.util.Date

case class UserDTO(
  val id: Long,
  val username: String,
  val firstName: Option[String],
  val middleName: Option[String],
  val lastName: Option[String],  
  val DOB : Option[String],
  val Gender : Option[String],
  val address1: Option[String],
  val address2: Option[String],
  val city : Option[String],
  val state : Option[String],
  val Deleted : Option[Long]

)
  
object UserDTO {
  
  
  implicit val userDTOWrites: Writes[UserDTO] = new Writes[UserDTO] {
    override def writes(u: UserDTO): JsValue = {
      Json.obj(
        "id" -> u.id,
        "username" -> u.username,
        "firstName" -> u.firstName,
         "middleName" -> u.middleName,
        "lastName" -> u.lastName,
        "DOB" -> u.DOB,
        "Gender" -> u.Gender,
        "address1" -> u.address1,
        "address2" -> u.address2,
        "city" -> u.city,
        "state" -> u.state,
        "Deleted" -> u.Deleted)
    }
  }
  
  
  def apply(u: User): UserDTO = UserDTO(
      id = u.id,
      username = u.username,
      firstName = u.firstName,
      middleName = u.middleName,
      lastName = u.lastName,
      DOB = u.DOB,
      Gender = u.Gender,
      address1 = u.address1,
      address2 = u.address2,
      city = u.city,
      state = u.state,
      Deleted = u.Deleted)

}
