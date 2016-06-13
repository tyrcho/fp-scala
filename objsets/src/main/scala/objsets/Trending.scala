package objsets

/**
  * This class provides a linear sequence of tweets.
  */
abstract class Trending {
  def +(tw: Tweet): Trending

  def head: Tweet

  def tail: Trending

  def isEmpty: Boolean

  def foreach(f: Tweet => Unit): Unit = {
    if (!isEmpty) {
      f(head)
      tail.foreach(f)
    }
  }
}

object EmptyTrending extends Trending {
  def +(tw: Tweet) = new NonEmptyTrending(tw, EmptyTrending)

  def head: Tweet = throw new Exception

  def tail: Trending = throw new Exception

  def isEmpty: Boolean = true

  override def toString = "EmptyTrending"
}

class NonEmptyTrending(elem: Tweet, next: Trending) extends Trending {
  /**
    * Appends tw to the end of this sequence.
    */
  def +(tw: Tweet): Trending =
    new NonEmptyTrending(elem, next + tw)

  def head: Tweet = elem

  def tail: Trending = next

  def isEmpty: Boolean = false

  override def toString =
    "NonEmptyTrending(" + elem.retweets + ", " + next + ")"
}

