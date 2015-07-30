package samples

object NewtonSqrt {
  val epsilon = 0.0001                            //> epsilon  : Double = 1.0E-4

  def abs(x: Double) = if (x > 0) x else -x       //> abs: (x: Double)Double

  {
    //initial, naive

    def sqrtIter(guess: Double, x: Double): Double = {
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)
    }

    def isGoodEnough(guess: Double, x: Double) = abs(guess * guess - x) < epsilon

    def improve(guess: Double, x: Double) = (guess + x / guess) / 2

    def sqrt(x: Double) = sqrtIter(1.0, x)

    sqrt(200)
  }                                               //> res0: Double = 14.142136001158033

  //hide private methods
  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double = {

      val isGoodEnough = abs(guess * guess - x) / x < epsilon

      def improve = (guess + x / guess) / 2

      if (isGoodEnough) guess
      else sqrtIter(improve)
    }

    sqrtIter(1.0)

  }                                               //> sqrt: (x: Double)Double

  sqrt(2e20)                                      //> res1: Double = 1.4142135726118847E10

}