package samples

object PackEncode {
  def pack[T](list: List[T]): List[List[T]] = list match {
    case Nil => Nil
    case h :: t =>
      val (first, rest) = list.span(e => e == h)
      first :: pack(rest)
  }                                               //> pack: [T](list: List[T])List[List[T]]

  val numbers = List(1, 1, 3, 3, 3, 5, 5, 4, 7, 7, 7)
                                                  //> numbers  : List[Int] = List(1, 1, 3, 3, 3, 5, 5, 4, 7, 7, 7)
  pack(numbers)                                   //> res0: List[List[Int]] = List(List(1, 1), List(3, 3, 3), List(5, 5), List(4),
                                                  //|  List(7, 7, 7))

  def encode[T](list: List[T]): List[(Int, T)] =
    pack(list).map(xs => (xs.length, xs.head))    //> encode: [T](list: List[T])List[(Int, T)]

  encode(numbers)                                 //> res1: List[(Int, Int)] = List((2,1), (3,3), (2,5), (1,4), (3,7))

}