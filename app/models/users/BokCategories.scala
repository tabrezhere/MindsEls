package models.users

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class BokCategories (
id : Int,
Categories_name : String
)

object BokCategories {
  
  implicit val BokCategoriesWrites = new Writes[BokCategories] {
    def writes(ba: BokCategories): JsValue = Json.obj(
      "id" -> ba.id,
      "Categories_name" -> ba.Categories_name)
  }
  
   implicit val BokCategoriesreads: Reads[BokCategories] = (
    (__ \ "Books_id").read[Int] ~
    (__ \ "Categories_name").read[String])(BokCategories.apply(_, _))
}