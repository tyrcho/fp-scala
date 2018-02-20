

def sumAll(n: Int): Int =
  if (n == 0) 0
  else n + sumAll(n - 1)

sumAll(10)

def sumSquares(n: Int): Int =
  if (n == 0) 0
  else n * n + sumSquares(n - 1)

sumSquares(10)

def sum(f: Int => Int, n: Int): Int =
  if (n == 0) 0
  else f(n) + sum(f, n - 1)

def sumAll2(n: Int) = sum(identity, n)

def cube(x: Int): Int = x * x * x

def sumCubes(n: Int) = sum(cube, n)


sumCubes(10)
