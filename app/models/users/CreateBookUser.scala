package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class CreateBookUser(
    id : Int,
    First_Name : String, 
    Last_Name: String, 
    ISBN : String,
    Book_title : String, 
    date_of_publication : String,
    bookCount : Long,
    Book_Categories_id : Int,
    bookCategoriesName : String
 )
    
object CreateBookUser {
  
  implicit val createBookUserWrites = new Writes[CreateBookUser] {
    def writes(cbu: CreateBookUser): JsValue = Json.obj(
      "id" -> cbu.id,
      "First_Name" -> cbu.First_Name,
      "Last_Name" -> cbu.Last_Name,
      "ISBN" -> cbu.ISBN,
      "Book_title" -> cbu.Book_title,
      "date_of_publication" -> cbu.date_of_publication,
      "bookCount" -> cbu.bookCount,
      "Book_Categories_id" -> cbu.Book_Categories_id,
      "bookCategoriesName" -> cbu.bookCategoriesName)
  }
  
   implicit val reads: Reads[CreateBookUser] = (
     (__ \ "id").read[Int] ~
     (__ \ "First_Name").read[String] ~
     (__ \ "Last_Name").read[String] ~
     (__ \ "ISBN").read[String] ~
     (__ \ "Book_title").read[String] ~
     (__ \ "date_of_publication").read[String] ~
     (__ \ "bookCount").read[Long] ~
     (__ \ "Book_Categories_id").read[Int] ~
     (__ \ "bookCategoriesName").read[String])(CreateBookUser.apply(_, _, _, _, _, _, _, _, _))  
  
}