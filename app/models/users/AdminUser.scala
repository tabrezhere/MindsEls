package models.users

import com.mohiva.play.silhouette.core.LoginInfo

case class AdminUser (
  id: Long,
  loginInfo: LoginInfo,
  username: String,
  socials: Option[Seq[LoginInfo]] = None,
  firstName: Option[String],
  lastName: Option[String],
  middleName: Option[String],
  address1: Option[String],
  address2: Option[String],
  city : Option[String],
  state : Option[String],
  deleted : Option[Long],
  context : Option[String]
)