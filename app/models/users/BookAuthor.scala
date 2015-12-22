package models.users
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class BookAuthor (
Books_id : Int,
Authors_id : Int
)

object BookAuthor {
  
  implicit val bookAuthorWrites = new Writes[BookAuthor] {
    def writes(ba: BookAuthor): JsValue = Json.obj(
      "Books_id" -> ba.Books_id,
      "Authors_id" -> ba.Authors_id)
  }
  
   implicit val bookAuthorreads: Reads[BookAuthor] = (
    (__ \ "Books_id").read[Int] ~
    (__ \ "Authors_id").read[Int])(BookAuthor.apply(_, _))
}
