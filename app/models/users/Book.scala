package models.users

import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class Book (id : Int,ISBN : String,Book_title : String,date_of_publication:String, bookCount : Long, campusId : Long)

object Book {
  
  implicit val bookWrites = new Writes[Book] {
    def writes(b: Book): JsValue = Json.obj(
      "id" -> b.id,
      "ISBN" -> b.ISBN,
      "Book_title" -> b.Book_title,
      "date_of_publication"-> b.date_of_publication,
      "bookCount" -> b.bookCount,
      "campusId" -> b.campusId)
  }
  
   implicit val bookreads: Reads[Book] = (
    (__ \ "id").read[Int] ~
    (__ \ "ISBN").read[String] ~
    (__ \ "Book_title").read[String]~
    (__ \ "date_of_publication").read[String] ~
    (__ \ "bookCount").read[Long] ~
    (__ \ "campusId").read[Long])(Book.apply(_, _, _, _, _, _))
}
