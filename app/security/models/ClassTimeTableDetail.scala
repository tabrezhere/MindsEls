package security.models
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class CLassTimeTableDetail(
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

object CLassTimeTableDetail{
  implicit val reads: Reads[CLassTimeTableDetail] = (
    (JsPath \ "classId").read[Long] ~
    (JsPath \ "Day").read[String] ~
    (JsPath \ "pOne").read[Long] ~
    (JsPath \ "pTwo").read[Long] ~
    (JsPath \ "pThree").read[Long] ~
    (JsPath \ "pFour").read[Long] ~
    (JsPath \ "pFive").read[Long] ~
    (JsPath \ "pSix").read[Long] ~
    (JsPath \ "pSeven").read[Long] ~
    (JsPath \ "pEight").read[Long] ~
    (JsPath \ "createdAt").read[String] ~
    (JsPath \ "updatedAt").read[String])(CLassTimeTableDetail.apply( _, _, _, _, _, _, _, _, _, _, _, _))
}