package models.users

/**
 * @author ilyas
 */
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class StaffSubjectMap( id : Long, subjectId : Long, userId : Long)

object StaffSubjectMap {
   implicit val staffSubjectMapWrites = new Writes[StaffSubjectMap] {
    def writes(staffSubjectMap: StaffSubjectMap): JsValue = Json.obj(
      "id" -> staffSubjectMap.id,
      "subjectId" -> staffSubjectMap.subjectId,
      "userId" -> staffSubjectMap.userId)
}
   
implicit val reads: Reads[StaffSubjectMap] = (
    (__ \ "id").read[Long] ~
    (__ \ "subjectId").read[Long] ~
    (__ \ "userId").read[Long])(StaffSubjectMap.apply( _, _, _))
}