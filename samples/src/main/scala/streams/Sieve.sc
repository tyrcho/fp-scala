package streams

object Sieve {
  def from(n: Int): Stream[Int] = n #:: from(n + 1)
                                                  //> from: (n: Int)Stream[Int]
  val nats = from(0)                              //> nats  : Stream[Int] = Stream(0, ?)
  val m4s = nats.map(_ * 4)                       //> m4s  : scala.collection.immutable.Stream[Int] = Stream(0, ?)
  m4s.take(10).toList                             //> res0: List[Int] = List(0, 4, 8, 12, 16, 20, 24, 28, 32, 36)

  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail.filter(_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]

  val primes = sieve(from(2))                     //> primes  : Stream[Int] = Stream(2, ?)
  primes.take(10).toList                          //> res1: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
}