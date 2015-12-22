package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class SchoolNews (
    id : Long,
    schoolId : Int,
    headLines : String,
    newsDesc : String,
   var newsDate : String,
    status : Int
)
object SchoolNews 
{
implicit val schoolNewsWrites = new Writes[SchoolNews] {
     
       def writes(snws: SchoolNews): JsValue = {
         Json.obj(
        "id" -> snws.id,
        "schoolId" -> snws.schoolId,
        "headLines" -> snws.headLines,
        "newsDesc" -> snws.newsDesc,
        "newsDate"->snws.newsDate,
        "status"->snws.status)
       }
  }
   
    implicit val schoolReads: Reads[SchoolNews] = (
      (__ \ "id").read[Long] ~
      (__ \ "schoolId").read[Int] ~
      (__ \ "headLines").read[String] ~
      (__ \ "newsDesc").read[String]~
      (__ \ "newsDate").read[String]~
      (__ \ "status").read[Int]) (SchoolNews.apply(_, _, _, _, _, _))
}