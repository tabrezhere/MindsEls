package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class MedicalCreate (
    userId : Long,
    Bloodgroup : String,
    height : Float,
    weight : Float,
    ailment : String,
    Doctorname : String, 
    Doctor_address : String,
    Mobile : Option[Long]
    )


object MedicalCreate {
  implicit val reads: Reads[MedicalCreate] = (
    (JsPath \ "userId").read[Long] ~
    (JsPath \ "Bloodgroup").read[String] ~
    (JsPath \ "height").read[Float] ~
    (JsPath \ "weight").read[Float] ~
    (JsPath \ "ailment").read[String] ~
    (JsPath \ "Doctorname").read[String] ~
    (JsPath \ "Doctor_address").read[String] ~
    (JsPath \ "Mobile").readNullable[Long])(MedicalCreate.apply( _, _, _, _, _, _, _, _))
  
}