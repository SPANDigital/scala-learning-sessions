/**
  Exercise Sheet 1 of the SPAN Scala Sessions.

  The content in this sheet is relevant to Weeks 1, 2, 3 and 4 of the "Functional Programming Principles
  in Scala" course covered in the Scala Developer Roadmap.
  */


/**
1) Lists & String Operators
  Calculate the sum (as an integer) of all numbers that are in the "numbers" list.
  This is possible using only 4 function-calls and no custom logic.
  */
val numbers = List(List("123", "456", "7"), List("10", "34", "9"), List("32", "54"))

val result: Int = ???


/**
2) Functions as Objects
  Implement the following functions:
  a) sumInts(), that should sum a list of integers that it takes as argument
  b) multiplyInts(), that should multiply a list of integers it takes as argument
  c) mathsEngine(), that should be able to take a list of integers (List[Int]) as well as any
     other function (sumInts() or multiplyInts()) and apply that function a given list on integers.
  */
def sumInts(ints: List[Int]): Int = ???

def multiplyInts(ints: List[Int]): Int = ???

def mathsEngine(ints: List[Int], mathFunction: ???): Int = {
  ???
}


/**
3) Polymorphism
  Context: Assume a Predator's average speed is determined simply by the Predator's
  age and max speed (maxSpeed / age).

  If a human is faster than a predator's average speed, the human can "eat"
  the predator. Else, if the predator is faster than the human, the human will "be eaten".

  Implement the function eatOrBeEaten() that takes as parameters
  a) the speed of a specific human, and b) any Predator of a specific
  age (eg. Lion(20)), and returns "eat" if the human is fater than the Predator or "be eaten"
  if the predator is faster than the human.
  */
trait Predator {
  val maxSpeed: Int
  def age: Int
  def avgSpeed: Int = maxSpeed / age
}
case class Cheetah(age: Int) extends Predator {
  override val maxSpeed: Int = 20
}
case class Lion(age: Int) extends Predator {
  override val maxSpeed: Int = 30
}

def eatOrBeEaten = {
  //take a human's speed & a predator as function parameters
  ???
}


/**
4) For-Comprehension
  Using For-Comprehension, implement the function sumOptionsFor(). The function takes 3 optional
  integers (Option[Int]) as arguments, and should sums the value of the these integers.
  * If only two (or one) integers exist, they should still be summed.

  To understand the power of Scala's For-Comprehension, do the same but using Map & Flatmap. Implement
  this in the sumOptionsMap() function.
  */
def sumOptionsFor(num1Opt: Option[Int], num2Opt: Option[Int], num3Opt: Option[Int]): Option[Int] = {
  //implement using For-Comp.
  ???
}

def sumOptionsMap(num1Opt: Option[Int], num2Opt: Option[Int], num3Opt: Option[Int]): Option[Int] = {
  //implement using map & flatmap
  ???
}


/**
5) Case Classes, Pattern Matching and Options *note, this is Week 4 content of Functional Programming
  Principles in Scala course.

  Context: An 'Ingestion' row is extracted from the ADSS database. Based on previous ingestion activity,
  this Ingestion can have 1) only a rule, 2) only an outcome, 3) both of them, or 4) neither of them.
  using pattern matching, implement the interpretRow() function so that it return the required Actions
  that must be performed on the Ingestion it receives.

  Apply the functions below to determine the required actions per Ingestion, based on the
  following Ingestion data scenarios.
  When the Ingestion has:
  a) Only a Rule             -> use useRule()
  b) Only an Outcome         -> use useOutcome()
  c) Both a Rule and Outcome -> use useBoth()
  d) Any other scenario      -> no Action to be returned
  */
case class Rule(name: String)
case class Outcome(result: String)
case class Ingestion(rule: Option[Rule], outcome: Option[Outcome])
case class Action(doThis: String)

def useRule(rule: Rule): List[Action] = {
  //DO NOT IMPLEMENT THIS FUNCTION, ONLY USE THIS FUNCTION IN interpretRow()
  ???
}
def useOutcome(rule: Outcome): List[Action] = {
  //DO NOT IMPLEMENT THIS FUNCTION, ONLY USE THIS FUNCTION IN interpretRow()
  ???
}
def useBoth(rule: Rule, outcome: Outcome): List[Action] = {
  //DO NOT IMPLEMENT THIS FUNCTION, ONLY USE THIS FUNCTION IN interpretRow()
  ???
}

def interpretRow(row: Ingestion): List[Action] = {
  //Implement this function using pattern matching
  ???
}