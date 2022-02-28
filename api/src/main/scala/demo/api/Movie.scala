package demo.api

import io.circe.Codec
import io.circe.generic.semiauto._
import sttp.tapir.Schema.annotations.description

case class Movie(
    title: Title,
    @description("Description") description: Description,
    @description("Year") year: Year
)

object Movie {
  implicit val CirceCodec: Codec[Movie] = deriveCodec[Movie]
}
