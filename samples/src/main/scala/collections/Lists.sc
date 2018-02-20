def isort(xs: List[Int]): List[Int] = xs match {
  case Nil => Nil
  case y :: ys => insert(y, isort(ys))
}

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case Nil => List(x)
  case y :: ys => if (y < x) y :: insert(x, ys) else x :: xs
}

isort(List(2, 9, 1, 5))

def init[T](xs: List[T]): List[T] = xs match {
  case Nil => throw new Error("init of empty List")
  case List(x) => Nil
  case y :: ys => ys
}

init(List(1, 2, 3))
