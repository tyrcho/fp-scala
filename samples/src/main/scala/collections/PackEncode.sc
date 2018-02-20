
def pack[T](list: List[T]): List[List[T]] = list match {
  case Nil => Nil
  case h :: t =>
    val (first, rest) = list.span(e => e == h)
    first :: pack(rest)
}

val numbers = List(1, 1, 3, 3, 3, 5, 5, 4, 7, 7, 7)

pack(numbers)


def encode[T](list: List[T]): List[(Int, T)] =
  pack(list).map(xs => (xs.length, xs.head))

encode(numbers)

