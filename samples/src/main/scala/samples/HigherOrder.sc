package samples

object HigherOrder {

  def sumAll(n: Int): Int =
    if (n == 0) 0
    else n + sumAll(n - 1)                        //> sumAll: (n: Int)Int

  sumAll(10)                                      //> res0: Int = 55

  def sumSquares(n: Int): Int =
    if (n == 0) 0
    else n * n + sumSquares(n - 1)                //> sumSquares: (n: Int)Int

  sumSquares(10)                                  //> res1: Int = 385



  def sum(f: Int => Int, n: Int): Int =
    if (n == 0) 0
    else f(n) + sum(f, n - 1)                     //> sum: (f: Int => Int, n: Int)Int

  def sumAll2(n: Int) = sum(identity, n)          //> sumAll2: (n: Int)Int

  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int

  def sumCubes(n: Int) = sum(cube, n)             //> sumCubes: (n: Int)Int



  sumCubes(10)                                    //> res2: Int = 3025
}