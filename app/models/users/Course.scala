package models.users

import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._



case class Course ( id : Int, course_name : String, deleted : Int, class_id : Long, course_id : Int)

object Course {
  
  implicit val courseWrites = new Writes[Course] {
    def writes(cls: Course): JsValue = Json.obj(
      "id" -> cls.id,
      "course_name" -> cls.course_name,
      "deleted" -> cls.deleted,
      "class_id" -> cls.class_id,
      "course_id" -> cls.course_id)
  }
  
   implicit val reads: Reads[Course] = (
    (__ \ "id").read[Int] ~
    (__ \ "course_name").read[String] ~
    (__ \ "deleted").read[Int] ~ 
    (__ \ "class_id").read[Long] ~
    (__ \ "course_id").read[Int])(Course.apply( _, _, _, _, _))
  
}