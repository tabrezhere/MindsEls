package models.authorizations

import com.mohiva.play.silhouette.core.Authorization
import models.users._
import play.api.i18n._
import play.api.mvc.RequestHeader

import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
 * Check for authorization
 */
case class WithRole(role: Role) extends Authorization[User] {
  def isAuthorized(user: User)(implicit request: RequestHeader, lang: Lang) = user.roles match {
    case list: Set[Role] => list.contains(role)
    case _ => false
  }

}
/**
 * Trait for all roles
 */
trait Role {
  def name: String
}

/**
 * Companion object
 */
object Role {

  def apply(role: String): Role = role match {
    case SysAdmin.name => SysAdmin
    case CampusAdmin.name => CampusAdmin
    case OrgAdmin.name => OrgAdmin
    case SimpleUser.name => SimpleUser
    case LibrarianUserRole.name => LibrarianUserRole
    case ParentGuardianUser.name => ParentGuardianUser
    case PublisherUser.name => PublisherUser
    case StaffUser.name => StaffUser
    case DriverRole.name => DriverRole
    case StudentUserRole.name => StudentUserRole
    case _ => Unknown
  }

  def unapply(role: Role): Option[String] = Some(role.name)
  
  implicit val roleWrites = new Writes[Role] {
    def writes(r: Role): JsValue = JsString(r.name)
  }

}

/**
 * System Administration role
 */
object SysAdmin extends Role {
  val name = "sys_admin"
}

/**
 * System Administration role
 */
object CampusAdmin extends Role {
  val name = "campus_admin"
}


/**
 * System Administration role
 */
object OrgAdmin extends Role {
  val name = "org_admin"
}

/**
 * Normal user role
 */
object SimpleUser extends Role {
  val name = "user"
}

/**
 * The generic unknown role
 */
object Unknown extends Role {
  val name = "-"
}

/**
 * Librarian user role
 */
object LibrarianUserRole extends Role {
  val name = "librarian"
}


/**
 * ParentGuardian user role
 */
object ParentGuardianUser extends Role {
  val name = "parentguardian"
}

/**
 * publisher user role
 */
object PublisherUser extends Role {
  val name = "publisher"
}

/**
 * publisher user role
 */
object StaffUser extends Role {
  val name = "staff"
}


/*
 * 
 */
object DriverRole extends Role {
  val name = "driver"
}
/**
 * publisher user role
 */
object StudentUserRole extends Role {
  val name = "student"
}