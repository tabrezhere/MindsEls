package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class UserTerm (id : Long,user_id : Long, term_id : Int, active : Int,deleted : Int)

object UserTerm {
  
  implicit val userTermWrites = new Writes[UserTerm] {
    def writes(utrm: UserTerm): JsValue = Json.obj(
      "id" -> utrm.id,
      "user_id" -> utrm.user_id,
      "term_id" -> utrm.term_id,
      "active" -> utrm.active,
      "deleted" -> utrm.deleted)
  }
  
   implicit val reads: Reads[UserTerm] = (
    (__ \ "id").read[Long] ~
    (__ \ "user_id").read[Long] ~
    (__ \ "term_id").read[Int] ~
    (__ \ "active").read[Int] ~
    (__ \ "deleted").read[Int])(UserTerm.apply( _, _, _, _, _))
}