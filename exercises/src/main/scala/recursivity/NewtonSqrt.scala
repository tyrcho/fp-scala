package recursivity

object NewtonSqrt extends App {
  println(sqrt(5))
  println(sqrtDry(5))

  def abs(x: Double) =
    if (x >= 0) x else -x

  def epsilon = 0.001

  def sqrt(x: Double) = sqrtIter(???, ???)

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(???, ???)) ???
    else sqrtIter(???, ???)

  def isGoodEnough(guess: Double, x: Double) =
    ???

  def improve(guess: Double, x: Double) =
    ???

  def sqrtDry(x: Double) = {
    def sqrtIter(guess: Double): Double = {
      ???
    }
    sqrtIter(???)
  }
}
