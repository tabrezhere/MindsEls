package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date



case class StudentDetailForGuardian (
firstName : Option[String],
middleName : Option[String],
lastName : Option[String],
stdAdmissionNumber : String
 )
 
object StudentDetailForGuardian {
  
  implicit val StudentDetailForGuardianWrites = new Writes[StudentDetailForGuardian] {
    def writes(stdGua: StudentDetailForGuardian): JsValue = Json.obj(
      "firstName" -> stdGua.firstName,
      "middleName" -> stdGua.middleName,
      "lastName" -> stdGua.lastName,
      "stdAdmissionNumber"-> stdGua.stdAdmissionNumber)
  }
  
  
  implicit val reads: Reads[StudentDetailForGuardian] = (
    (__ \ "firstName").read[Option[String]] ~
    (__ \ "middleName").read[Option[String]] ~
    (__ \ "lastName").read[Option[String]] ~
    (__ \ "stdAdmissionNumber").read[String])(StudentDetailForGuardian.apply( _, _, _, _))

}