package com.naj

case class Basket(items :List[String]) {

}
object Basket {
  def calculateCost(items :List[String]) = {
      val cost = items.foldLeft(0.0)((acc,next) => acc + itemCost(next.toLowerCase))
      s"£$cost"
  }
  def itemCost(item :String): Double = {
    case "apple" => .6
    case "orange" => .25
  }
}

