package models.users

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date



case class Assignment (
id : Int, 
assignment_name : String, 
max_score : Long, 
sequence : Int, 
due_date : String, 
remindar_date : String, 
subjectId : Long,
classId : Long
 )
 
object Assignment {
  
  implicit val assignmentWrites = new Writes[Assignment] {
    def writes(ass: Assignment): JsValue = Json.obj(
      "id" -> ass.id,
      "assignment_name" -> ass.assignment_name,
      "max_score" -> ass.max_score,
      "sequence"-> ass.sequence,
      "due_date" -> ass.due_date,
      "remindar_date" -> ass.remindar_date,
      "subjectId" -> ass.subjectId,
      "classId" ->ass.classId)
  }
  
  
  implicit val reads: Reads[Assignment] = (
    (__ \ "id").read[Int] ~
    (__ \ "assignment_name").read[String] ~
    (__ \ "max_score").read[Long] ~
    (__ \ "sequence").read[Int] ~
    (__ \ "due_date").read[String] ~
    (__ \ "remindar_date").read[String] ~
    (__ \ "subjectId").read[Long] ~
    (__ \ "classId").read[Long])(Assignment.apply( _, _, _, _, _, _, _, _))

}