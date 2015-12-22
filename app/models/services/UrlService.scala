package models.services

import scala.concurrent.Future
import java.net.URL

object UrlService {
  def getPasswordResetUrl(key: String): Future[URL] = Future.successful(new URL(s"http://localhost:9000/#reset-password/$key"))
}
