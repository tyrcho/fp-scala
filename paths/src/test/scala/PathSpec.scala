import org.scalatest.{FlatSpec, Matchers}

class PathSpec extends FlatSpec with Matchers {

  val tl = Point("tl", 0, -10)
  val t = Point("t", 0, 0)
  val tr = Point("tr", 0, 10)
  val bl = Point("bl", 10, -10)
  val b = Point("b", 10, 0)
  val br = Point("br", 10, 20)

  // tl - t - tr
  //  |   |    |
  // bl - b --- br

  val points = Vector(tl, t, tr, bl, b, br)

  val tlt = Segment(tl, t)
  val ttr = Segment(t, tr)
  val topPath = Path(Vector(tlt, ttr))
  val blb = Segment(bl, b)
  val bbr = Segment(b, br)
  val botPath = Path(Vector(blb, bbr))

  "a segment" should "compute its distance" in {
    val distance = tlt.distance
    distance shouldBe 10.0 +- 0.0001
  }

  val helper = new PathHelper

  it should "find the best path" in {
    val segments = Vector(
      Segment(tl, tr),
      Segment(tr, br),
      Segment(tl, bl),
      Segment(bl, br))

    helper.bestPath(segments, tl, br).get shouldBe Path(Vector(
      Segment(tl, tr),
      Segment(tr, br)))
  }

  it should "find the best path with a stop" in {
    val segments = Vector(
      Segment(tl, tr),
      Segment(tr, br),
      Segment(tl, bl),
      Segment(bl, br))

    helper.bestPath(segments, tl, br, Vector(bl)).get shouldBe Path(Vector(
      Segment(tl, bl),
      Segment(bl, br)))
  }

}
