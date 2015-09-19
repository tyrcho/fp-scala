package objsets

import TweetReader._

class Tweet(val user: String, val text: String, val retweets: Int) {

  override def toString: String =
    "User: " + user + " Text: " + text + " [" + retweets + "]"

}

abstract class TweetSet {

  /**
   * This method takes a predicate and returns a subset of all the elements
   *  in the original set for which the predicate is true.
   */
  def filter(p: Tweet => Boolean): TweetSet = {
    def filter0(p: Tweet => Boolean, accu: TweetSet): TweetSet = {
      ???
    }
    ???
  }

  def union(that: TweetSet): TweetSet =
    ???

  // Hint: the method "remove" on TweetSet will be very useful.
  def ascendingByRetweet: Trending = {
    def ascendingRec(t: Trending, s: TweetSet): Trending = {
      ???
    }
    ???
  }

  // The following methods are provided for you, and do not have to be changed
  // -------------------------------------------------------------------------
  def incl(x: Tweet): TweetSet
  def contains(x: Tweet): Boolean
  def isEmpty: Boolean
  def head: Tweet
  def tail: TweetSet

  /**
   * This method takes a function and applies it to every element in the set.
   */
  def foreach(f: Tweet => Unit): Unit = {
    if (!isEmpty) {
      f(head)
      tail.foreach(f)
    }
  }

  override def toString = {
    val sb = new StringBuilder
    foreach { t => sb.append(t); sb.append("\n") }
    sb.toString
  }

  def remove(tw: Tweet): TweetSet

  def findMin0(curr: Tweet): Tweet =
    if (isEmpty) curr
    else if (head.retweets < curr.retweets) tail.findMin0(head)
    else tail.findMin0(curr)

  def findMin: Tweet =
    tail.findMin0(head)
  // -------------------------------------------------------------------------
}

class Empty extends TweetSet {

  // The following methods are provided for you, and do not have to be changed
  // -------------------------------------------------------------------------
  def contains(x: Tweet): Boolean = false
  def incl(x: Tweet): TweetSet = new NonEmpty(x, new Empty, new Empty)
  def isEmpty = true
  def head = throw new Exception("Empty.head")
  def tail = throw new Exception("Empty.tail")
  def remove(tw: Tweet): TweetSet = this
  // -------------------------------------------------------------------------
}

object EmptySet extends Empty

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet {

  // The following methods are provided for you, and do not have to be changed
  // -------------------------------------------------------------------------
  def contains(x: Tweet): Boolean =
    if (x.text < elem.text) left.contains(x)
    else if (elem.text < x.text) right.contains(x)
    else true

  def incl(x: Tweet): TweetSet = {
    if (x.text < elem.text) new NonEmpty(elem, left.incl(x), right)
    else if (elem.text < x.text) new NonEmpty(elem, left, right.incl(x))
    else this
  }

  def isEmpty = false
  def head = if (left.isEmpty) elem else left.head
  def tail = if (left.isEmpty) right else new NonEmpty(elem, left.tail, right)

  def remove(tw: Tweet): TweetSet =
    if (tw.text < elem.text) new NonEmpty(elem, left.remove(tw), right)
    else if (elem.text < tw.text) new NonEmpty(elem, left, right.remove(tw))
    else left.union(right)
  // -------------------------------------------------------------------------
}

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

class EmptyTrending extends Trending {
  def +(tw: Tweet) = new NonEmptyTrending(tw, new EmptyTrending)
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

object GoogleVsApple {
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")

  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

  def filter(keywords: List[String]) = ???

  val googleTweets: TweetSet = ???

  val appleTweets: TweetSet = ???

  // Q: from both sets, what is the tweet with highest #retweets?
  val trending: Trending = ???
}

object Main extends App {
  // Some help printing the results:
  println("RANKED:")
  GoogleVsApple.trending foreach println
}
