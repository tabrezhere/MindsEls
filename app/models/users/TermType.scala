package models.users

import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._


case class TermType (id : Long,term_type : String) 
object TermType {
  
  implicit val classWrites = new Writes[TermType] {
    def writes(tty: TermType): JsValue = Json.obj(
      "id" -> tty.id,
      "term_type" -> tty.term_type)
  }
  
   implicit val reads: Reads[TermType] = (
    (__ \ "id").read[Long] ~
    (__ \ "term_type").read[String])(TermType.apply( _, _))
}