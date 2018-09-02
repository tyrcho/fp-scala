package streams

object IntStreams {
  //  Stream contains infinite 1s :
  val ones: Stream[Int] = ???

  // Constant function : infinite stream of a value
  def constant[A](a: A): Stream[A] =
    ???

  // All integers starting from a number :
  def from(n: Int): Stream[Int] =
    ???

  // All natural numbers :
  val nats: Stream[Int] = ???

  // Multiples of 4:
  val multiplesOf4: Stream[Int] = ???

  // all fibonacci numbers 0,1,1,2,3,5,8 ...
  val fibs: Stream[Int] = {
    def build(a: Int, b: Int): Stream[Int] =
      ???

    ???
  }

  //  Write a more general stream building function. unfold which take
  //   * an initial state
  //   * a function which produces
  //       - the next state
  //       - the next value
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] =
    f(z) match {
      case None => Stream.empty
      case Some((elt, state)) =>
        ???
    }

  // SIEVE of ERATOSTHENES
  //Start with all integers from 2, the first prime number.
  //Eliminate all multiples of 2.
  //The first element of the resulting list is 3, a prime number.
  //Eliminate all multiples of 3.
  //Iterate forever. At each step, the first number in the list is a prime number and we eliminate all its multiples.

  def sieve(s: Stream[Int]): Stream[Int] =
    ???

  val primes = sieve(from(2))
}
