
import Basket.{bannanaOffer, calculateCost}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class BasketSpec extends AnyFunSpec{

  describe("Test Basket") {

    val methodUnderTest = (itemList :List[String],appleOffer :Boolean, orangeOffer :Boolean, bananaOffer :Boolean) =>
      calculateCost(itemList,appleOffer, orangeOffer, bananaOffer)

    it("Should return added cost of all items"){
      val items = List("Apple","Orange","Apple","Apple","Apple")
      val expected = methodUnderTest(items,false,false,false)
      println(expected)
      val actual = "£2.65"
      actual shouldEqual expected

    }
    it("Should return added cost of all items with apple offer"){
      val items = List("Apple","Orange","Apple","Apple","Apple")
      val expected = methodUnderTest(items,true,false,false)
      println(expected)
      val actual = "£1.45"
      actual shouldEqual expected

    }
    it("Should return added cost of all items with apple offer odd apples"){
      val items = List("Apple","Orange","Apple","Apple","Apple", "Apple")
      val expected = methodUnderTest(items,true,false,false)
      println(expected)
      val actual = "£2.05"
      actual shouldEqual expected

    }

    it("Should return added cost of all items with apple and orange offer"){
      val items = List("Apple","Orange","Apple","Apple","Apple", "Apple", "Orange","Orange")
      val expected = methodUnderTest(items,true,true,true)
      println(expected)
      val actual = "£2.30"
      actual shouldEqual expected

    }

    it("Should return added cost of all items with apple and orange offer with oranges not bieng multiple of 3"){
      val items = List("Apple","Orange","Apple","Apple","Apple", "Apple", "Orange","Orange","Orange")
      val expected = methodUnderTest(items,true,true,false)
      println(expected)
      val actual = "£3.75"
      actual shouldEqual expected

    }

    it("Should return added cost of all items and ignore and log unrecognized items"){
      val items = List("Apple","Orange","Apple","Apple","Apple","banana")
      val expected = methodUnderTest(items,false,false,true)
      println(expected)
      val actual = "£1.45"
      actual shouldEqual expected

    }
  }

}
