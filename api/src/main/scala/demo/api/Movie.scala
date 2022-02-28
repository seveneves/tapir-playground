package demo.api

import io.circe.Codec
import io.circe.generic.semiauto._

case class Movie(
    title: Title,
    description: Description,
    year: Year
)

object Movie {
  implicit val CirceCodec: Codec[Movie] = deriveCodec[Movie]
}
