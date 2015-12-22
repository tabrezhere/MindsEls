package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Exam (
id : Long,
examName : String,
termtypeId : Int,
var createAt : String,
var updateAt : String
)

object Exam {
  
  implicit val examWrites = new Writes[Exam] {
    def writes(exm: Exam): JsValue = Json.obj(
      "id" -> exm.id,
      "examName" -> exm.examName,
      "termtypeId" -> exm.termtypeId,
      "createAt" -> exm.createAt,
      "updateAt" -> exm.updateAt)
  }
 
 implicit val reads: Reads[Exam] = (
    (__ \ "id").read[Long] ~
    (__ \ "examName").read[String] ~
    (__ \ "termtypeId").read[Int] ~
    (__ \ "createAt").read[String] ~
    (__ \ "updateAt").read[String])(Exam.apply( _, _, _, _, _))
}