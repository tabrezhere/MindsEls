package security.models

import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

/**
 * Case class for signUp element
 */
case class SignUp(
  identifier: String,
  password: String,
  firstName: Option[String],
  middleName: Option[String],
  lastName: Option[String],
  DOB : Option[String],
  Gender : Option[String],
  address1: Option[String],
  address2: Option[String],
  city : Option[String],
  state : Option[String],
  phoneNumber : Option[Long],
  contextId : Long,
  campusId : Long
  
  

)

object SignUp {
  implicit val restFormat = SignUpFormat.restFormat
}

object SignUpFormat {
  implicit val restFormat = (
    (__ \ "identifier").format[String] ~
    (__ \ "password").format[String] ~
    (__ \ "firstName").formatNullable[String] ~
    (__ \ "middleName").formatNullable[String] ~
    (__ \ "lastName").formatNullable[String] ~
     (__ \ "DOB").formatNullable[String] ~
    (__ \ "Gender").formatNullable[String] ~
    (__ \ "address1").formatNullable[String] ~
    (__ \ "address2").formatNullable[String] ~
    (__ \ "city").formatNullable[String] ~
    (__ \ "state").formatNullable[String] ~
    (__ \ "phoneNumber").formatNullable[Long] ~
    (__ \ "contextId").format[Long] ~
    (__ \ "campusId").format[Long])(SignUp.apply, unlift(SignUp.unapply))
}