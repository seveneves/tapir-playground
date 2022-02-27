package demo.api

import io.circe.Codec
import io.circe.Decoder
import io.circe.Encoder
import sttp.tapir.*
import sttp.tapir.json.circe

object MovieEndpoints:
  val get = endpoint.in("api" / "movies" / path[Title]("title")).out(circe.jsonBody[Movie])

end MovieEndpoints
