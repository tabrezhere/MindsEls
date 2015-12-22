package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class CourseStaffMapping (id:Long,role_name:String,course_id:Int,user_id : Long)

object CourseStaffMapping{
  
    implicit val CourseStaffMappingWrites = new Writes[CourseStaffMapping] {
      def writes(CursStaMap: CourseStaffMapping): JsValue = Json.obj(
        "id" -> CursStaMap.id,
        "role_name" -> CursStaMap.role_name,
        "course_id" -> CursStaMap.course_id,
        "user_id" -> CursStaMap.user_id)
  }
  
  
  implicit val reads: Reads[CourseStaffMapping] = (
    (__ \ "id").read[Long] ~
    (__ \ "role_name").read[String] ~
    (__ \ "course_id").read[Int] ~
    (__ \ "user_id").read[Long])(CourseStaffMapping.apply( _, _, _, _))
  
}

