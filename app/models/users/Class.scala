package models.users

import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Class (
  id : Long,
  campus_id : Int,
  term_id : Int,  
  class_name : String,
  deleted : Int
)

object Class {
  
  implicit val classWrites = new Writes[Class] {
    def writes(cls: Class): JsValue = Json.obj(
      "id" -> cls.id,
      "campus_id" -> cls.campus_id,
      "term_id" -> cls.term_id,
      "class_name" -> cls.class_name,
      "deleted" -> cls.deleted)
  }
  
   implicit val reads: Reads[Class] = (
    (__ \ "id").read[Long] ~
    (__ \ "campus_id").read[Int] ~
    (__ \ "term_id").read[Int] ~ 
    (__ \ "class_name").read[String] ~
    (__ \ "deleted").read[Int])(Class.apply( _, _, _, _, _))
}