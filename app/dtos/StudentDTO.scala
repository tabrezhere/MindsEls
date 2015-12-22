package dtos


import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import security.models.StudentDetail


case class StudentDTO(
  val id: Long,
  val user_id: Long,
  val Studentadminno: String
)
  
object StudentDTO {
  
  
  implicit val StudentDTOWrites: Writes[StudentDTO] = new Writes[StudentDTO] {
    override def writes(u: StudentDTO): JsValue = {
      Json.obj(
        "id" -> u.id,
        "user_id" -> u.user_id,
        "Studentadminno" -> u.Studentadminno)
    }
  }
  
  //def apply(s: Staff): StaffDTO = StaffDTO(
  def apply(u: StudentDetail): StudentDTO = StudentDTO(
      id = u.id,
      user_id = u.user_id,
      Studentadminno = u.Studentadminno)
      
  /*def apply(id: Long, username: String, firstName: Option[String], lastName: Option[String], middleName: Option[String], address1: Option[String],address2: Option[String], city : Option[String], state : Option[String]): StudentDTO = StudentDTO(
      id = id,
      username = username,
      firstName = Some(firstName),
      lastName = Some(lastName),
      middleName = Some(middleName),
      address1 = Some(address1),
      address2 = Some(address2),
      city = Some(city),
      state = Some(state))*/

}