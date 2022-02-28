package demo.service

import demo.api.ErrorInfo
import demo.api.Movie
import demo.api.Title
import sttp.model.StatusCode

import scala.collection.mutable
import scala.concurrent.Future

object MoviesService {

  private val movies = mutable.Map.empty[Title, Movie]

  def getMovie(title: Title): Future[Either[(StatusCode, ErrorInfo), Movie]] =
    Future.successful {
      movies
        .get(title)
        .toRight(
          StatusCode.NotFound -> ErrorInfo(s"Movie ${title.value} is not found")
        )
    }

  def createMovie(movie: Movie): Future[Either[(StatusCode, ErrorInfo), Unit]] =
    Future.successful {
      Right(movies.put(movie.title, movie))
    }
}
