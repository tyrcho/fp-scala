package collections
 
object Collections {

  val words = List("the", "quick", "fox", "jumped", "over", "the", "lazy", "dog")
                                                  //> words  : List[String] = List(the, quick, fox, jumped, over, the, lazy, dog)
                                                  //| 
  List(1, 2, 3).map(x => x * 2)                   //> res0: List[Int] = List(2, 4, 6)
  words.map(w => w.length)                        //> res1: List[Int] = List(3, 5, 3, 6, 4, 3, 4, 3)

  words.filter(w => w.length == 3)                //> res2: List[String] = List(the, fox, the, dog)
  words.filterNot(w => w.length == 3)             //> res3: List[String] = List(quick, jumped, over, lazy)
  words.partition(w => w.length == 3)             //> res4: (List[String], List[String]) = (List(the, fox, the, dog),List(quick, j
                                                  //| umped, over, lazy))

  List(1, 2, 3, 4, 5).takeWhile(x => x < 3)       //> res5: List[Int] = List(1, 2)
  List(1, 2, 3, 4, 5).dropWhile(x => x < 3)       //> res6: List[Int] = List(3, 4, 5)
  List(1, 2, 3, 4, 5).span(x => x < 3)            //> res7: (List[Int], List[Int]) = (List(1, 2),List(3, 4, 5))

  def pack[T](list: List[T]): List[List[T]] = list match {
    case Nil => Nil
    case x :: xs =>
      list.takeWhile(e => e == x) :: pack(list.dropWhile(e => e == x))
  }                                               //> pack: [T](list: List[T])List[List[T]]

  pack(List(1, 1, 1, 1, 2, 2, 1, 1, 3, 3, 4, 5, 5))
                                                  //> res8: List[List[Int]] = List(List(1, 1, 1, 1), List(2, 2), List(1, 1), List(
                                                  //| 3, 3), List(4), List(5, 5))

  def encode[T](list: List[T]) = {
    def encAux(p: List[List[T]]): List[(T, Int)] = p match {
      case Nil          => Nil
      case elts :: tail => (elts.head, elts.size) :: encAux(tail)
    }
    encAux(pack(list))
  }                                               //> encode: [T](list: List[T])List[(T, Int)]

  encode(List(1, 1, 1, 1, 2, 2, 1, 1, 3, 3, 4, 5, 5))
                                                  //> res9: List[(Int, Int)] = List((1,4), (2,2), (1,2), (3,2), (4,1), (5,2))

}