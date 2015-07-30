package recursivity

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.Matchers
import org.scalatest.FlatSpec

@RunWith(classOf[JUnitRunner])
class ParenthesisSuite extends FlatSpec with Matchers {
  import Parenthesis.balance

  it should "check parenthesis in code" in {
    balance("(if (zero? x) max (/ 1 x))".toList) shouldBe true
  }

  it should "check parenthesis in a sentence" in {
    balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList) shouldBe true
  }

  it should "check parenthesis in smileys" in {
    balance(":-)".toList) shouldBe false
  }

  it should "be smarter than counting" in {
    balance("())(".toList) shouldBe false
  }

}