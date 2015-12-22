package models.users

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json.toJsFieldJsValueWrapper

case class CampusUser (id : Int, campus_name : String, campusAddress : String, campusLocation : String, organization_id : Int,organizationName : String)

object CampusUser {
  
   implicit val campusWrites = new Writes[CampusUser] {
     
       def writes(c: CampusUser): JsValue = Json.obj(
        "id" -> c.id,
        "campus_name" -> c.campus_name,
        "campusAddress" -> c.campusAddress,
        "campusLocation" -> c.campusLocation,
        "organization_id" -> c.organization_id,
        "organizationName" -> c.organizationName)
   }
   
    implicit val campusReads: Reads[CampusUser] = (
      (__ \ "id").read[Int] ~
      (__ \ "campus_name").read[String] ~
      (__ \ "campusAddress").read[String] ~
      (__ \ "campusLocation").read[String] ~
      (__ \ "organization_id").read[Int] ~
      (__ \ "organizationName").read[String]) (CampusUser.apply(_, _, _, _, _, _))
  
}