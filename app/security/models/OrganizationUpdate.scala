package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class  OrganizationUpdate (
    organizationId : Long,
    name : String,
    Type:String,
    activated : Int, 
    paid : Int,
    deleted : Int
    )


object  OrganizationUpdate {
  implicit val reads: Reads[OrganizationUpdate] = (
    (JsPath \ "organizationId").read[Long] ~
    (JsPath \ "name").read[String] ~
    (JsPath \ "Type").read[String] ~
    (JsPath \ "activated").read[Int] ~
    (JsPath \ "paid").read[Int] ~
    (JsPath \ "deleted").read[Int])(OrganizationUpdate.apply( _, _, _, _, _, _))
  
}
