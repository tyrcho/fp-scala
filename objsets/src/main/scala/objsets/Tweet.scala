package objsets

/**
  * A class to represent tweets.
  */
class Tweet(val user: String, val text: String, val retweets: Int) {

  override def toString: String =
    "User: " + user + " Text: " + text + " [" + retweets + "]"

}
