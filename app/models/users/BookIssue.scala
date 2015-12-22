package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class BookIssue( 
    id : Int,
    stdUserId : Long,
    bookid : Int,
    date_issued : String,
    date_due_for_return : String,
    date_returned : Option[String],
    amount_of_fine : Option[Int],
    libUserId : Long,
    bookReturnFlag : Int,
    libRetId : Option[Long]
    ) 

object BookIssue {
  
  implicit val userLoginWrites: Writes[BookIssue] = new Writes[BookIssue] {
    override def writes(bki: BookIssue): JsValue = {
      Json.obj(
        "id" -> bki.id,
        "stdUserId" -> bki.stdUserId,
        "bookid" -> bki.bookid,
        "date_issued" -> bki.date_issued,
        "date_due_for_return" -> bki.date_due_for_return,
        "date_returned" -> bki.date_returned,
        "amount_of_fine" -> bki.amount_of_fine,
        "libUserId" -> bki.libUserId,
        "bookReturnFlag" -> bki.bookReturnFlag,
        "libRetId" -> bki.libRetId)
    }
  }
    
   implicit val reads: Reads[BookIssue] = (
    (__ \ "id").read[Int] ~
    (__ \ "stdUserId").read[Long] ~
    (__ \ "bookid").read[Int] ~
    (__ \ "date_issued").read[String] ~
    (__ \ "date_due_for_return").read[String] ~
    (__ \ "date_returned").readNullable[String] ~
    (__ \ "amount_of_fine").readNullable[Int] ~ 
    (__ \ "libUserId").read[Long] ~
    (__ \ "bookReturnFlag").read[Int] ~
    (__ \ "libRetId").readNullable[Long])(BookIssue.apply( _, _, _, _, _, _, _, _, _, _))
}