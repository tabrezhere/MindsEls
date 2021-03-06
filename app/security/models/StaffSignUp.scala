package security.models

import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class StaffSignUp (
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
    subjectName : String,
    /*role_name : String,*/
    vehicleId : Option[Long]
)

object StaffSignUp {
 /* implicit val restFormat = StaffSignUpFormat.restFormat*/
  
  implicit val reads: Reads[StaffSignUp] = (
		 (JsPath \ "identifier").read[String] ~
		 (JsPath \ "password").read[String] ~
		 (JsPath \ "firstName").readNullable[String] ~
		 (JsPath \ "middleName").readNullable[String] ~
		 (JsPath \ "lastName").readNullable[String] ~
		 (JsPath \ "DOB").readNullable[String] ~
		 (JsPath \ "Gender").readNullable[String] ~
		 (JsPath \ "address1").readNullable[String] ~
		 (JsPath \ "address2").readNullable[String] ~
		 (JsPath \ "city").readNullable[String] ~
		 (JsPath \ "state").readNullable[String] ~
		 (JsPath \ "phoneNumber").readNullable[Long] ~
		 (JsPath \ "contextId").read[Long] ~
		 (JsPath \ "campusId").read[Long] ~
     (JsPath \ "subjectName").read[String] ~
     /*(JsPath \ "role_name").read[String] ~*/
     (JsPath \ "vehicleId").readNullable[Long]) (StaffSignUp.apply(_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _)  
  ) 
  
}


/*object StaffSignUpFormat {
  implicit val restFormat = (
    (__ \ "identifier").format[String] ~
    (__ \ "password").format[String] ~
    (__ \ "firstName").formatNullable[String] ~
    (__ \ "middleName").formatNullable[String] ~
    (__ \ "lastName").formatNullable[String] ~
    (__ \ "DOB").formatNullable[Date] ~
    (__ \ "Gender").formatNullable[String] ~
    (__ \ "address1").formatNullable[String] ~
    (__ \ "address2").formatNullable[String] ~
    (__ \ "city").formatNullable[String] ~
    (__ \ "state").formatNullable[String] ~
    (__ \ "phoneNumber").formatOpt[Long] ~
    (__ \ "contextId").format[Long] ~
    (__ \ "campusId").format[Long]) (StaffSignUp.apply, unlift(StaffSignUp.unapply))
}*/