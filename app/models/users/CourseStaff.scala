package models.users

import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class CourseStaff( id : Long, role_name : String, course_id : Int, Staff_id : Long)

object CourseStaff {
  
  implicit val courseStaffWrites = new Writes[CourseStaff] {
    def writes(cursf: CourseStaff): JsValue = Json.obj(
      "id" -> cursf.id,
      "role_name" -> cursf.role_name,
      "course_id" -> cursf.course_id,
      "Staff_id" -> cursf.Staff_id)
  }
  
   implicit val reads: Reads[CourseStaff] = (
    (__ \ "id").read[Long] ~
    (__ \ "role_name").read[String] ~
    (__ \ "course_id").read[Int] ~ 
    (__ \ "Staff_id").read[Long])(CourseStaff.apply( _, _, _, _))
  
  
}