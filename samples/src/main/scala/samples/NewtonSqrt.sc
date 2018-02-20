
val epsilon = 0.0001

def abs(x: Double) = if (x > 0) x else -x {


  def sqrtIter(guess: Double, x: Double): Double = {
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)
  }

  def isGoodEnough(guess: Double, x: Double) = abs(guess * guess - x) < epsilon

  def improve(guess: Double, x: Double) = (guess + x / guess) / 2

  def sqrt(x: Double) = sqrtIter(1.0, x)

  sqrt(200)
}


def sqrt(x: Double) = {

  def sqrtIter(guess: Double): Double = {

    val isGoodEnough = abs(guess * guess - x) / x < epsilon

    def improve = (guess + x / guess) / 2

    if (isGoodEnough) guess
    else sqrtIter(improve)
  }

  sqrtIter(1.0)

}

sqrt(2e20)

