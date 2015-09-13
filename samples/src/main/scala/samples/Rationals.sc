package samples

object Rationals {
  class Rational(x: Int, y: Int) {
    def numer = x
    def denom = y

    def add(r: Rational): Rational =
      new Rational(numer * r.denom + r.numer * denom, denom * r.denom)

    def mul(r: Rational): Rational =
      new Rational(numer * r.numer, denom * r.denom)

    override def toString = numer + "/" + denom
  }

  val x = new Rational(1, 3)                      //> x  : samples.Rationals.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : samples.Rationals.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : samples.Rationals.Rational = 3/2
  x.add(y).mul(z)                                 //> res0: samples.Rationals.Rational = 66/42

}