

class Rational(x: Int, y: Int) {
  def numer = x

  def denom = y

  def add(r: Rational): Rational =
    new Rational(numer * r.denom + r.numer * denom, denom * r.denom)

  def mul(r: Rational): Rational =
    new Rational(numer * r.numer, denom * r.denom)

  override def toString = numer + "/" + denom
}

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x.add(y).mul(z)

