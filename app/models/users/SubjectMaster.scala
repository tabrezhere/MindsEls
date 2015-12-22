package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class SubjectMaster(
id : Long,
subjectName : String,
createdOn : String,
updatedOn : String  
)

object SubjectMaster {
  
  implicit val subjectMasterWrites = new Writes[SubjectMaster] {
    def writes(exm: SubjectMaster): JsValue = Json.obj(
      "id" -> exm.id,
      "subjectName" -> exm.subjectName,
      "createdOn" -> exm.createdOn,
      "updatedOn" -> exm.updatedOn)
  }
 
 implicit val reads: Reads[SubjectMaster] = (
    (__ \ "id").read[Long] ~
    (__ \ "subjectName").read[String] ~
    (__ \ "createdOn").read[String] ~
    (__ \ "updatedOn").read[String])(SubjectMaster.apply(_, _, _, _))
}