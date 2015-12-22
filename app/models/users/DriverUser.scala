package models.users
import com.mohiva.play.silhouette.core.LoginInfo
import play.api.libs.json.Writes
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.util.Date

case class DriverUser (
    id: Long,
  /*loginInfo: LoginInfo,*/
  email: String,
  /*socials: Option[Seq[LoginInfo]] = None,*/
  firstName: Option[String],
  lastName: Option[String],
  middleName: Option[String],
  address1: Option[String],
  address2: Option[String],
  city : Option[String],
  state : Option[String],
  Deleted : Option[Long],
  context : String,
  user_id: Long,
  phoneNumber : Option[Long],
  DLno : String,
  vehicleid : Int,
  campusId : Long,
  campusName : String,
  orgId : Long,
  orgName : String
)

object DriverUser {
  
  implicit val driverUserWrites = new Writes[DriverUser] {
    def writes(du: DriverUser): JsValue = Json.obj(
      "id" -> du.id,
      "email" -> du.email,
      "firstName" -> du.firstName,
      "lastName" -> du.lastName,
      "middleName" -> du.middleName,
      "address1" -> du.address1,
      "address2" -> du.address2,
      "city" -> du.city,
      "state" -> du.state,
      "Deleted" -> du.Deleted,
      "context" -> du.context,
      "user_id" -> du.user_id,
      "phoneNumber" -> du.phoneNumber,
      "DLno" -> du.DLno,
      "vehicleid" -> du.vehicleid,
       "campusId" -> du.campusId,
      "campusName" -> du.campusName,
      "orgId" -> du.orgId,
      "orgName" -> du.orgName)
  }
  
   implicit val reads: Reads[DriverUser] = (
    (__ \ "id").read[Long] ~
    /*(__ \ "loginInfo").read[LoginInfo] ~*/
    (__ \ "email").read[String] ~
    /*(__ \ "socials").read[Option[Seq[LoginInfo]]] ~*/
    (__ \ "firstName").read[Option[String]] ~    
    (__ \ "lastName").read[Option[String]] ~
    (__ \ "middleName").read[Option[String]] ~
    (__ \ "address1").read[Option[String]] ~
    (__ \ "address2").read[Option[String]] ~
    (__ \ "city").read[Option[String]] ~
    (__ \ "state").read[Option[String]] ~
    (__ \ "Deleted").read[Option[Long]] ~
    (__ \ "context").read[String] ~
    (__ \ "user_id").read[Long] ~
    (__ \ "phoneNumber").read[Option[Long]] ~
    (__ \ "DLno").read[String] ~
    (__ \ "vehicleid").read[Int] ~
     (__ \ "campusId").read[Long] ~
    (__ \ "campusName").read[String] ~
    (__ \ "orgId").read[Long] ~
    (__ \ "orgName").read[String])(DriverUser.apply(_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _))
  
  
}