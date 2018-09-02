package oop

import java.util.NoSuchElementException

trait MyList[T] {
  def isEmpty: Boolean
  def head: T
  def tail: MyList[T]
}

class Cons[T](val head: T, val tail: MyList[T]) extends MyList[T] {
  def isEmpty = false
}

class Nil[T] extends MyList[T] {
  def isEmpty = true
  def head    = throw new NoSuchElementException("Nil.head")
  def tail    = throw new NoSuchElementException("Nil.tail")
}

object MyDemo extends App {
  //  val l = Nil.prepend(3)
  //  l.prepend(2)
  //  println(l.head)
  //  println(l.tail.head)

}
