package samples

object InsertionSort {
  def isort(xs: List[Int]): List[Int] = xs match {
    case Nil     => Nil
    case y :: ys => insert(y, isort(ys))
  }                                               //> isort: (xs: List[Int])List[Int]

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil     => List(x)
    case y :: ys => if (y < x) y :: insert(x, ys) else x :: xs
  }                                               //> insert: (x: Int, xs: List[Int])List[Int]

  isort(List(2, 9, 1, 5))                         //> res0: List[Int] = List(1, 2, 5, 9)
}