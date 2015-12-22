package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
/**
 * @author ilyas
 */
case class StaffDetailsForClass(
  classId : Long,
  className : String,
  staffUserId : Long,
  firstName : String,
  subjectId : Long,
  subjectName : String
 ) 
 
 object StaffDetailsForClass {
  
  implicit val StaffDetailsForClassWrites = new Writes[StaffDetailsForClass] {
    def writes(stfcls: StaffDetailsForClass): JsValue = Json.obj(
      "classId" -> stfcls.classId,
      "className" -> stfcls.className,
      "staffUserId" -> stfcls.staffUserId,
      "firstName" -> stfcls.firstName,
      "subjectId" -> stfcls.subjectId,
      "subjectName" ->stfcls.subjectName
      )
  }
 
 implicit val reads: Reads[StaffDetailsForClass] = (
    (__ \ "classId").read[Long] ~
    (__ \ "className").read[String] ~
    (__ \ "staffUserId").read[Long] ~
    (__ \ "firstName").read[String] ~
    (__ \ "subjectId").read[Long] ~
    (__ \ "subjectName").read[String])(StaffDetailsForClass.apply( _, _, _, _, _, _))
}