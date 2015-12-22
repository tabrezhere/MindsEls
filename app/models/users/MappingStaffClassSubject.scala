package models.users
import play.api.libs.json._
import play.api.libs.functional.syntax._
/**
 * @author ilyas
 */
case class MappingStaffClassSubject(
subjectClassId : Long,
subjectId : Long,
classId : Long,
staffSubjectId : Long,
userId : Long

)

object MappingStaffClassSubject {
  
  implicit val mappingStaffClassSubjectWrites = new Writes[MappingStaffClassSubject] {
    def writes(ba: MappingStaffClassSubject): JsValue = Json.obj(
      "staffSubjectId" -> ba.staffSubjectId,
      "subjectId" -> ba.subjectId,
      "classId" -> ba.classId,
      "userId" -> ba.userId,
      "subjectClassId" -> ba.subjectClassId)
  }
  
   implicit val MappingStaffClassSubjectreads: Reads[MappingStaffClassSubject] = (
    (__ \ "staffSubjectId").read[Long] ~
    (__ \ "subjectId").read[Long] ~
    (__ \ "classId").read[Long] ~
    (__ \ "userId").read[Long] ~
    (__ \ "subjectClassId").read[Long])(MappingStaffClassSubject.apply(_, _, _, _, _))
}