package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class Medical (
    id : Long, 
    user_id: Long, 
    Bloodgroup : String,
    height : Float,
    weight : Float,
    ailment: String,
    Doctorname : String, 
    Doctor_address : String,
    Mobile : Option[Long]
 )
 
 object Medical {
  
  implicit val medicalWrites = new Writes[Medical] {
    def writes(mid: Medical): JsValue = Json.obj(
      "id" -> mid.id,
      "user_id" -> mid.user_id,
      "Bloodgroup" -> mid.Bloodgroup,
      "height" -> mid.height,
      "weight" -> mid.weight,
      "ailment" -> mid.ailment,
      "Doctorname" -> mid.Doctorname,
      "Doctor_address" ->mid.Doctor_address,
      "Mobile" -> mid.Mobile
      )
  }
 
 implicit val reads: Reads[Medical] = (
    (__ \ "id").read[Long] ~
    (__ \ "user_id").read[Long] ~
    (__ \ "Bloodgroup").read[String] ~
    (__ \ "height").read[Float] ~
    (__ \ "weight").read[Float] ~
    (__ \ "ailment").read[String] ~
    (__ \ "Doctorname").read[String] ~
    (__ \ "Doctor_address").read[String] ~
    (__ \ "Mobile").read[Option[Long]])(Medical.apply( _, _, _, _, _, _, _, _, _))
}