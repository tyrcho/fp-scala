package collections

object Maps {

  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -
                                                  //| > 5, X -> 10)
  romanNumerals("V")                              //> res0: Int = 5

  val inverted = romanNumerals.map { case (rom, num) => (num, rom) }
                                                  //> inverted  : scala.collection.immutable.Map[Int,String] = Map(1 -> I, 5 -> V,
                                                  //|  10 -> X)

  //romanNumerals("II")
  romanNumerals.get("II")                         //> res1: Option[Int] = None
  romanNumerals.get("I")                          //> res2: Option[Int] = Some(1)

  val words = List("the", "quick", "fox", "jumped", "over", "the", "lazy", "dog")
                                                  //> words  : List[String] = List(the, quick, fox, jumped, over, the, lazy, dog)
                                                  //| 
  words.groupBy(_.length)                         //> res3: scala.collection.immutable.Map[Int,List[String]] = Map(5 -> List(quick
                                                  //| ), 4 -> List(over, lazy), 3 -> List(the, fox, the, dog), 6 -> List(jumped))
                                                  //| 

  val capitalOfCountry = Map("USA" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(USA 
                                                  //| -> Washington, Switzerland -> Bern)
  val capitals = capitalOfCountry.withDefaultValue("unknown")
                                                  //> capitals  : scala.collection.immutable.Map[String,String] = Map(USA -> Washi
                                                  //| ngton, Switzerland -> Bern)
  capitals("France")                              //> res4: String = unknown
  capitals.updated("France", "Paris")             //> res5: scala.collection.immutable.Map[String,String] = Map(USA -> Washington,
                                                  //|  Switzerland -> Bern, France -> Paris)
  capitals + ("France" -> "Paris")                //> res6: scala.collection.immutable.Map[String,String] = Map(USA -> Washington,
                                                  //|  Switzerland -> Bern, France -> Paris)

  capitals - "USA"                                //> res7: scala.collection.immutable.Map[String,String] = Map(Switzerland -> Ber
                                                  //| n)

}