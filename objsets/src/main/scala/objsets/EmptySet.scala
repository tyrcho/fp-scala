package objsets

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
