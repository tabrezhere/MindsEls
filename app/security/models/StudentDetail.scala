package security.models

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper

case class StudentDetail (id:Long,user_id:Long,Studentadminno : String,vehicleId : Option[Long])

object StudentDetail {
  
   implicit val studentDetailWrites = new Writes[StudentDetail] {
     
       def writes(std: StudentDetail): JsValue = Json.obj(
        "id" -> std.id,
        "user_id" -> std.user_id,
        "Studentadminno" -> std.Studentadminno,
        "vehicleId" -> std.vehicleId)
  }
   
    implicit val studentDetailReads: Reads[StudentDetail] = (
      (__ \ "id").read[Long] ~
      (__ \ "user_id").read[Long] ~
      (__ \ "Studentadminno").read[String] ~
      (__ \ "vehicleId").readNullable[Long]) (StudentDetail.apply(_, _, _, _))
  
}