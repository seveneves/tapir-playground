package demo.api

import io.circe.Codec
import io.circe.Decoder
import io.circe.Encoder

case class Year(value: Int) extends AnyVal

object Year {
  implicit val CirceCodec: Codec[Year] = Codec.from(
    Decoder.decodeInt.map(Year.apply),
    Encoder.encodeInt.contramap(_.value)
  )
}
