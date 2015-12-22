package models.commons

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper

case class Campus (id : Long, campus_name : String, campusAddress : String, campusLocation : String, organization_id : Int)

object Campus {
  
   implicit val campusWrites = new Writes[Campus] {
     
       def writes(c: Campus): JsValue = Json.obj(
	      "id" -> c.id,
	      "campus_name" -> c.campus_name,
        "campusAddress" -> c.campusAddress,
        "campusLocation" -> c.campusLocation,
	      "organization_id" -> c.organization_id)
  }
   
    implicit val campusReads: Reads[Campus] = (
	    (__ \ "id").read[Long] ~
	    (__ \ "campus_name").read[String] ~
      (__ \ "campusAddress").read[String] ~
      (__ \ "campusLocation").read[String] ~
	    (__ \ "organization_id").read[Int]) (Campus.apply(_, _, _, _, _))
  
}