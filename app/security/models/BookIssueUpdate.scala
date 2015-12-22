package security.models
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class BookIssueUpdate( 
    bookIssueId : Int,
    user_id : Long,
    bookid : Int,
    date_issued : String,
    date_due_for_return : String, 
    date_returned : Option[String],
    amount_of_fine : Option[Int],
    libUserId : Long,
    libRetId : Option[Long]) 


object BookIssueUpdate {
 implicit val reads: Reads[BookIssueUpdate] = (
    (JsPath \ "bookIssueId").read[Int] ~
    (JsPath \ "user_id").read[Long] ~
    (JsPath \ "bookid").read[Int] ~
    (JsPath \ "date_issued").read[String] ~
    (JsPath \ "date_due_for_return").read[String] ~
    (JsPath \ "date_returned").readNullable[String] ~
    (JsPath \ "amount_of_fine").readNullable[Int] ~
    (JsPath \ "libUserId").read[Long] ~
    (JsPath \ "libRetId").readNullable[Long])(BookIssueUpdate.apply( _, _, _, _, _, _, _, _, _))
}