package models.commons

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper

// UserRoles
case class Context (id:Int, context:String)


object Context {
  
   implicit val userWrites = new Writes[Context] {
     
       def writes(c: Context): JsValue = Json.obj(
	      "id" -> c.id,
	      "context" -> c.context)
  }
   
    implicit val contextReads: Reads[Context] = (
	    (__ \ "id").read[Int] ~
	    (__ \ "context").read[String]) (Context.apply(_, _))
  
}