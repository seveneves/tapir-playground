package demo.api

import io.circe.Codec
import io.circe.generic.semiauto.*

case class Movie(
  title: Title,
  description: Description,
  year: Year,
)

object Movie:
  val CirceCodec: Codec[Movie] = deriveCodec[Movie]
end Movie
