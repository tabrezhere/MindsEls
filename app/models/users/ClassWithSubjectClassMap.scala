package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class ClassWithSubjectClassMap (
    classTimeTable : List[ClassTimeTable],
    subjectMaster : List[SubjectMaster]
    )

object ClassWithSubjectClassMap {
  
  implicit val classWithSubjectClassMapWrites = new Writes[ClassWithSubjectClassMap] {
    def writes(exm: ClassWithSubjectClassMap): JsValue = Json.obj(
      "classTimeTable" -> exm.classTimeTable,
      "subjectMaster" -> exm.subjectMaster)
  }
 
 implicit val reads: Reads[ClassWithSubjectClassMap] = (
    (__ \ "classTimeTable").read[List[ClassTimeTable]] ~
    (__ \ "subjectMaster").read[List[SubjectMaster]])(ClassWithSubjectClassMap.apply( _, _))
}
