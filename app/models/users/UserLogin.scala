package models.users

import anorm._
import anorm.SqlParser._
import play.api.libs.json.Reads
import play.api.libs.functional.syntax._
import play.api.libs.json._

import play.api.libs.json.Writes
import play.api.libs.json.JsValue





case class UserLogin (id:Long,userId:Long,verified:Int, email:String,phoneNumber:Option[Long])

object UserLogin {
  
  
  
  implicit val userLoginWrites: Writes[UserLogin] = new Writes[UserLogin] {
    override def writes(ul: UserLogin): JsValue = {
      Json.obj(
        "id" -> ul.id,
        "userId" -> ul.userId,
        "verified" -> ul.verified,
        "email" -> ul.email,
        "phoneNumber" -> ul.phoneNumber)
    }
  }
  
  
   implicit val userReads: Reads[UserLogin] = (
    
    (__ \ "id").read[Long] ~
    (__ \ "userId").read[Long] ~
    (__ \ "verified").read[Int] ~
    (__ \ "email").read[String] ~
    (__ \ "phoneNumber").readNullable[Long] ) (UserLogin.apply(_, _, _, _, _))
  
 
}