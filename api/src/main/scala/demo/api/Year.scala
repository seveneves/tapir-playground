package demo.api

import io.circe.Codec
import io.circe.Decoder
import io.circe.Encoder

type Year = Int

object Year:
  def apply(int: Int): Year = int

  implicit val CirceCodec: Codec[Year] = Codec.from(
    Decoder.decodeInt.map(Year.apply),
    Encoder.encodeInt.contramap(v => v)
  )
end Year
