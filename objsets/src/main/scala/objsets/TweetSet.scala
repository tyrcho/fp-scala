package objsets

import TweetReader._


/**
  * This represents a set of objects of type `Tweet` in the form of a binary search
  * tree. Every branch in the tree has two children (two `TweetSet`s). There is an
  * invariant which always holds: for every branch `b`, all elements in the left
  * subtree are smaller than the tweet at `b`. The elements in the right subtree are
  * larger.
  *
  * Note that the above structure requires us to be able to compare two tweets (we
  * need to be able to say which of two tweets is larger, or if they are equal). In
  * this implementation, the equality / order of tweets is based on the tweet's text
  * (see `def incl`). Hence, a `TweetSet` could not contain two tweets with the same
  * text from different users.
  *
  *
  * The advantage of representing sets as binary search trees is that the elements
  * of the set can be found quickly. If you want to learn more you can take a look
  * at the Wikipedia page [1], but this is not necessary in order to solve this
  * assignment.
  *
  * [1] http://en.wikipedia.org/wiki/Binary_search_tree
  */
abstract class TweetSet {

  /**
    * This method takes a predicate and returns a subset of all the elements
    * in the original set for which the predicate is true.
    *
    * Question: Can we implement this method here, or should it remain abstract
    * and be implemented in the subclasses?
    */
  def filter(p: Tweet => Boolean): TweetSet =
    ??? // TODO: filter elements

  /**
    * This is a helper method for `filter` that propagetes the accumulated tweets.
    */
  def filter0(p: Tweet => Boolean, acc: TweetSet): TweetSet

  /**
    * Returns a new `TweetSet` that is the union of `TweetSet`s `this` and `that`.
    *
    * Question: Should we implement this method here, or should it remain abstract
    * and be implemented in the subclasses?
    */
  def union(that: TweetSet): TweetSet =
    ??? //TODO : union

  /**
    * Returns a list containing all tweets of this set, sorted by retweet count
    * in ascending order. In other words, the head of the resulting list should
    * have the lowest retweet count.
    *
    * Hint: the method `remove` on TweetSet will be very useful.
    * Question: Should we implement this method here, or should it remain abstract
    * and be implemented in the subclasses?
    */
  def ascendingByRetweet: Trending =
    ??? //TODO: construct the list of tweets ordered by retweet count

  // The following methods are provided for you, and do not have to be changed
  // -------------------------------------------------------------------------
  /**
    * Returns a new `TweetSet` which contains all elements of this set, and the
    * the new element `tweet` in case it does not already exist in this set.
    *
    * If `this.contains(tweet)`, the current set is returned.
    */
  def incl(x: Tweet): TweetSet

  /**
    * Tests if `tweet` exists in this `TweetSet`.
    */
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

  /**
    * Returns a new `TweetSet` which excludes `tweet`.
    */
  def remove(tw: Tweet): TweetSet

  def findMin0(curr: Tweet): Tweet =
    if (isEmpty) curr
    else if (head.retweets < curr.retweets) tail.findMin0(head)
    else tail.findMin0(curr)

  def findMin: Tweet =
    tail.findMin0(head)

  // -------------------------------------------------------------------------
}

object EmptySet extends TweetSet {

  // The following methods are provided for you, and do not have to be changed
  // -------------------------------------------------------------------------
  def contains(x: Tweet): Boolean = false

  def incl(x: Tweet): TweetSet = new NonEmpty(x, EmptySet, EmptySet)

  def isEmpty = true

  def head = throw new Exception("EmptySet.head")

  def tail = throw new Exception("EmptySet.tail")

  def remove(tw: Tweet): TweetSet = this

  // -------------------------------------------------------------------------

  def filter0(p: Tweet => Boolean, acc: TweetSet): TweetSet =
    ??? //TODO : you can implement the helper function in EmptySet

}

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet {

  // The following methods are provided for you, and do not have to be changed
  // -------------------------------------------------------------------------
  def contains(x: Tweet): Boolean =
    if (x.text < elem.text) left.contains(x)
    else if (elem.text < x.text) right.contains(x)
    else true

  // returns a new TweetSet which includes x
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

  def filter0(p: Tweet => Boolean, acc: TweetSet): TweetSet =
    ??? //TODO : you can implement the helper function in the NonEmpty set

}

