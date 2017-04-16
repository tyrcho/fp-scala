case class Point(name: String, x: Long, y: Long)

case class Segment(from: Point, to: Point) {
  def distance: Double = {
    ???
  }
}

case class Path(segments: Vector[Segment])
