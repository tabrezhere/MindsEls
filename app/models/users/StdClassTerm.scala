package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._


case class StdClassTerm (
studentAdminNo : String,
studentName : String,
className : String,
termTypeName : String,
var termStartDate : String,
var termEndDate : String
)

object StdClassTerm {
  implicit val userLoginWrites: Writes[StdClassTerm] = new Writes[StdClassTerm] {
    override def writes(bki: StdClassTerm): JsValue = {
      Json.obj(
        "studentAdminNo" -> bki.studentAdminNo,
        "studentName" -> bki.studentName,
        "className" -> bki.className,
        "termTypeName" -> bki.termTypeName,
        "termStartDate" -> bki.termStartDate,
        "termEndDate" -> bki.termEndDate)
    }
  }
    
   implicit val reads: Reads[StdClassTerm] = (
    (__ \ "studentAdminNo").read[String] ~
    (__ \ "studentName").read[String] ~
    (__ \ "className").read[String] ~
    (__ \ "termTypeName").read[String] ~
    (__ \ "termStartDate").read[String] ~
    (__ \ "termEndDate").read[String])(StdClassTerm.apply( _, _, _, _, _, _))
}