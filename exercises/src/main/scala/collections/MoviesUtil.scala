package collections

import moviesdb.Movies.{ movies, titles }
import moviesdb.Actors.actors
import moviesdb._

object MoviesUtil {
  // Hint : contains
  def isInTop250(title: String): Boolean =
    ???

  // Hint : filter
  def findTitlesByYear(year: String): Vector[String] =
    ???

  // Hint : filter
  def findMoviesWithRatingAtLeast(rating: Float): Vector[Movie] =
    ???

  // Hint : partition
  def partitionMoviesAtRating(rating: Float): (Vector[Movie], Vector[Movie]) =
    ???

  // Hint : maxBy
  def bestMovie: Movie =
    ???

  // Hint : sortBy, reverse, take
  def topMovies(n: Int): Vector[Movie] =
    ???

  def actorByName(actorName: String) = {
    // Hint : filter, head
    ???
    // 2. what happens if no actor is found ? use headOption instead
    // 3. optimize with find
  }

  def actorsInMovie(title: String) =
    ???

  def moviesWith(actorName: String): Vector[Movie] = {
    // Hint : filter, pattern matching on actorByName
    ???
  }

  // Hint : ++, distinct 
  def moviesWithAny(actorName1: String, actorName2: String): Vector[Movie] =
    ???

  // Hint : map
  def titlesWith(actorName: String): Vector[String] =
    ???

  // Hint : filter, forall /!\
  def moviesWithAll(actorNames: Vector[String]): Vector[Movie] =
    ???

  def moviesWithAny(actorNames: Vector[String]): Vector[Movie] = {
    // Hint : filter, exists 
    ???

    // 2. Rewrite using map, flatten and distinct instead

    // 3. Rewrite using flatMap and distinct instead
  }

  // Hint : map, max 
  def maxRating(actorName: String): Float = {
    ???
  }

  // Hint : map, sum, size 
  def avgRating(actorName: String): Float = {
    ???
  }

  // Hint : maxBy, isEmpty
  def bestMovie(actorName: String): Option[Movie] = {
    ???
  }

}