package models.users
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper

case class Student_Guardian_Mapping(
    id : Long,
    gid : Long,
    stdadmissionno : String,
    user_id : Long
)
object Student_Guardian_Mapping{
  implicit val stdgdnMapDetailWrites = new Writes[Student_Guardian_Mapping] {
     
       def writes(sgm: Student_Guardian_Mapping): JsValue = Json.obj(
        "id" -> sgm.id,
        "gid" -> sgm.gid,
        "stdadmissionno" -> sgm.stdadmissionno,        
        "user_id" -> sgm.user_id)
  }
   
    implicit val stdgdnMapDetailReads: Reads[Student_Guardian_Mapping] = (
      (__ \ "id").read[Long] ~
      (__ \ "gid").read[Long]~
      (__ \ "stdadmissionno").read[String]~
      (__ \ "user_id").read[Long]) (Student_Guardian_Mapping.apply(_,_,_,_))
}