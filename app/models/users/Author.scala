package models.users

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Author (
id : Int,
First_Name : String,
Last_Name : String
)

object Author {
  
  implicit val authorWrites = new Writes[Author] {
    def writes(a: Author): JsValue = Json.obj(
      "id" -> a.id,
      "First_Name" -> a.First_Name,
      "Last_Name" -> a.Last_Name)
  }
  
   implicit val authorreads: Reads[Author] = (
    (__ \ "id").read[Int] ~
    (__ \ "First_Name").read[String] ~
    (__ \ "Last_Name").read[String])(Author.apply(_, _, _))
}