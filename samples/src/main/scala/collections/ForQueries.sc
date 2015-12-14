package collections

object ForQueries {
  case class Book(title: String, authors: List[String])

  val books: List[Book] = List(
    Book(title = "Structure and Interpretation of Computer Programs", authors = List("Abelson, Harald", "Sussman, Gerald J.")),
    Book(title = "Introduction to Functional Programming", authors = List("Bird, Richard", "Wadler, Phil")),
    Book(title = "Effective Java", authors = List("Bloch, Joshua")),
    Book(title = "Java Puzzlers", authors = List("Bloch, Joshua", "Gafter, Neal")),
    Book(title = "Programming in Scala", authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")))
                                                  //> books  : List[collections.ForQueries.Book] = List(Book(Structure and Interpr
                                                  //| etation of Computer Programs,List(Abelson, Harald, Sussman, Gerald J.)), Boo
                                                  //| k(Introduction to Functional Programming,List(Bird, Richard, Wadler, Phil)),
                                                  //|  Book(Effective Java,List(Bloch, Joshua)), Book(Java Puzzlers,List(Bloch, Jo
                                                  //| shua, Gafter, Neal)), Book(Programming in Scala,List(Odersky, Martin, Spoon,
                                                  //|  Lex, Venners, Bill)))

}