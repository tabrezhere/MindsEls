package models.users

import dtos.GuardianDTO
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Guardian(
  id: Long,
  userId: Long,
  relationship : String,
  mobile : Long,
  income : String,
  education : String
  ) 
  
  object Guardian {
  
  implicit val guardianWrites = new Writes[Guardian] {
    def writes(g: Guardian): JsValue = Json.obj(
      "id" -> g.id,
      "userId" -> g.userId,
      "relationship" -> g.relationship,
      "mobile" -> g.mobile,
      "income" -> g.income,
      "education" -> g.education)
  }
  
   implicit val guardianreads: Reads[Guardian] = (
    (__ \ "id").read[Long] ~
    (__ \ "userId").read[Long] ~
    (__ \ "relationship").read[String] ~
    (__ \ "mobile").read[Long] ~
    (__ \ "income").read[String] ~
    (__ \ "education").read[String])(Guardian.apply(_, _, _, _, _, _))
   
}
