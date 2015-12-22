package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
/**
 * @author ilyas
 */
case class StudentMarks(
  firstName: Option[String],
  lastName: Option[String],
  middleName: Option[String],
  userId: Long,
  Studentadminno : String,
  contactNumber : Long,
  className : String,
  campusName : String,
  orgName : String,
  examName : String
)

object StudentMarks {
  
  implicit val StudentMarksWrites = new Writes[StudentMarks] {
    def writes(stduser: StudentMarks): JsValue = Json.obj(
      "firstName" -> stduser.firstName,
      "lastName" -> stduser.lastName,
      "middleName" -> stduser.middleName,  
      "userId" -> stduser.userId,
      "Studentadminno" -> stduser.Studentadminno,
      "contactNumber" -> stduser.contactNumber,
      "className" -> stduser.className,
      "campusName" -> stduser.campusName,
      "orgName" -> stduser.orgName,
      "examName" -> stduser.examName
     )
  }
  
   implicit val reads: Reads[StudentMarks] = (
    
    (__ \ "firstName").read[Option[String]] ~    
    (__ \ "lastName").read[Option[String]] ~
    (__ \ "middleName").read[Option[String]] ~
    (__ \ "userId").read[Long] ~
    (__ \ "Studentadminno").read[String] ~
    (__ \ "contactNumber").read[Long] ~
    (__ \ "className").read[String] ~
    (__ \ "campusName").read[String] ~
    (__ \ "orgName").read[String] ~
    (__ \ "examName").read[String])(StudentMarks.apply(_, _, _, _, _, _, _, _, _, _))
  
  
}