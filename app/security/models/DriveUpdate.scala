package security.models
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class DriverUpdate (  
    userId : Long,
    identifier: String,
    password: String,
    firstName: Option[String],
    middleName: Option[String],
    lastName: Option[String],
    DOB : Option[String],
    Gender : Option[String],
    address1: Option[String],
    address2: Option[String],
    city : Option[String],
    state : Option[String],
    phoneNumber : Option[Long],
    contextId : Long,
    campusId : Long,
    DLno : String,
    vehicleid : Int)

object DriverUpdate {
  
  implicit val reads: Reads[DriverUpdate] = (
     (JsPath \ "userId").read[Long] ~
     (JsPath \ "identifier").read[String] ~
     (JsPath \ "password").read[String] ~
     (JsPath \ "firstName").readNullable[String] ~
     (JsPath \ "middleName").readNullable[String] ~
     (JsPath \ "lastName").readNullable[String] ~
     (JsPath \ "DOB").readNullable[String] ~
     (JsPath \ "Gender").readNullable[String] ~
     (JsPath \ "address1").readNullable[String] ~
     (JsPath \ "address2").readNullable[String] ~
     (JsPath \ "city").readNullable[String] ~
     (JsPath \ "state").readNullable[String] ~
     (JsPath \ "phoneNumber").readNullable[Long] ~
     (JsPath \ "contextId").read[Long] ~
     (JsPath \ "campusId").read[Long] ~
     (JsPath \ "DLno").read[String] ~
     (JsPath \ "vehicleid").read[Int])(DriverUpdate.apply(_, _, _,_, _, _, _,_,_,_,_,_,_,_,_,_, _)  
  )  
}
