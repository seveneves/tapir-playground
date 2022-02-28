package demo.service

import demo.api.ErrorInfo
import demo.api.ApiKey
import sttp.model.StatusCode

import scala.concurrent.Future

object AuthenticationService {
  type AuthContext = String

  val checkSecurity
      : ApiKey => Future[Either[(StatusCode, ErrorInfo), AuthContext]] = _ =>
    Future.successful {
      Right("Success")
    }
}
