package streams.waterpouring

import org.scalatest.{FlatSpec, Matchers}

class StateTest extends FlatSpec with Matchers {

//
//  "a State" should "list possible Fill moves" in {
//    val moves = State(Set(Glass(5), Glass(7))).fillMoves
//    moves should contain theSameElementsAs Set(FillMove(Glass(5)), FillMove(Glass(7)))
//  }
//
//  it should "list possible Empty moves" in {
//    val moves = State(Set(Glass(5), Glass(7))).emptyMoves
//    moves should contain theSameElementsAs Set(EmptyMove(Glass(5)), EmptyMove(Glass(7)))
//  }
//
//  it should "list possible Pour moves" in {
//    val moves = State(Set(Glass(5), Glass(7), Glass(11))).pourMoves
//    moves should contain theSameElementsAs Set(
//      PourMove(Glass(5), Glass(7)),
//      PourMove(Glass(5), Glass(11)),
//      PourMove(Glass(7), Glass(5)),
//      PourMove(Glass(7), Glass(11)),
//      PourMove(Glass(11), Glass(5)),
//      PourMove(Glass(11), Glass(7)))
//  }
//
//  it should "list all possible moves" in {
//    val moves = State(Set(Glass(5), Glass(7), Glass(11))).moves
//    moves should have size (3 + 3 + 6)
//    moves should contain(PourMove(Glass(5), Glass(11)))
//  }
//
//  it should "update from a FillMove" in {
//    State(Set(Glass(5), Glass(7, 3))).update(FillMove(Glass(7, 3))) shouldBe
//      State(Set(Glass(5), Glass(7, 7)))
//  }
//
//  it should "update from an EmptyMove" in {
//    State(Set(Glass(5), Glass(7, 3))).update(EmptyMove(Glass(7, 3))) shouldBe
//      State(Set(Glass(5), Glass(7)))
//  }
//
//  it should "update from a PourMove" in {
//    State(Set(Glass(5), Glass(7, 3), Glass(11))).update(PourMove(Glass(7, 3), Glass(5))) shouldBe
//      State(Set(Glass(5, 3), Glass(7), Glass(11)))
//  }
//
}
