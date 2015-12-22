package security.models
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._




case class AssignmentUpdate (
assignmentId : Int,
assignment_name : String,
max_score : Long, 
sequence : Int, 
due_date : String, 
remindar_date : String, 
subjectId : Long,
classId : Long
 )
 
object AssignmentUpdate {
  implicit val reads: Reads[AssignmentUpdate] = (
    (JsPath \ "assignmentId").read[Int] ~
    (JsPath \ "assignment_name").read[String] ~
    (JsPath \ "max_score").read[Long] ~
    (JsPath \ "sequence").read[Int] ~
    (JsPath \ "due_date").read[String] ~
    (JsPath \ "remindar_date").read[String] ~
    (JsPath \ "subjectId").read[Long] ~
    (JsPath \ "classId").read[Long])(AssignmentUpdate.apply( _, _, _, _, _, _, _, _))

}