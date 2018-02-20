
def sum(f: Int => Int)(n: Int): Int =
  if (n == 0) 0
  else f(n) + sum(f)(n - 1)

def sumAll = sum(identity) _

sum _

sumAll(10)

def cube(x: Int): Int = x * x * x

def sumCubes = sum(cube) _

sumCubes(3)

sum(x => x * x)(10)

def sumt(f: Int => Int)(n: Int): Int = {

  def loop(n: Int, total: Int): Int =
    if (???) ???
    else loop(???, ???)

  loop(???, ???)
}
