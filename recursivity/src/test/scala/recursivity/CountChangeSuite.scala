package recursivity

import org.junit.runner.RunWith
import org.scalatest.{Finders, FlatSpec, Matchers}
import CountChange.countChange
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FlatSpec with Matchers {
  import CountChange.countChange

  it should "count change with 2 coins" in {
    assert(countChange(4, List(1, 2)) === 3)
  }

  it should "count change with sorted coins" in {
    assert(countChange(300, List(5, 10, 20, 50, 100, 200, 500)) === 1022)
  }

  it should "count change without small coins" in {
    assert(countChange(301, List(5, 10, 20, 50, 100, 200, 500)) === 0)
  }

  it should "count change with unsorted coins" in {
    assert(countChange(300, List(500, 5, 50, 100, 20, 200, 10)) === 1022)
  }
}
