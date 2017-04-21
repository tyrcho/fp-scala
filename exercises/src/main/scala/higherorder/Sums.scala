package higherorder

object Sums extends App {
  println(sum(identity, 10))
  println(sum(square, 10))

  def square(i: Int) = i * i

  def sumAll(n: Int): Int =
    if (n == 0) 0
    else n + sumAll(n - 1)

  def sumSquares(n: Int): Int =
    if (n == 0) 0
    else n * n + sumSquares(n - 1)

  def sum(f: Int => Int, n: Int): Int =
    ???

  def sumCubes(n: Int) =
    sum(x => x * x * x, n)

  println(sumCubes(10))
}