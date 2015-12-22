package models.users

import java.util.Date
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class AttendanceDOIAndUpdatedOn (
    DOI : Date,
    updatedOn : Date
 )
 
 object AttendanceDOIAndUpdatedOn {
  implicit val attendanceDOIAndUpdatedOnWrites = new Writes[AttendanceDOIAndUpdatedOn] {
    def writes(atdUser: AttendanceDOIAndUpdatedOn): JsValue = Json.obj(
      
      "DOI" -> atdUser.DOI,
      "updatedOn"->atdUser.updatedOn)
  }
  
   implicit val reads: Reads[AttendanceDOIAndUpdatedOn] = (
    
    (__ \ "DOI").read[Date]~
    (__ \ "updatedOn").read[Date])(AttendanceDOIAndUpdatedOn.apply(_, _))
}