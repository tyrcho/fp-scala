package collections

object Ranges {
  1 until 5                                       //> res0: scala.collection.immutable.Range = Range(1, 2, 3, 4)
  1 to 5                                          //> res1: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)
  1 to 10 by 3                                    //> res2: scala.collection.immutable.Range = Range(1, 4, 7, 10)
  6 to 1 by -2                                    //> res3: scala.collection.immutable.Range = Range(6, 4, 2)
}