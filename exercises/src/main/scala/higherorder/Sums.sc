

def square(i: Int) = i * i

def sumAll(n: Int): Int =
  if (n == 0) 0
  else n + sumAll(n - 1)

def sumSquares(n: Int): Int =
  if (n == 0) 0
  else n * n + sumSquares(n - 1)

def sum(f: Int => Int, n: Int): Int =
  ???

sum(identity, 10)
sum(square, 10)

def sumCubes(n: Int) =
  sum(x => x * x * x, n)

sumCubes(10)
