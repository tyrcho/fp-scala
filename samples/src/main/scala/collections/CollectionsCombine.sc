package collections

object CollectionsCombine {

  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                                                  //> numbers  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  numbers.reduce((x, y) => x + y)                 //> res0: Int = 55
  numbers.reduce(_ + _)                           //> res1: Int = 55

  //List.empty[Int].reduce(_ + _)

  numbers.fold(0)(_ + _)                          //> res2: Int = 55
  numbers.fold(1)(_ * _)                          //> res3: Int = 3628800
  Nil.fold(0)(_ + _)                              //> res4: Int = 0
  Nil.fold(1)(_ * _)                              //> res5: Int = 1

  (1 to 10).sum                                   //> res6: Int = 55

  def lengthFun[T](xs: List[T]): Int =
    xs.foldRight(0) { (elt, length) =>
      1 + length
    }                                             //> lengthFun: [T](xs: List[T])Int

  lengthFun(numbers)                              //> res7: Int = 10

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    xs.foldRight(List.empty[U]) { (elt, listRes) =>
      f(elt) :: listRes
    }                                             //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  mapFun(numbers, (x: Int) => x + 3)              //> res8: List[Int] = List(4, 5, 6, 7, 8, 9, 10, 11, 12, 13)

}