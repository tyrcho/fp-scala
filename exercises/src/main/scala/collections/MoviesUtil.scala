package collections

import moviesdb.Movies.{ movies, titles }
import moviesdb.Actors.actors
import moviesdb._

object MoviesUtil {
  // Hint : contains
  def isInTop250(title: String): Boolean =
    titles.contains(title)

  // Hint : filter
  def findTitlesByYear(year: String): Vector[String] =
    titles.filter(t => t.contains(year))
  // 2. rewrite later with a for expression

  // Hint : filter
  def findMoviesWithRatingAtLeast(rating: Float): Vector[Movie] =
    movies.filter(m => m.rating >= rating)

  // Hint : partition
  def partitionMoviesAtRating(rating: Float): (Vector[Movie], Vector[Movie]) =
    movies.partition(m => m.rating <= rating)

  // Hint : maxBy
  def bestMovie: Movie =
    //    movies.sortBy(m => m.rating).last
    movies.maxBy(m => m.rating)

  // Hint : sortBy, reverse, take
  def topMovies(n: Int): Vector[Movie] =
    movies.sortBy(m => -m.rating).take(n)

  def actorByName(actorName: String) = {
    // Hint : filter, head
    actors.find(a => a.name == actorName)
    // 2. what happens if no actor is found ? use headOption instead
    // 3. optimize with find
  }

  // Hint : same as previous
  def movieByTitle(title: String) = {
    movies.find(m => m.title == title)
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
  def csv(movies: Vector[Movie]) = 
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
