package security.models
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class NewsUpdate (
    newsId : Int,
    schoolId : Int,
    headLines : String,
    newsDesc : String,
    newsDate : String,
    status : Int
)

object NewsUpdate {
  implicit val reads : Reads[NewsUpdate] = (
      (JsPath \ "newsId").read[Int] ~
      (JsPath \ "schoolId").read[Int] ~
      (JsPath \ "headLines").read[String] ~
      (JsPath \ "newsDesc").read[String] ~
      (JsPath \ "newsDate").read[String] ~
      (JsPath \ "status").read[Int])(NewsUpdate.apply(_, _, _, _, _, _))
  
}