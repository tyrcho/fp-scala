
val words = List("the", "quick", "fox", "jumped", "over")

words.length
words(2)

words.mkString(" ")

words.head
words.tail

words.last
words.init

words.reverse
words.updated(0, "a")
words.contains("the")
words.contains("a")

val words2 = List("the", "lazy", "dog")
val phrase = words ++ words2

phrase.take(3)
phrase.drop(3)

words.sorted
words.sortBy(w => w.length)

words.distinct

val (short, long) = phrase.partition(w => w.length <= 3)



