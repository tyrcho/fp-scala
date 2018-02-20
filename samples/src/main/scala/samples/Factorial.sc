
import scala.annotation.tailrec

object Factorial {

  def factorial(i: Int, prod: Int = 1): Int =
    if (i <= 1) prod
    else factorial(i - 1, prod * i) //> factorial: (i: Int, prod: Int)Int

  factorial(5) //> res0: Int = 120
}