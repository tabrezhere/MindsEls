package models.users
import play.api.libs.json._
import play.api.libs.functional.syntax._
/**
 * @author ilyas
 */
case class SubjectClassStaffMap(
firstname : String,
user_id : Long,
classId : Long,
class_name : String,
subjectId : Long,
subjectName : String,
vehicleId : Long,
vehicle_no : String,
campus_id : Long,
campus_name : String,
organization_id : Long,
name:String 
)

object SubjectClassStaffMap {
  
  implicit val subjectClassStaffMapWrites = new Writes[SubjectClassStaffMap] {
    def writes(b: SubjectClassStaffMap): JsValue = Json.obj(
      "firstname" -> b.firstname,
      "user_id" -> b.user_id,
      "classId" -> b.classId,
      "class_name" -> b.class_name,
      "subjectId" -> b.subjectId,
      "subjectName" -> b.subjectName,
      "vehicleId" -> b.vehicleId,
      "vehicle_no" -> b.vehicle_no,
      "campus_id" -> b.campus_id,
      "campus_name" -> b.campus_name,
      "organization_id" -> b.organization_id,
      "name" -> b.name)
  }
  
   implicit val reads: Reads[SubjectClassStaffMap] = (
    (__ \ "firstname").read[String] ~
    (__ \ "user_id").read[Long] ~
    (__ \ "classId").read[Long] ~
    (__ \ "class_name").read[String] ~
    (__ \ "subjectId").read[Long] ~
    (__ \ "subjectName").read[String] ~
    (__ \ "vehicleId").read[Long] ~
    (__ \ "vehicle_no").read[String] ~
    (__ \ "campus_id").read[Long] ~
    (__ \ "campus_name").read[String] ~
    (__ \ "organization_id").read[Long] ~
    (__ \ "name").read[String])(SubjectClassStaffMap.apply(_, _, _, _, _, _, _, _, _, _, _, _))
}
