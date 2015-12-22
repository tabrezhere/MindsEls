package models.users

/**
 * Base info of an user
 */
case class BaseInfo(
  firstName: Option[String],
  lastName: Option[String],
  niceName: Option[String]) {

}