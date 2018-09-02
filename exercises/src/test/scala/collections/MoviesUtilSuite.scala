package collections

import collections.MoviesUtil._
import moviesdb._
import org.scalatest.{FlatSpec, Matchers}

class MoviesUtilSuite extends FlatSpec with Matchers {
  "top 250" should "include Forrest Gump" in {
    isInTop250("Forrest Gump (1994)") shouldBe true
  }

  it should "not include Les visiteurs" in {
    isInTop250("Les visiteurs (1993)") shouldBe false
  }

  "findTitlesByYear => no movies" should "be from 2020" in {
    findTitlesByYear("2020") shouldBe empty
  }

  "findTitlesByYear => 9 movies" should "be from 1995" in {
    findTitlesByYear("1995") should contain only ("Se7en (1995)",
    "The Usual Suspects (1995)",
    "Braveheart (1995)",
    "Toy Story (1995)",
    "Heat (1995)",
    "Casino (1995)",
    "Before Sunrise (1995)",
    "Twelve Monkeys (1995)",
    "La haine (1995)")
  }

  "findMoviesWithRatingAtLeast => 3 movies" should "have rating >= 9" in {
    findMoviesWithRatingAtLeast(9) should contain only (Movie("The Shawshank Redemption (1994)", 9.3f),
    Movie("The Godfather (1972)", 9.2f),
    Movie("The Godfather: Part II (1974)", 9.0f))
  }

  "partitionMoviesAtRating => partition at 8.2" should "find 144 below and 106 above" in {
    val (below, above) = partitionMoviesAtRating(8.2f)
    below should have size 144
    above should have size 106
  }

  "bestMovie => The Shawshank Redemption" should "be the best movie" in {
    bestMovie shouldBe Movie("The Shawshank Redemption (1994)", 9.3f)
  }

  "topMovies => top 3 movies" should "be listed in order" in {
    topMovies(3) should contain theSameElementsInOrderAs Vector(Movie("The Shawshank Redemption (1994)", 9.3f),
                                                                Movie("The Godfather (1972)", 9.2f),
                                                                Movie("The Godfather: Part II (1974)", 9.0f))
  }

  "actorByName => Matt Damon" should "be found by its name" in {
    actorByName("Damon, Matt") match {
      case Some(Actor("Damon, Matt", movies)) =>
        movies.length shouldBe 5
      case _ => fail("not found : Matt Damon")
    }
  }

  "movieByTitle => The Godfather" should "be found by its title" in {
    movieByTitle("The Godfather (1972)") match {
      case Some(Movie("The Godfather (1972)", _)) => // OK
      case _                                      => fail("not found : godfather")
    }
  }

  "actorsInMovie => 89 actors" should "have played in 'The Return of the King'" in {
    actorsInMovie("The Lord of the Rings: The Return of the King (2003)") should have size 89
  }

  "actorsInMoviePart => 176 actors" should "have played in an 'Lord of the Rings' movie" in {
    actorsInMoviePart("Lord of the Rings") should have size 176
  }

  "csv" should "format the movies" in {
    csv(
      Vector(Movie("The Shawshank Redemption (1994)", 9.3f),
             Movie("The Godfather (1972)", 9.2f),
             Movie("The Godfather: Part II (1974)", 9.0f))) shouldBe
      "The Shawshank Redemption (1994), The Godfather (1972), The Godfather: Part II (1974)"
  }

  "titlesWith => Matt Damon" should "have played in 5 good titles" in {
    titlesWith("Damon, Matt") should contain only ("Saving Private Ryan (1998)",
    "Interstellar (2014)",
    "The Departed (2006)",
    "Good Will Hunting (1997)",
    "The Bourne Ultimatum (2007)")
  }

  "titlesWithAny => 11 movies" should "have featured Tom Hanks or DiCaprio" in {
    titlesWithAny("DiCaprio, Leonardo", "Hanks, Tom") should have size 11
  }

  "moviesWithAll => DiCaprio and Tom Hanks" should "have played together only in Catch Me ..." in {
    moviesWithAll(Vector("DiCaprio, Leonardo", "Hanks, Tom")) should contain only (Movie("Catch Me If You Can (2002)",
                                                                                         8f))
  }

  "titlesWithAll => DiCaprio and Tom Hanks" should "have played together only in Catch Me ... (titles)" in {
    titlesWithAll(Vector("DiCaprio, Leonardo", "Hanks, Tom")) should contain only ("Catch Me If You Can (2002)")
  }

  "moviesWith => Matt Damon" should "have played in 5 movies" in {
    moviesWith("Damon, Matt").map(_.title) should contain only ("Saving Private Ryan (1998)",
    "Interstellar (2014)",
    "The Departed (2006)",
    "Good Will Hunting (1997)",
    "The Bourne Ultimatum (2007)")
  }

  "moviesWithAny => DiCaprio or Tom Hanks" should "have played in 12 movies" in {
    moviesWithAny("DiCaprio, Leonardo", "Hanks, Tom") should (
      contain only (
        Movie("Inception (2010)", 8.7F),
        Movie("The Departed (2006)", 8.5F),
        Movie("Django Unchained (2012)", 8.4F),
        Movie("The Wolf of Wall Street (2013)", 8.1F),
        Movie("Shutter Island (2010)", 8.1F),
        Movie("Forrest Gump (1994)", 8.7F),
        Movie("Saving Private Ryan (1998)", 8.5F),
        Movie("The Green Mile (1999)", 8.5F),
        Movie("Toy Story 3 (2010)", 8.3F),
        Movie("Toy Story (1995)", 8.3F),
        Movie("Catch Me If You Can (2002)", 8.0F)
      ) and have size 11
    )

  }

  "moviesWithAny => 14 movies" should "have featured Matt Damon, Tom Hanks or DiCaprio" in {
    moviesWithAny(Vector("Damon, Matt", "DiCaprio, Leonardo", "Hanks, Tom")) should have size 14
  }

  "max rating for Matt Damon movies" should "be slightly lower than for DiCaprio" in {
    maxRating("DiCaprio, Leonardo") shouldBe 8.7f +- 0.0001f
    maxRating("Damon, Matt") shouldBe 8.5f +- 0.0001f
  }

  "average rating for Matt Damon movies" should "be slightly better than for DiCaprio" in {
    avgRating("DiCaprio, Leonardo") shouldBe 8.3f +- 0.001f
    avgRating("Damon, Matt") shouldBe 8.34f +- 0.0001f
  }

  "bestMovie => best DiCaprio movie" should "be Inception" in {
    bestMovie("DiCaprio, Leonardo").get.title shouldBe "Inception (2010)"
  }

}
