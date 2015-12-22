package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class  MarksUpdate (
    marksId : Int,
    ecmId : Long,
    studentId :Long, 
    subjectId: Long,
    maxMarks :Long,
    minMarks: Long,
    marksObtained: Long,
    marksInWords : String,
    remarks : String
    )


object  MarksUpdate {
  implicit val reads: Reads[MarksUpdate] = (
    (JsPath \ "marksId").read[Int] ~
    (JsPath \ "ecmId").read[Long] ~
    (JsPath \ "studentId").read[Long] ~
    (JsPath \ "subjectId").read[Long] ~
    (JsPath \ "maxMarks").read[Long]~
    (JsPath \ "minMarks").read[Long] ~
    (JsPath \ "marksObtained").read[Long] ~
    (JsPath \ "marksInWords").read[String] ~
    (JsPath \ "remarks").read[String])(MarksUpdate.apply(_, _, _, _, _, _, _, _, _))
  
}
