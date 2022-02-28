package demo.api

import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec

case class ErrorInfo(errorMessage: String)

object ErrorInfo {
  implicit val CirceCodec: Codec[ErrorInfo] = deriveCodec[ErrorInfo]
}
