package models.daos

import scala.concurrent._
import play.api.libs.concurrent.Execution.Implicits._
import play.api.db._
import play.api.Play.current
import anorm._
import anorm.SqlParser._
import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.providers.PasswordInfo
import com.mohiva.play.silhouette.contrib.daos.DelegableAuthInfoDAO
import com.mohiva.play.silhouette.core.providers.CredentialsProvider

/**
 * The DAO to store the password information.
 */
class PasswordInfoDAO extends DelegableAuthInfoDAO[PasswordInfo] {
  val PISimple = {
    get[String]("hasher") ~
      get[String]("password") ~
      get[Option[String]]("salt") map {
        case (h ~ p ~ s) => PasswordInfo(hasher = h, password = p, salt = s)
      }
  }

  /**
   * Saves the password info.
   *
   * @param loginInfo The login info for which the auth info should be saved.
   * @param authInfo The password info to save.
   * @return The saved password info or None if the password info couldn't be saved.
   */
  def save(loginInfo: LoginInfo, authInfo: PasswordInfo): Future[PasswordInfo] = Future {
    println("PasswordInfoDAO.save started in Future")
    DB.withTransaction { implicit conn =>
      SQL("""
        UPDATE `user` JOIN `user_login` ON `user_login`.`email`={username} AND `user_login`.`user_id` = `user`.`id` SET `hasher`={hasher}, `password`={password}, `salt`={salt} 
        """).on(
         'username -> loginInfo.providerKey,
        'hasher -> authInfo.hasher,
        'password -> authInfo.password,
        'salt -> authInfo.salt
        ).executeUpdate()
    }
    println("PasswordInfoDAO.save ended in Future")
    authInfo
  }

  /**
   * Finds the password info which is linked with the specified login info.
   *
   * @param loginInfo The linked login info.
   * @return The retrieved password info or None if no password info could be retrieved for the given login info.
   */
  def find(loginInfo: LoginInfo): Future[Option[PasswordInfo]] = loginInfo.providerID match {
    case CredentialsProvider.Credentials => Future {
      DB.withConnection { implicit conn =>
        SQL("""
        SELECT `user`.`hasher`, `user`.`password`, `user`.`salt` FROM `user`,`user_login` WHERE `user_login`.`email`={username} AND `user_login`.`user_id` = `user`.`id`
      """).on('username -> loginInfo.providerKey).as(PISimple singleOpt)
      }
    }
    case _ =>
      //TODO: log unexpected providerID
      Future.successful(None)
  }
}
