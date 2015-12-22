package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class ClassTimeTable (
    id : Long,
    classId : Long,
    Day : String,
    pOne: Long,
    pTwo: Long,
    pThree: Long,
    pFour: Long,
    pFive: Long,
    pSix: Long,
    pSeven: Long,
    pEight: Long,
    createdAt : String,
    updatedAt : String
)

object ClassTimeTable {
  implicit val classTimeTableWrites = new Writes[ClassTimeTable] {
  def writes(exm: ClassTimeTable): JsValue = Json.obj(
      "id" -> exm.id,
      "classId" -> exm.classId,
      "Day" -> exm.Day,
      "pOne" -> exm.pOne,
      "pTwo" -> exm.pTwo,
      "pThree" -> exm.pThree,
      "pFour" -> exm.pFour,
      "pFive" -> exm.pFive,
      "pSix" -> exm.pSix,
      "pSeven" -> exm.pSeven,
      "pEight" -> exm.pEight,
      "createdAt" -> exm.createdAt,
      "updatedAt" -> exm.updatedAt)
  }
 implicit val reads: Reads[ClassTimeTable] = (
    (__ \ "id").read[Long] ~
    (__ \ "classId").read[Long] ~
    (__ \ "Day").read[String] ~
    (__ \ "pOne").read[Long] ~
    (__ \ "pTwo").read[Long] ~
    (__ \ "pThree").read[Long] ~
    (__ \ "pFour").read[Long] ~
    (__ \ "pFive").read[Long] ~
    (__ \ "pSix").read[Long] ~
    (__ \ "pSeven").read[Long] ~
    (__ \ "pEight").read[Long] ~
    (__ \ "createdAt").read[String] ~
    (__ \ "updatedAt").read[String])(ClassTimeTable.apply( _, _, _, _, _, _, _, _, _, _, _, _, _))
}