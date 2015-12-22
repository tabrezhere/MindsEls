package models.users

import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import scala.collection.mutable.ListBuffer

case class GuardianUserWithStudentInfo (
    
  id: Long,
  email: String,
  /*loginInfo: LoginInfo,  
  socials: Option[Seq[LoginInfo]] = None,*/
  firstName: Option[String],
  lastName: Option[String],
  middleName: Option[String],
  address1: Option[String],
  address2: Option[String],
  city : Option[String],
  state : Option[String],
  Deleted : Option[Long],
  context : String,
  user_id: Long,
  relationship : String,
  mobile : Long,
  income : String,
  education : String,
  studentInfo : ListBuffer[Option[StudentDetailForGuardian]],
  campusId : Long,
  campusName : String,
  orgId : Long,
  orgName : String

)

object GuardianUserWithStudentInfo {
  
  implicit val guardianUserWithStudentInfoWrites = new Writes[GuardianUserWithStudentInfo] {
    def writes(guruser: GuardianUserWithStudentInfo): JsValue = Json.obj(
      "id" -> guruser.id,
      "email" -> guruser.email,
      "firstName" -> guruser.firstName,
      "lastName" -> guruser.lastName,
      "middleName" -> guruser.middleName,
      "address1" -> guruser.address1,
      "address2" -> guruser.address2,
      "city" -> guruser.city,
      "state" -> guruser.state,
      "Deleted" -> guruser.Deleted,
      "context" -> guruser.context,
      "user_id" -> guruser.user_id,
      "relationship" -> guruser.relationship,
      "mobile" -> guruser.mobile,
      "income" -> guruser.income,
      "education" -> guruser.education ,
      "studentInfo" -> guruser.studentInfo,
      "campusId" -> guruser.campusId,
      "campusName" -> guruser.campusName,
      "orgId" -> guruser.orgId,
      "orgName" -> guruser.orgName)
  }
  
   implicit val reads: Reads[GuardianUserWithStudentInfo] = (
    (__ \ "id").read[Long] ~
    (__ \ "email").read[String] ~
    (__ \ "firstName").read[Option[String]] ~    
    (__ \ "lastName").read[Option[String]] ~
    (__ \ "middleName").read[Option[String]] ~
    (__ \ "address1").read[Option[String]] ~
    (__ \ "address2").read[Option[String]] ~
    (__ \ "city").read[Option[String]] ~
    (__ \ "state").read[Option[String]] ~
    (__ \ "Deleted").read[Option[Long]] ~
    (__ \ "context").read[String] ~
    (__ \ "user_id").read[Long] ~
    (__ \ "relationship").read[String] ~
    (__ \ "mobile").read[Long] ~
    (__ \ "income").read[String] ~
    (__ \ "education").read[String] ~
    (__ \ "studentInfo").read[ListBuffer[Option[StudentDetailForGuardian]]] ~
    (__ \ "campusId").read[Long] ~
    (__ \ "campusName").read[String] ~
    (__ \ "orgId").read[Long] ~
    (__ \ "orgName").read[String])(GuardianUserWithStudentInfo.apply( _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _))    
}