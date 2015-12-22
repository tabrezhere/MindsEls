package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class StaffTimeTableWithSubjectMasterWithClassTimeTable (
    classTimeTable : List[ClassTimeTable],
    subjectMaster : List[SubjectMaster],
    subjectClassStaffMap : List[SubjectClassStaffMap]
    )

object StaffTimeTableWithSubjectMasterWithClassTimeTable {
  
  implicit val staffTimeTableWithSubjectMasterWithClassTimeTableWrites = new Writes[StaffTimeTableWithSubjectMasterWithClassTimeTable] {
    def writes(stt: StaffTimeTableWithSubjectMasterWithClassTimeTable): JsValue = Json.obj(
      "classTimeTable" -> stt.classTimeTable,
      "subjectMaster" -> stt.subjectMaster,
      "subjectClassStaffMap" -> stt.subjectClassStaffMap)
  }
 
 implicit val reads: Reads[StaffTimeTableWithSubjectMasterWithClassTimeTable] = (
    (__ \ "classTimeTable").read[List[ClassTimeTable]] ~
    (__ \ "subjectMaster").read[List[SubjectMaster]] ~
    (__ \ "subjectClassStaffMap").read[List[SubjectClassStaffMap]])(StaffTimeTableWithSubjectMasterWithClassTimeTable.apply( _, _, _))
}
