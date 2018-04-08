package moviesdb

import scala.io.Codec
import scala.collection.immutable.Stream.consWrapper
import java.nio.file.Files
import java.nio.file.Paths
import upickle.default._
import upickle.default.{macroRW, ReadWriter => RW}

case class Actor(name: String, movies: Vector[String] = Vector())

object Actors {

  val actors: Vector[Actor] =
    read[Vector[Actor]](actorsString) ++ read[Vector[Actor]](actressesString)

  private def actorsString =
    io.Source.fromFile("actors.json").getLines.mkString

  private def actressesString =
    io.Source.fromFile("actresses.json").getLines.mkString


}

object Actor {
  implicit def rw: RW[Actor] = macroRW
}

object ActorsDemo extends App {
  // from ftp://ftp.fu-berlin.de/pub/misc/movies/database/
  //  listToJson("""h:\actresses.list""", "actresses.json")

  Actors.actors.foreach(println)

  def listToJson(list: String, json: String) = {
    val lines = io.Source.fromFile(list)(Codec.ISO8859).getLines
    val actorWithTitle = """([^\t]+)\t+([^)]+\)).*""".r
    val title = """\t+([^)]+\)).*""".r
    val actorsFromTopMovies: Stream[Actor] = lines
      .toStream
      .collect {
        case actorWithTitle(actorName, movieTitle) => Line(movieTitle, Some(Actor(actorName)))
        case title(movieTitle) => Line(movieTitle)
      }
      .groupWhen(_.actor.nonEmpty)
      .collect {
        case Line(movie, Some(actor)) #:: movies => actor.copy(movies = movie +: movies.toVector.map(l => l.movie))
      }
      .collect {
        case Actor(name, movies) if movies.exists(Movies.moviesMap.keySet) =>
          Actor(name, movies.filter(Movies.moviesMap.keySet))
      }
    val jsonActors = write(actorsFromTopMovies)
    Files.write(Paths.get(json), jsonActors.getBytes)
  }

  implicit class StreamOp[T](stream: Stream[T]) {
    def groupWhen(startPredicate: T => Boolean): Stream[Stream[T]] = {
      val clean = stream.dropWhile(e => !startPredicate(e))
      if (clean.isEmpty)
        Stream.empty
      else {
        val h = clean.head
        val tail = clean.tail.takeWhile(e => !startPredicate(e))
        val left = h #:: tail
        val right = clean.drop(left.size)
        left #:: right.groupWhen(startPredicate)
      }
    }
  }

}

case class Line(movie: String, actor: Option[Actor] = None)