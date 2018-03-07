package funsets

import org.scalatest.{FlatSpec, Matchers}

class FunSetSuite extends FlatSpec with Matchers {

  import FunSets._

  "contains" should "be implemented" in {
    // this actually tests that the set of all bound integers contains 100
    assert(contains(x => true, 100))
  }

  /**
    * When writing tests, one would often like to re-use certain values for multiple
    * tests. For instance, we would like to create an Int-set and have multiple test
    * about it.
    *
    * Instead of copy-pasting the code for creating the set into every test, we can
    * store it in the test class using a val:
    *
    * val s1 = singletonSet(1)
    *
    * However, what happens if the method "singletonSet" has a bug and crashes? Then
    * the test methods are not even executed, because creating an instance of the
    * test class fails!
    *
    * Therefore, we put the shared values into a separate trait (traits are like
    * abstract classes), and create an instance inside each test method.
    */
  trait TestSets {
    val s1 = singleElementSet(1)
    val s2 = singleElementSet(2)
    val s3 = singleElementSet(3)
    val s4 = singleElementSet(4)
  }

  "singletonSet" should "contain one element" in {
    /**
      * We create a new instance of the "TestSets" trait, this gives us access
      * to the values "s1" to "s3".
      */
    new TestSets {
      /**
        * The string argument of "assert" is a message that is printed in case
        * the test fails. This helps identifying which assertion failed.
        */
      assert(contains(s1, 1), "Singleton")
    }
  }

  "union of 1 and 2" should "contain 1, 2 but not 3" in {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  trait TestSetsUnion extends TestSets {
    val s12 = union(s1, s2)
    val s23 = union(s3, s2)
    val s1234 = union(union(s1, s2), union(s3, s4))
  }

  "intersection of (1, 2) and (2, 3)" should "contain only 2" in {
    new TestSetsUnion {
      val intersection = intersect(s12, s23)
      assert(!contains(intersection, 1), "Intersection 1")
      assert(contains(intersection, 2), "Intersection 2")
      assert(!contains(intersection, 3), "Intersection 3")
    }
  }

  "diff of (1, 2, 3, 4) and (2, 3)" should "contain only (1, 4)" in {
    new TestSetsUnion {
      val difference = diff(s1234, s23)
      assert(contains(difference, 1), "Difference 1")
      assert(!contains(difference, 2), "Difference 2")
      assert(!contains(difference, 3), "Difference 3")
      assert(contains(difference, 4), "Difference 4")
    }
  }


  "diff of (1, 2) and (2, 3)" should "contain only (1)" in {
    new TestSetsUnion {
      val difference = diff(s12, s23)
      assert(contains(difference, 1), "Difference 1")
      assert(!contains(difference, 2), "Difference 2")
      assert(!contains(difference, 3), "Difference 3")
    }
  }

  "filter of (1, 2, 3, 4) for odd numbers" should "contain only (1, 3)" in {
    new TestSetsUnion {
      val filtered = filter(s1234, x => x % 2 == 1)
      assert(contains(filtered, 1), "Filtered 1")
      assert(!contains(filtered, 2), "Filtered 2")
      assert(contains(filtered, 3), "Filtered 3")
      assert(!contains(filtered, 4), "Filtered 4")
    }
  }

  "forall of (1, 2, 3, 4) for odd numbers" should "be false" in {
    new TestSetsUnion {
      forall(s1234, x => x % 2 == 1) shouldBe false
    }
  }

  "forall of (1, 2, 3, 4) for small numbers" should "be true" in {
    new TestSetsUnion {
      forall(s1234, x => x < 5) shouldBe true
    }
  }

  "forall of (1, 2, 3, 4) for large numbers" should "be false" in {
    new TestSetsUnion {
      forall(s1234, x => x > 5) shouldBe false
    }
  }

  "exists of (1, 2, 3, 4) for odd numbers" should "be true" in {
    new TestSetsUnion {
      exists(s1234, x => x % 2 == 1) shouldBe true
    }
  }

  "exists of (1, 2, 3, 4) for large numbers" should "be false" in {
    new TestSetsUnion {
      exists(s1234, x => x > 5) shouldBe false
    }
  }

  "map of (1, 2, 3, 4) for square" should "be (1, 4, 9, 16)" in {
    new TestSetsUnion {
      val mapped = map(s1234, x => x * x)
      assert(contains(mapped, 1), "Mapped 1")
      assert(contains(mapped, 4), "Mapped 4")
      assert(contains(mapped, 16), "Mapped 16")
    }
  }

  "toSet(List(1,2,3,4))" should "contain same elements" in {
    val set = toSet(List(1, 2, 3, 4))
    assert(contains(set, 1))
    assert(contains(set, 2))
    assert(contains(set, 3))
    assert(contains(set, 4))
    assert(!contains(set, 5))
  }

  "toList(1,2,3,4)" should "contain same elements" in {
    new TestSetsUnion {
      val list = toList(s1234)
      list should contain theSameElementsAs List(1, 2, 3, 4)
    }
  }

}
