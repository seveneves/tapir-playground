package demo.api

import sttp.model.StatusCode
import sttp.tapir._
import sttp.tapir.generic.auto._
import sttp.tapir.json.circe

object MovieEndpoints {
  val Get: PublicEndpoint[Title, (StatusCode, ErrorInfo), Movie, Any] =
    endpoint.get
      .in("api" / "movies" / path[Title]("title"))
      .out(circe.jsonBody[Movie])
      .errorOut(
        statusCode
          .description(StatusCode.NotFound, "Not Found")
          .and(circe.jsonBody[ErrorInfo])
      )
      .description("Retrieve a movie")

  val Create: Endpoint[ApiKey, Movie, (StatusCode, ErrorInfo), Unit, Any] =
    endpoint.put
      .securityIn(auth.apiKey(header[ApiKey]("api_key")))
      .in("api" / "movies")
      .in(circe.jsonBody[Movie].description("Json object describing a movie"))
      .errorOut(
        statusCode
          .description(StatusCode.Forbidden, "Unauthorized access")
          .and(circe.jsonBody[ErrorInfo])
      )
      .description("Register a movie")
}
