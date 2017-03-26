
package collections

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.Matchers
import org.scalatest.FlatSpec
import Folds._

@RunWith(classOf[JUnitRunner])
class FoldsSuite extends FlatSpec with Matchers {
  "List(a, z, e)" should "have length 3" in {
    myLength(List("a", "z", "e")) shouldBe 3
  }

  "map" should "transform a list of Strings" in {
    myMap(List("aze", "hi", "z"))(s => s.length) shouldBe List(3, 2, 1)
  }

}
