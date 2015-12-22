package models.services

import scala.concurrent.Future
import dtos.UserDTO
//import java.net.URL

trait EmailNotificationService {
  /** Send a email with password resetting instructions to the `user`. Reset page URL is `resetURL`. */
  def sendPasswordResetInstructions(email: String): Future[Unit]

  /** Send a email with password changed notification to the `user` */
  def sendPasswordChangedEmail(email: UserDTO): Future[Unit]
}
