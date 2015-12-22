package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class CreateBookDetail (
    First_Name : String, 
    Last_Name: String, 
    ISBN : String,
    Book_title : String, 
    date_of_publication : String,
    bookCount : Long,
    Book_Categories_id : Int,
    campusId : Long
    )


object CreateBookDetail {
  
  implicit val reads: Reads[CreateBookDetail] = (
    (JsPath \ "First_Name").read[String] ~
    (JsPath \ "Last_Name").read[String] ~
    (JsPath \ "ISBN").read[String] ~
    (JsPath \ "Book_title").read[String] ~
    (JsPath \ "date_of_publication").read[String] ~
    (JsPath \ "bookCount").read[Long] ~
    (JsPath \ "Book_Categories_id").read[Int] ~
    (JsPath \ "campusId").read[Long])(CreateBookDetail.apply( _, _, _, _, _, _, _, _))
  
}