package security.models

import org.joda.time.DateTime
import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
 * This class represent token
 *
 * @param token Id of token
 * @param expiresOn The expiration time
 */
case class Token(token: String, expiresOn: DateTime)

/**
 * Companion object, contain format for Json
 */
object Token {

  implicit val restFormat = TokenFormat.restFormat

}

object TokenFormat {
  implicit val jodaDateWrites: Writes[org.joda.time.DateTime] = new Writes[org.joda.time.DateTime] {
    def writes(d: org.joda.time.DateTime): JsValue = JsString(d.toString)
  }
  
  implicit val restFormat = (
    (__ \ "token").format[String] ~
    (__ \ "expiresOn").format[org.joda.time.DateTime])(Token.apply, unlift(Token.unapply))
}