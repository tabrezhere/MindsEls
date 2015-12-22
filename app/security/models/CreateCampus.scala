package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class CreateCampus (campus_name : String, campusAddress : String, campusLocation : String, organization_id : Int)

object CreateCampus{
   implicit val reads: Reads[CreateCampus] = (
    (JsPath \ "campus_name").read[String] ~
    (JsPath \ "campusAddress").read[String] ~
    (JsPath \ "campusLocation").read[String] ~
    (JsPath \ "organization_id").read[Int])(CreateCampus.apply( _, _, _, _))
}