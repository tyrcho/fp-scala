package samples

object PatternMatching2 {
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  val s = Sum(Number(2), Number(3))               //> s  : samples.PatternMatching2.Sum = Sum(Number(2),Number(3))

  def eval(e: Expr): Int = e match {
    case Number(n)    => n
    case Sum(e1, e2)  => eval(e1) + eval(e2)
    case Prod(e1, e2) => eval(e1) * eval(e2)
  }                                               //> eval: (e: samples.PatternMatching2.Expr)Int

  eval(s)                                         //> res0: Int = 5

  def show(e: Expr): String = e match {
    case Number(n)              => n.toString
    case Sum(e1, e2)            => show(e1) + "+" + show(e2)
    case Prod(e1: Sum, e2: Sum) => "(" + show(e1) + ")*(" + show(e2) + ")"
    case Prod(e1: Sum, e2)      => "(" + show(e1) + ")*" + show(e2)
    case Prod(e1, e2: Sum)      => show(e1) + "*(" + show(e2) + ")"
    case Prod(e1, e2)           => show(e1) + "*" + show(e2)
  }                                               //> show: (e: samples.PatternMatching2.Expr)String

  val sumProd = Sum(Prod(Number(3), Number(5)), Prod(Number(2), Number(4)))
                                                  //> sumProd  : samples.PatternMatching2.Sum = Sum(Prod(Number(3),Number(5)),Prod
                                                  //| (Number(2),Number(4)))
  val prodSum = Prod(Sum(Number(3), Number(5)), Sum(Number(2), Number(4)))
                                                  //> prodSum  : samples.PatternMatching2.Prod = Prod(Sum(Number(3),Number(5)),Sum
                                                  //| (Number(2),Number(4)))
  val prodSum2 = Prod(Sum(Number(3), Number(5)), Number(4))
                                                  //> prodSum2  : samples.PatternMatching2.Prod = Prod(Sum(Number(3),Number(5)),N
                                                  //| umber(4))
  val prodSum3 = Prod(Number(5), Sum(Number(2), Number(4)))
                                                  //> prodSum3  : samples.PatternMatching2.Prod = Prod(Number(5),Sum(Number(2),Nu
                                                  //| mber(4)))

  show(sumProd)                                   //> res1: String = 3*5+2*4
  show(prodSum)                                   //> res2: String = (3+5)*(2+4)
  show(prodSum2)                                  //> res3: String = (3+5)*4
  show(prodSum3)                                  //> res4: String = 5*(2+4)

  prodSum match {
    case Prod(e1: Sum, e2: Sum)   =>
    // matches a Prod of any 2 Sum
    case Prod(`s`, `s`)           =>
    // matches a Prod of s by s (already in the scope)
    case Prod(e1 @ Sum(a, b), e2) =>
    // matches a Prod of a Sum with any expr e2
    // a,b, e1 (alias) and e2 can be used after the =>
  }

}