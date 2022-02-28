package demo.api

import io.circe.Codec
import io.circe.Decoder
import io.circe.Encoder

case class Description(value: String) extends AnyVal

object Description {
  implicit val CirceCodec: Codec[Description] = Codec.from(
    Decoder.decodeString.map(Description.apply),
    Encoder.encodeString.contramap(_.value)
  )
}
