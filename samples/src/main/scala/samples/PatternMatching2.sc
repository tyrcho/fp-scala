

trait Expr

case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Prod(e1: Expr, e2: Expr) extends Expr

val s = Sum(Number(2), Number(3))

def eval(e: Expr): Int = e match {
  case Number(n)    => n
  case Sum(e1, e2)  => eval(e1) + eval(e2)
  case Prod(e1, e2) => eval(e1) * eval(e2)
}

eval(s)

def show(e: Expr): String = e match {
  case Number(n)              => n.toString
  case Sum(e1, e2)            => show(e1) + "+" + show(e2)
  case Prod(e1: Sum, e2: Sum) => "(" + show(e1) + ")*(" + show(e2) + ")"
  case Prod(e1: Sum, e2)      => "(" + show(e1) + ")*" + show(e2)
  case Prod(e1, e2: Sum)      => show(e1) + "*(" + show(e2) + ")"
  case Prod(e1, e2)           => show(e1) + "*" + show(e2)
}

val sumProd = Sum(Prod(Number(3), Number(5)), Prod(Number(2), Number(4)))

val prodSum = Prod(Sum(Number(3), Number(5)), Sum(Number(2), Number(4)))

val prodSum2 = Prod(Sum(Number(3), Number(5)), Number(4))

val prodSum3 = Prod(Number(5), Sum(Number(2), Number(4)))

show(sumProd)
show(prodSum)
show(prodSum2)
show(prodSum3)

prodSum match {
  case Prod(e1: Sum, e2: Sum)   =>
  case Prod(`s`, `s`)           =>
  case Prod(e1 @ Sum(a, b), e2) =>
}

