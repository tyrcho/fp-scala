
package streams

import org.scalatest.{FlatSpec, Matchers}
import streams.IntStreams._

class IntStreamsSuite extends FlatSpec with Matchers {
  "ones" should "contain only 1 and be infinite" in {
    ones.take(10) should contain only 1
    ones.take(1000) should have size 1000
    ones.hasDefiniteSize shouldBe false
  }

  "constant(5)" should "contain only 5 and be infinite" in {
    constant(5).take(10) should contain only 5
    constant(5).take(1000) should have size 1000
    constant(5).hasDefiniteSize shouldBe false
  }

  "from(5)" should "start with 5,6,7 ... and be infinite" in {
    from(5).take(3) shouldBe Stream(5, 6, 7)
    from(5).hasDefiniteSize shouldBe false
  }

  "nats" should "start with 0,1,2 ... " in {
    nats.take(3) shouldBe Stream(0, 1, 2)
  }

  "multiples of 4" should "start with 0,4,8,12... " in {
    multiplesOf4.take(4) shouldBe Stream(0, 4, 8, 12)
  }

  "fibonacci" should "start with 0,1,1,2,3,5,8... " in {
    fibs.take(7) shouldBe Stream(0, 1, 1, 2, 3, 5, 8)
  }

  "the biggest int fibonacci number" should "be 1836311903 ind 46th position" in {
    fibs.takeWhile(_ >= 0).last shouldBe 1836311903
    fibs.indexOf(1836311903) shouldBe 46
  }

  "unfold" should "produce the same fibonacci numbers" in {
    val myFibs = unfold((0, 1)) {
      case (a, b) if a + b > 0 => Some((a, (b, a + b)))
      case _ => None
    }
    myFibs.take(45) should contain theSameElementsInOrderAs fibs.take(45)
  }

  "sieve" should "produce prime numbers" in {
    primes.take(7) shouldBe Stream(2, 3, 5, 7, 11, 13, 17)
    primes(100) shouldBe 547
  }
}
