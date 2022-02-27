package demo.api

import io.circe.Codec
import io.circe.Decoder
import io.circe.Encoder

type Title = String

object Title:
  def apply(str: String): Title = str

  implicit val CirceCodec: Codec[Title] = Codec.from(
    Decoder.decodeString.map(Title.apply),
    Encoder.encodeString.contramap(v => v)
  )
end Title
