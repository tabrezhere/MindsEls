package security.models

import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class  MarksDetails (
    ecmId : Long,
    studentId :Long, 
    subjectId: Long,
    maxMarks :Long,
    minMarks: Long,
    marksObtained: Long,
    marksInWords : String,
    remarks : String
    )


object  MarksDetails {
  implicit val reads: Reads[MarksDetails] = (
    (JsPath \ "ecmId").read[Long] ~
    (JsPath \ "studentId").read[Long] ~
    (JsPath \ "subjectId").read[Long] ~
    (JsPath \ "maxMarks").read[Long]~
    (JsPath \ "minMarks").read[Long] ~
    (JsPath \ "marksObtained").read[Long] ~
    (JsPath \ "marksInWords").read[String] ~
    (JsPath \ "remarks").read[String])(MarksDetails.apply( _, _, _, _, _, _, _, _))
  
}
