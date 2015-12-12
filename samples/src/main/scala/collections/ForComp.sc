package collections

object ForComp {
  val words = List("the", "quick", "fox", "jumped", "over", "the", "lazy", "dog")
                                                  //> words  : List[String] = List(the, quick, fox, jumped, over, the, lazy, dog)
                                                  //| 
  for {
    word <- words
    if word.length == 3
    char <- word
  } yield char                                    //> res0: List[Char] = List(t, h, e, f, o, x, t, h, e, d, o, g)
}