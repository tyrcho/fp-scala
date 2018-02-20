
val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

numbers.reduce((x, y) => x + y)
numbers.reduce(_ + _)



numbers.fold(0)(_ + _)
numbers.fold(1)(_ * _)
Nil.fold(0)(_ + _)
Nil.fold(1)(_ * _)

(1 to 10).sum
(1 to 10).product

def lengthFun[T](xs: List[T]): Int =
  xs.foldRight(0) { (elt, length) =>
    1 + length
  }

lengthFun(numbers)

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  xs.foldRight(List.empty[U]) { (elt, listRes) =>
    f(elt) :: listRes
  }

mapFun(numbers, (x: Int) => x + 3)

