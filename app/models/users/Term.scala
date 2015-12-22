package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class Term (id : Long,start_date : Date,end_date : Date,deleted : Int, term_type_id : Int,campus_id : Int,active : Int)

object Term {
  
  implicit val classWrites = new Writes[Term] {
    def writes(trm: Term): JsValue = Json.obj(
      "id" -> trm.id,
      "start_date" -> trm.start_date,
      "end_date" -> trm.end_date,
      "deleted" -> trm.deleted,
      "term_type_id" -> trm.term_type_id,
      "campus_id" -> trm.campus_id,
      "active" -> trm.active)
  }
  
   implicit val reads: Reads[Term] = (
    (__ \ "id").read[Long] ~
    (__ \ "start_date").read[Date] ~
    (__ \ "end_date").read[Date] ~
    (__ \ "deleted").read[Int] ~
    (__ \ "term_type_id").read[Int] ~
    (__ \ "campus_id").read[Int] ~
    (__ \ "active").read[Int])(Term.apply( _, _, _, _, _, _, _))
}
