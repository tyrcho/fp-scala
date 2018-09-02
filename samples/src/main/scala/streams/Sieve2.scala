package streams

object Sieve2 extends App {
  val primes: Stream[Int] =
    2 #:: Stream.from(3, 2).filter { n => primes.takeWhile(_ <= math.sqrt(n)).forall(n % _ != 0)
    }

  primes.take(10).foreach(println)
}
