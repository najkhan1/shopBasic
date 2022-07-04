package com.naj

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class BasketSpec extends AnyFunSpec{

  describe("Test Basket"){
    import com.naj.Basket._
    val methodUnderTest = (itemList :List[String]) =>  calculateCost(itemList)

    it("Should return added cost of all items"){
      val items = List("Apple","Orange","Apple","Apple","Apple")
      val expected = methodUnderTest(items)
      val actual = "£2.65"
      actual shouldEqual expected

    }

    it("Should return added cost of all items and ignore and log unrecognized items"){
      val items = List("Apple","Orange","Apple","Apple","Apple","bannana")
      val expected = methodUnderTest(items)
      val actual = "£2.65"
      actual shouldEqual expected

    }
  }

}
