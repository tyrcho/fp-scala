package samples

object Curry {

  // def sum(f: Int => Int): Int => Int = {
  //  def sumF(n: Int): Int =
  //      if (n == 0) 0
  // else f(n) + sumF(n - 1)
  // sumF
  //}

  def sum(f: Int => Int)(n: Int): Int =
    if (n == 0) 0
    else f(n) + sum(f)(n - 1)                     //> sum: (f: Int => Int)(n: Int)Int

  def sumAll = sum(identity) _                    //> sumAll: => Int => Int

  sum _                                           //> res0: (Int => Int) => (Int => Int) = <function1>

  sumAll(10)                                      //> res1: Int = 55

  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int

  def sumCubes = sum(cube) _                      //> sumCubes: => Int => Int

  sumCubes(3)                                     //> res2: Int = 36

  sum(x => x * x)(10)                             //> res3: Int = 385

  def sumt(f: Int => Int)(n: Int): Int = {

    def loop(n: Int, total: Int): Int =
      if (???) ???
      else loop(???, ???)

    loop(???, ???)
  }                                               //> sumt: (f: Int => Int)(n: Int)Int

 // sumt(x => x * x)(10)
}