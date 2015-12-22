package security.models
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class SchoolNewsDetail (
    schoolId : Int,
    headLines : String,
    newsDesc : String,
    newsDate : String,
    status : Int
)

object SchoolNewsDetail {
  implicit val reads : Reads[SchoolNewsDetail] = (
      (JsPath \ "schoolId").read[Int] ~
      (JsPath \ "headLines").read[String] ~
      (JsPath \ "newsDesc").read[String] ~
      (JsPath \ "newsDate").read[String] ~
      (JsPath \ "status").read[Int])(SchoolNewsDetail.apply(_, _, _, _, _))
  
}