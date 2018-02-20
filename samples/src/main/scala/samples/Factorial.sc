


def factorial(i: Int, prod: Int = 1): Int =
  if (i <= 1) prod
  else factorial(i - 1, prod * i)

factorial(5)