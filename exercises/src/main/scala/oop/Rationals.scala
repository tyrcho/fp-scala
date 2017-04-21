package oop

object Rationals extends App {
  println(new Rational(1, 2))

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  println(x.add(y).mul(z))
  //  println(x - y)
  //  println(-x / z)

}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

  def add(r: Rational): Rational =
    new Rational(numer * r.denom + r.numer * denom,
      denom * r.denom)

  def mul(r: Rational): Rational =
    new Rational(numer * r.numer, denom * r.denom)

  override def toString = numer + "/" + denom

  def less(that: Rational): Boolean =
    ???

  def max(that: Rational): Rational =
    ???

  def +(r: Rational): Rational = ???
  def +(i: Int): Rational = ???

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

}