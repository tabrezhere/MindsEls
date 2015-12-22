package models.users

import com.mohiva.play.silhouette.core.Identity
import com.mohiva.play.silhouette.core.LoginInfo
import java.util.UUID
import play.api.libs.json._
import play.api.libs.functional.syntax._
import models.authorizations._
import dtos.UserDTO
import java.util.Date

/**
 * A user of this platform
 */
case class User(
  id: Long,
  loginInfo: LoginInfo,
  username: String,
  socials: Option[Seq[LoginInfo]] = None,
  firstName: Option[String],
  middleName: Option[String],
  lastName: Option[String],
  DOB : Option[String],
  Gender : Option[String],
  address1: Option[String],
  address2: Option[String],
  city : Option[String],
  state : Option[String],  
  Deleted : Option[Long],
  roles: Set[Role] = Set(SimpleUser)
  ) extends Identity {

}

object User {
  
  def apply(userDTO: UserDTO): User = User(
    id = userDTO.id,
    loginInfo = LoginInfo("credentials", userDTO.username),
    username = userDTO.username,
    socials = None,
    firstName = userDTO.firstName,
    middleName = userDTO.middleName,
    lastName = userDTO.lastName,
    DOB = userDTO.DOB,
    Gender=userDTO.Gender,
    address1 = userDTO.address1,
    address2 = userDTO.address2,
    city = userDTO.city,
    state = userDTO.state,
    Deleted = userDTO.Deleted,
    roles = Set(SimpleUser))

  implicit val userWrites = new Writes[User] {
    def writes(u: User): JsValue = Json.obj(
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
      "Deleted" -> u.Deleted,
      "roles" -> u.roles)
  }
  
   implicit val reads: Reads[User] = (
    (__ \ "id").read[Long] ~
    (__ \ "loginInfo").read[LoginInfo] ~
    (__ \ "username").read[String] ~
    (__ \ "socials").read[Option[Seq[LoginInfo]]] ~
    (__ \ "firstName").read[Option[String]] ~  
    (__ \ "middleName").read[Option[String]] ~
    (__ \ "lastName").read[Option[String]] ~
    (__ \ "DOB").read[Option[String]] ~
    (__ \ "Gender").read[Option[String]] ~
    (__ \ "address1").read[Option[String]] ~
    (__ \ "address2").read[Option[String]] ~
    (__ \ "city").read[Option[String]] ~
    (__ \ "state").read[Option[String]] ~
    (__ \ "Deleted").read[Option[Long]])(User.apply(_,_, _, _, _, _, _, _, _, _, _, _, _, _))
   
}
