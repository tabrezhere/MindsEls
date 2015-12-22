package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._


case class AssignmentUser (
id : Int,
assignment_name : String,
max_score : Long,
sequence : Int, 
due_date : String, 
remindar_date : String, 
subjectId : Long,
subjectName : String,
classId : Long,
class_name : String,
cmId : Long,
campus_name : String,
oId : Long,
name : String

)

object AssignmentUser {
  
  implicit val assignmentUserWrites = new Writes[AssignmentUser] {
    def writes(assusr: AssignmentUser): JsValue = Json.obj(
      "id" -> assusr.id,
      "assignment_name" -> assusr.assignment_name,
      "max_score" -> assusr.max_score,
      "sequence"-> assusr.sequence,
      "due_date" -> assusr.due_date,
      "remindar_date" -> assusr.remindar_date,
      "subjectId" -> assusr.subjectId,
      "subjectName" -> assusr.subjectName,
      "classId" -> assusr.classId,
      "class_name" -> assusr.class_name,
      "cmId" -> assusr.cmId,
      "campus_name" -> assusr.campus_name,
      "oId" -> assusr.oId,
      "name" -> assusr.name)
  }
  
  
  implicit val reads: Reads[AssignmentUser] = (
    (__ \ "id").read[Int] ~    
    (__ \ "assignment_name").read[String] ~  
    (__ \ "max_score").read[Long] ~  
    (__ \ "sequence").read[Int] ~   
    (__ \ "due_date").read[String] ~   
    (__ \ "remindar_date").read[String] ~  
    (__ \ "subjectId").read[Long] ~   
    (__ \ "subjectName").read[String] ~  
    (__ \ "classId").read[Long] ~ 
    (__ \ "class_name").read[String] ~  
    (__ \ "cmId").read[Long] ~   
    (__ \ "campus_name").read[String] ~ 
    (__ \ "oId").read[Long] ~  
    (__ \ "name").read[String])(AssignmentUser.apply( _, _, _, _, _, _, _, _, _, _, _, _, _, _))

}