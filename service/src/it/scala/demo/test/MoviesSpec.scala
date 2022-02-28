package demo.test

import demo.api._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MoviesSpec extends AnyWordSpec with Matchers {
  "Movies" must {
    "be created via API call" in {
      val movie = Movie(
        Title("Pulp Fiction"),
        Description(
          "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption."
        ),
        Year(1994)
      )
      MovieApi.Create(movie) shouldEqual Right(())
      MovieApi.Get(movie.title) shouldEqual Right(movie)
    }
  }
}
