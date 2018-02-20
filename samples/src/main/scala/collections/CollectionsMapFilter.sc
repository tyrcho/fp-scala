

val words = List("the", "quick", "fox", "jumped", "over", "the", "lazy", "dog")


List(1, 2, 3).map(x => x * 2)
words.map(w => w.length)

words.filter(w => w.length == 3)
words.filterNot(w => w.length == 3)
words.partition(w => w.length == 3)


List(1, 2, 3, 4, 5).takeWhile(x => x < 3)
List(1, 2, 3, 4, 5).dropWhile(x => x < 3)
List(1, 2, 3, 4, 5).span(x => x < 3)

def pack[T](list: List[T]): List[List[T]] = list match {
  case Nil => Nil
  case x :: xs =>
    list.takeWhile(e => e == x) :: pack(list.dropWhile(e => e == x))
}

pack(List(1, 1, 1, 1, 2, 2, 1, 1, 3, 3, 4, 5, 5))



def encode[T](list: List[T]) = {
  def encAux(p: List[List[T]]): List[(T, Int)] = p match {
    case Nil => Nil
    case elts :: tail => (elts.head, elts.size) :: encAux(tail)
  }

  encAux(pack(list))
}

encode(List(1, 1, 1, 1, 2, 2, 1, 1, 3, 3, 4, 5, 5))


