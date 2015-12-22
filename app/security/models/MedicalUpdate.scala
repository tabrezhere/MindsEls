package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class MedicalUpdate (
    medicalId : Int,
    userId : Long,
    Bloodgroup : String,
    height : Float,
    weight : Float,
    ailment : String,
    Doctorname : String, 
    Doctor_address : String,
    Mobile : Option[Long]
    )


object MedicalUpdate {
  implicit val reads: Reads[MedicalUpdate] = (
    (JsPath \ "medicalId").read[Int] ~
    (JsPath \ "userId").read[Long] ~
    (JsPath \ "Bloodgroup").read[String] ~
    (JsPath \ "height").read[Float] ~
    (JsPath \ "weight").read[Float] ~
    (JsPath \ "ailment").read[String] ~
    (JsPath \ "Doctorname").read[String] ~
    (JsPath \ "Doctor_address").read[String] ~
    (JsPath \ "Mobile").readNullable[Long])(MedicalUpdate.apply( _, _, _, _, _, _, _, _, _))
  
}