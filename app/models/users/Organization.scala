package models.users
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Organization (id : Long,name : String, Type : String, activated : Int,paid : Int,deleted : Int)

object Organization{
  
  implicit val organizationWrites = new Writes[Organization] {
    def writes(org: Organization): JsValue = Json.obj(
      "id" -> org.id,
      "name" -> org.name,
      "Type" -> org.Type,
      "activated" -> org.activated,
      "paid"-> org.paid,
      "deleted" -> org.deleted)
  }
  
   implicit val bookreads: Reads[Organization] = (
    (__ \ "id").read[Long] ~
    (__ \ "name").read[String] ~
    (__ \ "Type").read[String] ~
    (__ \ "activated").read[Int]~
    (__ \ "paid").read[Int] ~
    (__ \ "deleted").read[Int])(Organization.apply(_, _, _, _, _, _))
}