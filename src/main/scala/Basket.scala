package com.naj

import com.naj.Items.{apple, orange}
import com.typesafe.scalalogging._
import com.typesafe.scalalogging._



case class Basket(items :List[String])

case class Products(apples: Int,oranges :Int){
  def addApple(): Products = this.copy(apples + 1,oranges)
  def addOrange(): Products = this.copy(apples,oranges + 1)
}
object Basket  extends LazyLogging {

  /*
  Method to calculate cost of items it takes list of products, and boolean for offer on apples and oranges
   */
  def calculateCost(items :List[String],appleOffer :Boolean = false,orangeOffer :Boolean = false): String = {
    val products = items.foldLeft(Products(0,0))((acc,next) => next match {
      case value if value.toLowerCase == apple.toString => acc.addApple()
      case value if value.toLowerCase == orange.toString => acc.addOrange()
      case otherValue =>
        logger.warn(s"item: $otherValue it not known")
        acc
    })
   val cost =  (appleOffer,orangeOffer) match {
      case (true,true) => appleBuyOneGetOneFree(products.apples) + orangeThreeForTwo(products.oranges)
      case (true,false) => appleBuyOneGetOneFree(products.apples) + (products.oranges * orangePrice)
      case (false,true) => (products.apples * applePrice) + orangeThreeForTwo(products.oranges)
      case (false,false) => (products.apples * applePrice) + (products.oranges * orangePrice)
    }
    val total = s"£${BigDecimal(cost).setScale(2)}"

    logger.warn(total)
    total
  }

  def appleBuyOneGetOneFree(numberOfItems :Int): Double = numberOfItems/2 * applePrice + numberOfItems % 2 * applePrice
  def orangeThreeForTwo(numberOfItems :Int): Double = {
    val offers = numberOfItems / 3
    (numberOfItems - offers) * orangePrice
  }

  val applePrice = 0.6
  val orangePrice = 0.25

}

object Items extends Enumeration{
  type fruit = Value
  val apple, orange = Value
}

