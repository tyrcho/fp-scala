package collections

object CollectionsBasic {

  val words = List("the", "quick", "fox")         //> words  : List[String] = List(the, quick, fox)
  words.length                                    //> res0: Int = 3
  words(2)                                        //> res1: String = fox

  words.mkString(" ")                             //> res2: String = the quick fox
 
  words.head                                      //> res3: String = the
  words.tail                                      //> res4: List[String] = List(quick, fox)

  words.last                                      //> res5: String = fox
  words.init                                      //> res6: List[String] = List(the, quick)

  words.reverse                                   //> res7: List[String] = List(fox, quick, the)
  words.updated(0, "a")                           //> res8: List[String] = List(a, quick, fox)
  words.contains("the")                           //> res9: Boolean = true
  words.contains("a")                             //> res10: Boolean = false

  val words2 = List("jumped", "over", "the", "lazy", "dog")
                                                  //> words2  : List[String] = List(jumped, over, the, lazy, dog)
  val phrase = words ++ words2                    //> phrase  : List[String] = List(the, quick, fox, jumped, over, the, lazy, dog)
                                                  //| 
  phrase.take(3)                                  //> res11: List[String] = List(the, quick, fox)
  phrase.drop(3)                                  //> res12: List[String] = List(jumped, over, the, lazy, dog)

  words.sorted                                    //> res13: List[String] = List(fox, quick, the)
  words.sortBy(w => w.length)                     //> res14: List[String] = List(the, fox, quick)

  words.distinct                                  //> res15: List[String] = List(the, quick, fox)

  val (short, long) = phrase.partition(w => w.length <= 3)
                                                  //> short  : List[String] = List(the, fox, the, dog)
                                                  //| long  : List[String] = List(quick, jumped, over, lazy)

}