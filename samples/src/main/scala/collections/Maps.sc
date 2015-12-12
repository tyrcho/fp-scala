package collections

object Maps {

  val groups = (1 to 10).groupBy(x => x % 3)      //> groups  : scala.collection.immutable.Map[Int,scala.collection.immutable.Index
                                                  //| edSeq[Int]] = Map(2 -> Vector(2, 5, 8), 1 -> Vector(1, 4, 7, 10), 0 -> Vector
                                                  //| (3, 6, 9))
  groups.updated(2, Vector(2, 5, 8, 11))          //> res0: scala.collection.immutable.Map[Int,scala.collection.immutable.IndexedS
                                                  //| eq[Int]] = Map(2 -> Vector(2, 5, 8, 11), 1 -> Vector(1, 4, 7, 10), 0 -> Vect
                                                  //| or(3, 6, 9))
  groups - 1                                      //> res1: scala.collection.immutable.Map[Int,scala.collection.immutable.IndexedS
                                                  //| eq[Int]] = Map(2 -> Vector(2, 5, 8), 0 -> Vector(3, 6, 9))
  groups(1)                                       //> res2: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 4, 7, 10)
  groups.apply(1)                                 //> res3: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 4, 7, 10)
  groups.get(1)                                   //> res4: Option[scala.collection.immutable.IndexedSeq[Int]] = Some(Vector(1, 4,
                                                  //|  7, 10))

  groups.toList                                   //> res5: List[(Int, scala.collection.immutable.IndexedSeq[Int])] = List((2,Vect
                                                  //| or(2, 5, 8)), (1,Vector(1, 4, 7, 10)), (0,Vector(3, 6, 9)))
}