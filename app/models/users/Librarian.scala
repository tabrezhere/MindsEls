package models.users


import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Librarian(id: Int,user_id: Long) 

object Librarian {
  
  implicit val librarianWrites = new Writes[Librarian] {
    def writes(lib: Librarian): JsValue = Json.obj(
      "id" -> lib.id,
      "user_id" -> lib.user_id)
  }
  
   implicit val librarianreads: Reads[Librarian] = (
    (__ \ "id").read[Int] ~
    (__ \ "user_id").read[Long])(Librarian.apply(_, _))
   
}



