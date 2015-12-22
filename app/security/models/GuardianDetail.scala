package security.models

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper

case class GuardianDetail (id:Long,user_id:Long,relationship:String,mobile:Long,income:String,education:String,stdadmissionno : String)


object GuardianDetail{
  implicit val guardianDetailWrites = new Writes[GuardianDetail] {
     
       def writes(sd: GuardianDetail): JsValue = Json.obj(
        "id" -> sd.id,
        "user_id" -> sd.user_id,
        "relationship" -> sd.relationship,
        "mobile" -> sd.mobile,
        "income" -> sd.income,
        "education" -> sd.education,
        "stdadmissionno" -> sd.stdadmissionno)
  }
   
    implicit val guardianDetailReads: Reads[GuardianDetail] = (
         (__ \ "id").read[Long] ~
      (__ \ "user_id").read[Long]~
      (__ \ "relationship").read[String]~
      (__ \ "mobile").read[Long]~
      (__ \ "income").read[String]~
      (__ \ "education").read[String]~
      (__ \ "stdadmissionno").read[String]) (GuardianDetail.apply(_,_,_,_,_,_, _))
}

