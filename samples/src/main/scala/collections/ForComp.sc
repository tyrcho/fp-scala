def isPrime(i: Int) = (2 to i / 2).toList.forall(i % _ != 0)

val n = 10

(1 until n).flatMap(i => (1 until i).map(j => (i, j))).filter(pair => isPrime(pair._1 + pair._2))

for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)

(1 until n).flatMap(
  i =>
    (1 until i)
      .withFilter(j => isPrime(i + j))
      .map(j => (i, j)))



