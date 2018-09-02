package objsets

/**
  * Created by mdaviot on 6/13/16.
  */
object Main extends App {
  // Some help printing the results:
  println("RANKED:")
  GoogleVsApple.trending foreach println
}

object GoogleVsApple {
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")

  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

  val googleTweets: TweetSet =
    ??? //TODO: keep only google tweets

  val appleTweets: TweetSet =
    ??? //TODO: keep only apple tweets

  val trending: Trending =
    ??? // TODO: join both sets
  //TODO what is the tweet with highest #retweets?
}
