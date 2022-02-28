package demo.api

import sttp.tapir.Codec.PlainCodec
import sttp.tapir.{Codec => TCodec}

case class ApiKey(token: String) extends AnyVal

object ApiKey {
  implicit val TapirCodec: PlainCodec[Title] =
    TCodec.string.map(Title.apply _)(_.value)
}
