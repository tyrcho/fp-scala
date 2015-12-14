package collections

object CollectionsBasic {

  val words = List("the", "quick", "fox", "jumped", "over")
                                                  //> words  : List[String] = List(the, quick, fox, jumped, over)
  words.length                                    //> res0: Int = 5
  words(2)                                        //> res1: String = fox

  words.mkString(" ")                             //> res2: String = the quick fox jumped over

  words.head                                      //> res3: String = the
  words.tail                                      //> res4: List[String] = List(quick, fox, jumped, over)

  words.last                                      //> res5: String = over
  words.init                                      //> res6: List[String] = List(the, quick, fox, jumped)

  words.reverse                                   //> res7: List[String] = List(over, jumped, fox, quick, the)
  words.updated(0, "a")                           //> res8: List[String] = List(a, quick, fox, jumped, over)
  words.contains("the")                           //> res9: Boolean = true
  words.contains("a")                             //> res10: Boolean = false

  val words2 = List("the", "lazy", "dog")         //> words2  : List[String] = List(the, lazy, dog)
  val phrase = words ++ words2                    //> phrase  : List[String] = List(the, quick, fox, jumped, over, the, lazy, dog)
                                                  //| 
  phrase.take(3)                                  //> res11: List[String] = List(the, quick, fox)
  phrase.drop(3)                                  //> res12: List[String] = List(jumped, over, the, lazy, dog)

  words.sorted                                    //> res13: List[String] = List(fox, jumped, over, quick, the)
  words.sortBy(w => w.length)                     //> res14: List[String] = List(the, fox, over, quick, jumped)

  words.distinct                                  //> res15: List[String] = List(the, quick, fox, jumped, over)

  val (short, long) = phrase.partition(w => w.length <= 3)
                                                  //> short  : List[String] = List(the, fox, the, dog)
                                                  //| long  : List[String] = List(quick, jumped, over, lazy)

}