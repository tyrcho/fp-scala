
object PatternMatching {

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  val s = Sum(Number(2), Number(3)) //> s  : samples.PatternMatching.Sum = Sum(Number(2),Number(3))

  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
  } //> eval: (e: samples.PatternMatching.Expr)Int

  eval(s) //> res0: Int = 5

  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) => show(e1) + "+" + show(e2)
  } //> show: (e: samples.PatternMatching.Expr)String

  show(s) //> res1: String = 2+3
}