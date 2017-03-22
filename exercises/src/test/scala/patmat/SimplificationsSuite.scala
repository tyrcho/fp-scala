package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.Matchers
import org.scalatest.FlatSpec
import Simplifications._

@RunWith(classOf[JUnitRunner])
class SimplificationsSuite extends FlatSpec with Matchers {
  val five = Number(5)
  val three = Number(3)
  val eight = Number(8)

  "5 - 0" should "simplify to 5" in {
    simplify(BinaryExpr(Minus, five, zero)) shouldBe five
  }

  "0 - 5" should "stay" in {
    simplify(BinaryExpr(Minus, zero, five)) shouldBe BinaryExpr(Minus, zero, five)
  }

  "1 * 5" should "simplify to 5" in {
    simplify(BinaryExpr(Mult, one, five)) shouldBe five
  }

  "1 * 5 - 0" should "simplify to 5" in {
    simplify(BinaryExpr(Minus, BinaryExpr(Mult, one, five), zero)) shouldBe five
  }

  "3 * 5 - 3 * 8" should "simplify to 3 * (5 - 8)" in {
    simplify(BinaryExpr(Minus,
      BinaryExpr(Mult, three, five),
      BinaryExpr(Mult, three, eight))) shouldBe
      BinaryExpr(Mult, three, BinaryExpr(Minus, five, eight))
  }

}

