package models.users
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class BookCategories (
Books_id : Int,
Book_Categories_id : Int
)

object BookCategories {
  
  implicit val bookCategoriesWrites = new Writes[BookCategories] {
    def writes(ba: BookCategories): JsValue = Json.obj(
      "Books_id" -> ba.Books_id,
      "Book_Categories_id" -> ba.Book_Categories_id)
  }
  
   implicit val bookCategoriesreads: Reads[BookCategories] = (
    (__ \ "Books_id").read[Int] ~
    (__ \ "Book_Categories_id").read[Int])(BookCategories.apply(_, _))
}

