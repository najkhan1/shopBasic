package com.naj

import com.naj.Items.{apple, bannana, orange}
import com.typesafe.scalalogging._
import com.typesafe.scalalogging._



case class Basket(items :List[String])

case class Products(apples: Int, oranges :Int, bannana: Int){
  def addApple(): Products = this.copy(apples + 1,oranges)
  def addOrange(): Products = this.copy(apples,oranges + 1)
  def addBannana(): Products = this.copy(apples, oranges, bannana + 1)
}
object Basket  extends LazyLogging {

  /*
  Method to calculate cost of items it takes list of products, and boolean for offer on apples and oranges
   */
  def calculateCost(items :List[String],appleOffer :Boolean = false,orangeOffer :Boolean = false, bannaOffer :Boolean = false): String = {
    val products = items.foldLeft(Products(0,0,0))((acc,next) => next match {
      case value if value.toLowerCase == apple.toString => acc.addApple()
      case value if value.toLowerCase == orange.toString => acc.addOrange()
      case value if value.toLowerCase == bannana.toString => acc.addBannana()
      case otherValue =>
        logger.warn(s"item: $otherValue it not known")
        acc
    })
   val cost =  (appleOffer,orangeOffer,bannaOffer) match {
      case (true,true, true) => bannanaOffer(appleBuyOneGetOneFree(products.apples),products.bannana) + orangeThreeForTwo(products.oranges)
      case (true,false,true) => bannanaOffer(appleBuyOneGetOneFree(products.apples),products.bannana) + (products.oranges * orangePrice)
      case (false,true,true) => bannanaOffer((products.apples * applePrice),products.bannana) + orangeThreeForTwo(products.oranges)
      case (true,true,false) => bannanaOffer((products.apples * applePrice),products.bannana) + orangeThreeForTwo(products.oranges)
      case (false,false,false) => (products.apples * applePrice) + (products.oranges * orangePrice) + (0.2 * products.bannana)
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

  def bannanaOffer(appleCost :Double, numberOfBannans :Int) :Double = {
    val bannanaCost = numberOfBannans/2 * bannanaPrice + numberOfBannans % 2 * bannanaPrice
    if(bannanaCost >= appleCost) bannanaCost else appleCost
  }
  

  val applePrice = 0.6
  val orangePrice = 0.25
  val bannanaPrice = 0.2

}

object Items extends Enumeration{
  type fruit = Value
  val apple, orange, bannana = Value
}

