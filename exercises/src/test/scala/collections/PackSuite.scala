
package collections

import collections.Pack._
import org.scalatest.{FlatSpec, Matchers}

class PackSuite extends FlatSpec with Matchers {
  "pack" should "group elements" in {
    pack(List(1, 1, 1, 2, 3, 3, 1)) shouldBe
      List(List(1, 1, 1), List(2), List(3, 3), List(1))
  }

  "encode" should "group elements" in {
    encode(List("a", "a", "a", "b", "c", "c", "a")) shouldBe
      List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
  }

}
