package samples
import org.scalatest.{FlatSpec, Matchers}

class PascalTest extends FlatSpec with Matchers {
  "pascal" should "compute value for (0,0)" in {
    Pascal.pascal(0, 0) shouldBe 1
  }

}
