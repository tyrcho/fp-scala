package streams.waterpouring

import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{FlatSpec, Matchers}

class GlassesTest extends FlatSpec with Matchers {
//  "a glass" should "be empty at start" in {
//    Glass(capacity = 9).water shouldBe 0
//  }
//
//  it should "be filled" in {
//    Glass(capacity = 9).fill.water shouldBe 9
//  }
//
//  it should "be emptied" in {
//    Glass(capacity = 9, water = 5).empty.water shouldBe 0
//  }
//
//  "2 glasses" should "compute amount to pour" in {
//    val scenarios =
//      Table(
//        ("fromGlass", "toGlass", "expectedAmount"),
//        (Glass(capacity = 100), Glass(capacity = 10), 0), // nothing in source
//        (Glass(capacity = 100, water = 6), Glass(capacity = 10, water = 10), 0), // destination is full
//        (Glass(capacity = 100, water = 6), Glass(capacity = 10, water = 8), 2), // enough to fill destination
//        (Glass(capacity = 100, water = 5), Glass(capacity = 10), 5) // all from source
//      )
//
//    forAll(scenarios) { (from, to, expectedAmount) =>
//      from.amountToPourTo(to) shouldBe expectedAmount
//    }
//  }
//
//  they should "pour properly" in {
//    val scenarios =
//      Table(
//        ("fromGlass", "toGlass", "expectedFrom", "expectedTo"),
//        (Glass(capacity = 100), Glass(capacity = 10), Glass(capacity = 100), Glass(capacity = 10)), // nothing in source
//        (Glass(capacity = 100, water = 6), Glass(capacity = 10, water = 10), Glass(capacity = 100, water = 6), Glass(capacity = 10, water = 10)), // destination is full
//        (Glass(capacity = 100, water = 6), Glass(capacity = 10, water = 8), Glass(capacity = 100, water = 4), Glass(capacity = 10, water = 10)), // enough to fill destination
//        (Glass(capacity = 100, water = 5), Glass(capacity = 10), Glass(capacity = 100), Glass(capacity = 10, water = 5)) // all from source
//      )
//
//    forAll(scenarios) { (from, to, expectedFrom, expectedTo) =>
//      val (actualFrom, actualTo) = from.pourTo(to)
//      actualFrom shouldBe expectedFrom
//      actualTo shouldBe expectedTo
//    }
//  }
}
