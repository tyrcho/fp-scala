package patmat

object Simplifications {
  sealed trait Op
  case object Plus extends Op
  case object Minus extends Op
  case object Mult extends Op
  case object Div extends Op

  sealed trait Expr
  case class Number(n: Int) extends Expr {
    override val toString = n.toString
  }

  val zero = Number(0)
  val one = Number(1)

  case class BinaryExpr(op: Op, e1: Expr, e2: Expr) extends Expr

  def simplify(expr: Expr): Expr = expr match {
    case BinaryExpr(Plus, `zero`, e) => simplify(e)
    case _                           => expr
  }

}
