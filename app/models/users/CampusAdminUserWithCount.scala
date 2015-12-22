package models.users


import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class CampusAdminUserWithCount (
  campusAdminUser : CampusAdminUser,
  studentCount : Long,
  staffCount : Long,
  classCount : Long,
  subjectCount : Long,
  examCount : Long,
  librarianCount : Long,
  vehicleCount : Long,
  holidayCount : Long,
  eventCount : Long
)

object CampusAdminUserWithCount {
  
  implicit val CampusAdminUserWithCountWrites = new Writes[CampusAdminUserWithCount] {
    def writes(camAdmUsr: CampusAdminUserWithCount): JsValue = Json.obj(
      "campusAdminUser" -> camAdmUsr.campusAdminUser,
      "studentCount" -> camAdmUsr.studentCount,
      "staffCount" -> camAdmUsr.staffCount,
      "classCount" -> camAdmUsr.classCount,
      "subjectCount" -> camAdmUsr.subjectCount,
      "examCount" -> camAdmUsr.examCount,
      "librarianCount" -> camAdmUsr.librarianCount,
      "vehicleCount" -> camAdmUsr.vehicleCount,
      "holidayCount" -> camAdmUsr.holidayCount,
      "eventCount" -> camAdmUsr.eventCount)
  }
  
   implicit val reads: Reads[CampusAdminUserWithCount] = (
    (__ \ "campusAdminUser").read[CampusAdminUser] ~
    (__ \ "studentCount").read[Long] ~
    (__ \ "staffCount").read[Long] ~
    (__ \ "classCount").read[Long] ~
    (__ \ "subjectCount").read[Long] ~
    (__ \ "examCount").read[Long] ~
    (__ \ "librarianCount").read[Long] ~
    (__ \ "vehicleCount").read[Long] ~
    (__ \ "holidayCount").read[Long] ~
    (__ \ "eventCount").read[Long])(CampusAdminUserWithCount.apply( _, _, _, _, _, _, _, _, _, _))
  
  
}