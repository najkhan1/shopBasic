package com.naj

import org.slf4j.LoggerFactory

import com.typesafe.scalalogging._

case class Basket(items :List[String]) {

}
object Basket  extends LazyLogging {
  //val logger: Logger = Logger(LoggerFactory.getLogger(this.getClass))

  def calculateCost(items :List[String]): String = {
      val cost = items.map(x => itemCost(x.toLowerCase)).foldLeft(0.00)((acc,next) => next match {
        case Some(value) => acc + value
        case None => acc
      })
      s"£$cost"
  }
  def itemCost(item :String): Option[Double] =  item match {

    case "apple" => Some(0.6)
    case "orange" => Some(0.25)
    case value =>
      logger.warn(s"no price found for item: $value")
      None
  }

}

