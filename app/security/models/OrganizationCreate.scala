package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class  OrganizationCreate (
    name : String,
    Type:String,
    activated : Int, 
    paid : Int,
    deleted : Int
    )


object  OrganizationCreate {
  implicit val reads: Reads[OrganizationCreate] = (
    (JsPath \ "name").read[String] ~
    (JsPath \ "Type").read[String] ~
    (JsPath \ "activated").read[Int] ~
    (JsPath \ "paid").read[Int] ~
    (JsPath \ "deleted").read[Int])(OrganizationCreate.apply( _, _, _, _, _))
  
}
