package models.users
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date
/**
 * @author ilyas
 */
case class FinalResult(
resultId : Long,
dateOfResult : String,
userId : Long,
totalMaxMarks : Long,
totalMinMarks : Long,
totalMarksObtained : Long,
marksInWords : String,
resultClass : String,
average : Double
)

object FinalResult {
  implicit val finalResultWrites = new Writes[FinalResult] {
  def writes(res: FinalResult): JsValue = Json.obj(
      "resultId" -> res.resultId,
      "dateOfResult" -> res.dateOfResult,
      "userId" -> res.userId,
      "totalMaxMarks" -> res.totalMaxMarks,
      "totalMinMarks" -> res.totalMinMarks,
      "totalMarksObtained" -> res.totalMarksObtained,
      "marksInWords" -> res.marksInWords,
      "resultClass" -> res.resultClass,
      "average" -> res.average)
  }
 implicit val reads: Reads[FinalResult] = (
    (__ \ "resultId").read[Long] ~
    (__ \ "dateOfResult").read[String] ~
    (__ \ "userId").read[Long] ~
    (__ \ "totalMaxMarks").read[Long] ~
    (__ \ "totalMinMarks").read[Long] ~
    (__ \ "totalMarksObtained").read[Long] ~
    (__ \ "marksInWords").read[String] ~
    (__ \ "resultClass").read[String] ~
    (__ \ "average").read[Double])(FinalResult.apply( _, _, _, _, _, _, _, _, _))
}