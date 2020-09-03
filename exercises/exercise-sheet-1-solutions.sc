/**
  * Solutions to Sheet 1 of the SPAN Scala Sessions.
  */
/**
  1) Lists & String Operators
  */
val numbers = List(List("123", "456", "7"), List("10", "34", "9"), List("32", "54"))
//SOLUTION(S)
//UNSAFE
val result1 = numbers.flatten.map(_.toInt).sum
val result2 = numbers.flatMap(_.map(_.toInt)).sum
//SAFE
val result1 = numbers.flatten.flatMap(_.toIntOption).sum
val result2 = numbers.flatMap(_.flatMap(_.toIntOption)).sum
/**
  2) Functions as Objects
  */
def sumInts(ints: List[Int]): Int = ints.sum
def multiplyInts(ints: List[Int]): Int = ints.product
//SOLUTION(S)
def mathsEngine(ints: List[Int], mathFunction: List[Int] => Int): Int =
  mathFunction(ints)
//TEST
mathsEngine(List(1,1,2), sumInts)
/**
  3) Polymorphism
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
//SOLUTION(S)
def eatOrBeEaten(humanSpeed: Int, predator: Predator) =
  if(predator.avgSpeed > humanSpeed) "be eaten" else "eat"
//TEST
eatOrBeEaten(10, Cheetah(10))
eatOrBeEaten(20, Lion(1))
/**
  4) For-Comprehension
  */
//SOLUTION(S)
def sumOptionsFor(num1Opt: Option[Int], num2Opt: Option[Int], num3Opt: Option[Int]): Option[Int] = {
  val result = for {
    num1 <- num1Opt
    num2 <- num2Opt
    num3 <- num3Opt
  } yield num1 + num2 + num3
  result
}
def sumOptionsMap(num1Opt: Option[Int], num2Opt: Option[Int], num3Opt: Option[Int]): Option[Int] = {
  num1Opt.flatMap { num1 =>
    num2Opt.flatMap { num2 =>
      num3Opt.map { num3 =>
        num1 + num2 + num3
      }
    }
  }
}
//TEST
sumOptionsFor(Some(1), Some(2), Some(3))
sumOptionsFor(Some(1), Some(2), None)
sumOptionsMap(Some(1), Some(2), Some(3))
/**
  5) Case Classes, Pattern Matching and Options *note, this is Week 4 content of Functional Programming
  */
case class Rule(name: String)
case class Outcome(result: String)
case class Ingestion(rule: Option[Rule], outcome: Option[Outcome])
case class Action(doThis: String)
def useRule(rule: Rule): List[Action] = {
  //DO NOT IMPLEMENT THIS FUNCTION, ONLY USE THIS FUNCTION IN interpretRow()
  print("use rule")
  ???
}
def useOutcome(rule: Outcome): List[Action] = {
  //DO NOT IMPLEMENT THIS FUNCTION, ONLY USE THIS FUNCTION IN interpretRow()
  print("use outcome")
  ???
}
def useBoth(rule: Rule, outcome: Outcome): List[Action] = {
  //DO NOT IMPLEMENT THIS FUNCTION, ONLY USE THIS FUNCTION IN interpretRow()
  print("use both")
  ???
}
//SOLUTIONS(S)
def interpretRow(row: Ingestion): List[Action] = {
  //Implement this function using pattern matching
  row match {
    case Ingestion(Some(rule),None)          => useRule(rule)
    case Ingestion(None, Some(outcome))      => useOutcome(outcome)
    case Ingestion(Some(rule),Some(outcome)) => useBoth(rule, outcome)
    case _ => List()
  }
}
