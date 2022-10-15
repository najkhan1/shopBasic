import Basket.calculateCost

object Main {
  def main(args: Array[String]): Unit = {
    val items = List("Apple","Orange","Apple","Apple","Apple", "Apple", "Orange","Orange","Orange")
    // with no offer
    calculateCost(items)
    // with apple and orange offer
    calculateCost(items,appleOffer = true,orangeOffer = true)
  }
}