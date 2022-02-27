package demo.api

import io.circe.Codec
import io.circe.Decoder
import io.circe.Encoder

type Description = String

object Description:
  def apply(str: String): Description = str

  implicit val CirceCodec: Codec[Description] = Codec.from(
    Decoder.decodeString.map(Description.apply),
    Encoder.encodeString.contramap(v => v)
  )

end Description
