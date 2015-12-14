package collections

object CollectionsMore {

  val words = List("the", "quick", "fox", "jumped", "over", "the", "lazy", "dog")
                                                  //> words  : List[String] = List(the, quick, fox, jumped, over, the, lazy, dog)
                                                  //| 

  words.exists(_.length == 3)                     //> res0: Boolean = true
  words.forall(_.length >= 3)                     //> res1: Boolean = true

  (1 to 5) zip (11 to 15)                         //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,11), (2,
                                                  //| 12), (3,13), (4,14), (5,15))
  words.flatMap(_.toList)                         //> res3: List[Char] = List(t, h, e, q, u, i, c, k, f, o, x, j, u, m, p, e, d, o
                                                  //| , v, e, r, t, h, e, l, a, z, y, d, o, g)
  words.min                                       //> res4: String = dog
  words.max                                       //> res5: String = the

  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map {
      case (x, y) => x * y
    }.sum                                         //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double


words.sorted                                      //> res6: List[String] = List(dog, fox, jumped, lazy, over, quick, the, the)

words.sortBy(_.length)                            //> res7: List[String] = List(the, fox, the, dog, over, lazy, quick, jumped)
}