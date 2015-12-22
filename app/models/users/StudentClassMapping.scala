package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._


case class StudentClassMapping (id:Long,user_id:Long,class_id:Long)

object StudentClassMapping{
  
    implicit val StudentClassMappingWrites = new Writes[StudentClassMapping] {
      def writes(stdClsMap: StudentClassMapping): JsValue = Json.obj(
        "id" -> stdClsMap.id,
        "user_id" -> stdClsMap.user_id,
        "class_id" -> stdClsMap.class_id)
  }
  
  
  implicit val reads: Reads[StudentClassMapping] = (
    (__ \ "id").read[Long] ~
    (__ \ "user_id").read[Long] ~
    (__ \ "class_id").read[Long])(StudentClassMapping.apply( _, _, _))
  
}