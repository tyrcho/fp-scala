package collections

import moviesdb._
import Movies._
import Actors._

object MoviesUtil {
  // Hint : contains
  def isInTop250(title: String): Boolean =
    ???

  // Hint : filter
  def findTitlesByYear(year: String): Vector[String] =
    ???

  // 2. rewrite later with a for expression

  // Hint : filter
  def findMoviesWithRatingAtLeast(rating: Float): Vector[Movie] =
    ???

  // Hint : partition
  def partitionMoviesAtRating(rating: Float): (Vector[Movie], Vector[Movie]) =
    ???

  // Hint : maxBy
  def bestMovie: Movie =
    //    movies.sortBy(m => m.rating).last
    ???

  // Hint : sortBy, reverse, take
  def topMovies(n: Int): Vector[Movie] =
    ???

  def actorByName(actorName: String): Option[Actor] = {
    // Hint : filter, head
    ???
    // 2. what happens if no actor is found ? use headOption instead
    // 3. optimize with find
  }

  // Hint : same as previous
  def movieByTitle(title: String): Option[Movie] = {
    ???
  }

  def actorsInMovie(title: String): Vector[Actor] =
    ???

  def actorsInMoviePart(part: String): Vector[Actor] = {
    // Hint : filter, exists
    ???
    // 2. rewrite with a for expression (hint : also use distinct)
  }

  def moviesWith(actorName: String): Vector[Movie] = {
    // Hint : filter, pattern matching on actorByName
    ???
    //    2. rewrite with a for comprehension
  }

  // Hint : ++, distinct
  def moviesWithAny(actorName1: String, actorName2: String): Vector[Movie] =
    ???

  // Hint : map
  def titlesWith(actorName: String): Vector[String] =
    ???

  // rewrite later with a for expression (hint : also use distinct)

  //Hint : map, mkString
  def csv(movies: Vector[Movie]): String =
    ???

  // Hint : ++, distinct (reuse titlesWith)
  def titlesWithAny(actorName1: String, actorName2: String): Vector[String] =
    ???

  // Hint : filter, forall /!\ (reuse titlesWith)
  def moviesWithAll(actorNames: Vector[String]): Vector[Movie] =
    ???

  def moviesWithAny(actorNames: Vector[String]): Vector[Movie] = {
    // Hint : filter, exists
    ???
    // 2. Rewrite using map, flatten and distinct instead

    // 3. Rewrite using flatMap and distinct instead
  }

  // Hint : map (reuse moviesWithAll)
  def titlesWithAll(actorNames: Vector[String]): Vector[String] =
    ???

  // Hint : map, max (reuse moviesWith)
  def maxRating(actorName: String): Float = {
    ???
  }

  // Hint : map, sum, size (reuse moviesWith)
  def avgRating(actorName: String): Float = {
    ???
  }

  // Hint : maxBy, isEmpty (reuse moviesWith)
  def bestMovie(actorName: String): Option[Movie] = {
    ???
  }
}
