package models.users
import play.api.libs.json._
import play.api.libs.functional.syntax._
import scala.collection.mutable.ListBuffer
/**
 * @author ilyas
 */
case class GuadianUserWithStudentDetail(
guardianUser : List[GuardianUser],
studentDetailForGuardian : ListBuffer[Option[StudentDetailForGuardian]]
)

object GuadianUserWithStudentDetail {
  
  implicit val guardianUserWithStudentDetailWrites = new Writes[GuadianUserWithStudentDetail] {
    def writes(a: GuadianUserWithStudentDetail): JsValue = Json.obj(
      "guardianUser" -> a.guardianUser,
      "studentDetailForGuardian" -> a.studentDetailForGuardian)
  }
  
   implicit val authorreads: Reads[GuadianUserWithStudentDetail] = (
    (__ \ "guardianUser").read[List[GuardianUser]] ~
    (__ \ "studentDetailForGuardian").read[ListBuffer[Option[StudentDetailForGuardian]]])(GuadianUserWithStudentDetail.apply(_, _))
}
  
