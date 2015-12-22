package models.users

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper

case class UserContext (id:Long, userId:Long, contextId:Long, campusId:Long)


object UserContext {
  
  /* implicit val userWrites = new Writes[UserContext] {
     
       def writes(uc: UserContext): JsValue = Json.obj(
	      "id" -> uc.id,
	      "userId" -> uc.userId,
	      "contextId" -> uc.contextId,
	      "campusId" -> uc.campusId)
  }*/
  
   implicit val userWrites = new Writes[UserContext] {
     
       def writes(uc: UserContext): JsValue = {
         Json.obj(
        "id" -> uc.id,
        "userId" -> uc.userId,
        "contextId" -> uc.contextId,
        "campusId" -> uc.campusId)
       }
  }
   
    implicit val userContextReads: Reads[UserContext] = (
	    (__ \ "id").read[Long] ~
	    (__ \ "userId").read[Long] ~
	    (__ \ "contextId").read[Long] ~
	    (__ \ "campusId").read[Long]) (UserContext.apply(_, _, _, _))
  
}

