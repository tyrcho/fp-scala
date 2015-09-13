package samples

object Rationals2 {
  class Rational(x: Int, y: Int) {
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private val g = gcd(x, y)

    val numer = x / g
    val denom = y / g

    def add(r: Rational): Rational =
      new Rational(numer * r.denom + r.numer * denom, denom * r.denom)

    def mul(r: Rational): Rational =
      new Rational(numer * r.numer, denom * r.denom)

    override def toString = numer + "/" + denom
  }

  val x = new Rational(1, 3)                      //> x  : samples.Rationals2.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : samples.Rationals2.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : samples.Rationals2.Rational = 3/2
  x.add(y).mul(z)                                 //> res0: samples.Rationals2.Rational = 11/7

}