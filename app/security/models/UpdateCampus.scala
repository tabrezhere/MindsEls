package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class UpdateCampus (
campusId : Long,
campus_name : String, 
campusAddress : String, 
campusLocation : String, 
organization_id : Int)

object UpdateCampus{
   implicit val reads: Reads[UpdateCampus] = (
    (JsPath \ "campusId").read[Long] ~
    (JsPath \ "campus_name").read[String] ~
    (JsPath \ "campusAddress").read[String] ~
    (JsPath \ "campusLocation").read[String] ~
    (JsPath \ "organization_id").read[Int])(UpdateCampus.apply( _, _, _, _, _))
}