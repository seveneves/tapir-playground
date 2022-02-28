package demo.api

import io.circe.Codec
import io.circe.Decoder
import io.circe.Encoder
import sttp.tapir.Codec.PlainCodec
import sttp.tapir.{Codec => TCodec}

case class Title(value: String) extends AnyVal

object Title {
  implicit val CirceCodec: Codec[Title] = Codec.from(
    Decoder.decodeString.map[Title](Title.apply),
    Encoder.encodeString.contramap(_.value)
  )

  implicit val TapirCodec: PlainCodec[Title] =
    TCodec.string.map(Title.apply _)(_.value)

}
