package collections

import collections.Folds._
import org.scalatest.{FlatSpec, Matchers}

class FoldsSuite extends FlatSpec with Matchers {
  "List(a, z, e)" should "have length 3" in {
    myLength(List("a", "z", "e")) shouldBe 3
  }

  "map" should "transform a list of Strings" in {
    myMap(List("aze", "hi", "z"))(s => s.length) shouldBe List(3, 2, 1)
  }

}
