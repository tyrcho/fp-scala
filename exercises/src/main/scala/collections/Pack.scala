package collections

object Pack {
  // Hint : takeWhile/dropWhile or span
  def pack[T](list: List[T]): List[List[T]] = list match {
    case Nil    => ???
    case h :: t => ???
  }

  def encode[T](list: List[T]): List[(T, Int)] =
    ???

}
