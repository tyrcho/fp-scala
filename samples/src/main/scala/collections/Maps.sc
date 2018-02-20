
val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)


romanNumerals("V")

val inverted = romanNumerals.map { case (rom, num) => (num, rom) }




romanNumerals.get("II")
romanNumerals.get("I")

val words = List("the", "quick", "fox", "jumped", "over", "the", "lazy", "dog")


words.groupBy(_.length)



val capitalOfCountry = Map("USA" -> "Washington", "Switzerland" -> "Bern")


val capitals = capitalOfCountry.withDefaultValue("unknown")


capitals("France")
capitals.updated("France", "Paris")

capitals + ("France" -> "Paris")


capitals - "USA"


