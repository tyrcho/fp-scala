
val words = List("the", "quick", "fox", "jumped", "over", "the", "lazy", "dog")

words.exists(_.length == 3)
words.forall(_.length >= 3)

(1 to 5) zip (11 to 15)

words.flatMap(_.toList)

words.min
words.max

def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map {
    case (x, y) => x * y
  }.sum

words.sorted

words.sortBy(_.length)
