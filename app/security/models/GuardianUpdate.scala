package security.models

import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class GuardianUpdate (
    userId : Long,
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
	  campusId : Long,
	  relationship : String,
	  mobile : Long,
	  income : String,
	  education : String,
    stdadmissionno : String

)

object GuardianUpdate {
  implicit val restFormat = GuardianUpdateFormat.restFormat
}


object GuardianUpdateFormat {
  implicit val restFormat = (
    (__ \ "userId").format[Long] ~
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
    (__ \ "phoneNumber").formatOpt[Long] ~
    (__ \ "contextId").format[Long] ~
    (__ \ "campusId").format[Long] ~
    (__ \ "relationship").format[String] ~
    (__ \ "mobile").format[Long] ~
    (__ \ "income").format[String] ~
    (__ \ "education").format[String] ~
    (__ \ "stdadmissionno").format[String]) (GuardianUpdate.apply, unlift(GuardianUpdate.unapply))
}