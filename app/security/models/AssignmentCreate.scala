package security.models
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._




case class AssignmentCreate (
assignment_name : String,
max_score : Long, 
sequence : Int, 
due_date : String, 
remindar_date : String, 
subjectId : Long,
classId : Long
 )
 
object AssignmentCreate {
  implicit val reads: Reads[AssignmentCreate] = (
    (JsPath \ "assignment_name").read[String] ~
    (JsPath \ "max_score").read[Long] ~
    (JsPath \ "sequence").read[Int] ~
    (JsPath \ "due_date").read[String] ~
    (JsPath \ "remindar_date").read[String] ~
    (JsPath \ "subjectId").read[Long] ~
    (JsPath \ "classId").read[Long])(AssignmentCreate.apply( _, _, _, _, _, _, _))

}