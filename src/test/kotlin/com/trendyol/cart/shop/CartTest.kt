package com.trendyol.cart.shop

import com.trendyol.cart.model.shop.Cart
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull

class CartTest: CartBaseTest() {

    private val CART_ITEM1_QUANTITY = 80
    private val CART_ITEM2_QUANTITY = 150
    private val CART_ITEM3_QUANTITY = 250
    private val TOTAL_AMOUNT_WITH_QUANTITY1 = 19800.0
    private val TOTAL_AMOUNT_WITH_QUANTITY2 = 33375.0
    private val TOTAL_AMOUNT_WITH_QUANTITY3 = 50625.0
    private lateinit var cart: Cart

    @BeforeEach
    fun setUp() {
        val cartItems =  listOf(sampleCartItem1(), sampleCartItem2())
        cart = Cart(cartItems = cartItems, coupons = sampleCouponList(), deliveryCost = sampleDeliveryCost())
    }

    @Test
    fun givenTotalDiscountedPrice10000WhenGetBestCouponThenAssertCoupon() {
        // Arrange And Act
        val bestCoupon = cart.bestCoupon(10000.0)
        // Assert
        assertNull(bestCoupon)
    }

    @Test
    fun givenTotalDiscountedPrice20000WhenGetBestCouponThenAssertCoupon() {
        // Arrange And Act
        val bestCoupon = cart.bestCoupon(20000.0)
        // Assert
        assertEquals(coupon1, bestCoupon)
    }

    @Test
    fun givenTotalDiscountedPrice35000WhenGetBestCouponThenAssertCoupon() {
        // Arrange And Act
        val bestCoupon = cart.bestCoupon(35000.0)
        // Assert
        assertEquals(coupon2, bestCoupon)
    }

    @Test
    fun givenTotalDiscountedPrice80000WhenGetBestCouponThenAssertCoupon() {
        // Arrange And Act
        val bestCoupon = cart.bestCoupon(80000.0)
        // Assert
        assertEquals(coupon3, bestCoupon)
    }

    @Test
    fun givenCartItemsWhenCalculateCartItemsThenAssertResult() {
        // Arrange And Act
        val result = cart.calculateCartItems()
        // Assert
        assertEquals(250.0, result)
    }

    @Test
    fun givenCartItemsQuantity80WhenCalculateCartItemsThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM1_QUANTITY), sampleCartItem2(CART_ITEM1_QUANTITY))
        cart.cartItems = cartItems
        // Act
        val result = cart.calculateCartItems()
        // Assert
        assertEquals(TOTAL_AMOUNT_WITH_QUANTITY1, result)
    }

    @Test
    fun givenCartItemsQuantity150WhenCalculateCartItemsThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM2_QUANTITY), sampleCartItem2(CART_ITEM2_QUANTITY))
        cart.cartItems = cartItems
        // Act
        val result = cart.calculateCartItems()
        // Assert
        assertEquals(TOTAL_AMOUNT_WITH_QUANTITY2, result)
    }

    @Test
    fun givenCartItemsQuantity250WhenCalculateCartItemsThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM3_QUANTITY), sampleCartItem2(CART_ITEM3_QUANTITY))
        cart.cartItems = cartItems
        // Act
        val result = cart.calculateCartItems()
        // Assert
        assertEquals(TOTAL_AMOUNT_WITH_QUANTITY3, result)
    }

    @Test
    fun givenCartItemsWhenCouponDiscountThenAssertResult() {
        // Arrange And Act
        val result = cart.couponDiscount()
        // Assert
        assertEquals(0.0, result)
    }

    @Test
    fun givenCartItemsQuantity80WhenCouponDiscountThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM1_QUANTITY), sampleCartItem2(CART_ITEM1_QUANTITY))
        cart.cartItems = cartItems
        val expectedDiscount = TOTAL_AMOUNT_WITH_QUANTITY1 * 0.1
        // Act
        val result = cart.couponDiscount()
        // Assert
        assertEquals(expectedDiscount, result)
    }

    @Test
    fun givenCartItemsQuantity150WhenCouponDiscountThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM2_QUANTITY), sampleCartItem2(CART_ITEM2_QUANTITY))
        cart.cartItems = cartItems
        val expectedDiscount = TOTAL_AMOUNT_WITH_QUANTITY2 * 0.15
        // Act
        val result = cart.couponDiscount()
        // Assert
        assertEquals(expectedDiscount, result)
    }

    @Test
    fun givenCartItemsQuantity250WhenCouponDiscountThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM3_QUANTITY), sampleCartItem2(CART_ITEM3_QUANTITY))
        cart.cartItems = cartItems
        val expectedDiscount = TOTAL_AMOUNT_WITH_QUANTITY3 * 0.2
        // Act
        val result = cart.couponDiscount()
        // Assert
        assertEquals(expectedDiscount, result)
    }

    @Test
    fun givenCartItemsWhenDeliveryFeeThenAssertResult() {
        // Arrange And Act
        val result = cart.deliveryFee()
        // Assert
        assertEquals(3.0, result)
    }

    @Test
    fun givenCartItemsQuantity80WhenDeliveryFeeThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM1_QUANTITY), sampleCartItem2(CART_ITEM1_QUANTITY))
        cart.cartItems = cartItems
        // Act
        val result = cart.deliveryFee()
        // Assert
        assertEquals(82.0, result)
    }

    @Test
    fun givenCartItemsQuantity150WhenDeliveryFeeThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM2_QUANTITY), sampleCartItem2(CART_ITEM2_QUANTITY))
        cart.cartItems = cartItems
        // Act
        val result = cart.deliveryFee()
        // Assert
        assertEquals(152.0, result)
    }

    @Test
    fun givenCartItemsQuantity250WhenDeliveryFeeThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM3_QUANTITY), sampleCartItem2(CART_ITEM3_QUANTITY))
        cart.cartItems = cartItems
        // Act
        val result = cart.deliveryFee()
        // Assert
        assertEquals(252.0, result)
    }

    @Test
    fun givenCartItemsWhenToStringThenAssertResult() {
        // Arrange And Act
        val result = cart.toString()
        // Assert
        assertEquals("Product List:\n" +
                "Product: Product1, Price: 200.0, Quantity: 1, Total Price: 200.0, Total Discount: 0.0 (%0), Total Price With Discount: 200.0\n" +
                "Product: Product2, Price: 50.0, Quantity: 1, Total Price: 50.0, Total Discount: 0.0 (%0), Total Price With Discount: 50.0\n" +
                "Product List Price: 250.0\n" +
                "Coupon Discount: 0.0 (%0)\n" +
                "Delivery Fee: 3.0\n" +
                "Total Price: 253.0\n", result)
    }

    @Test
    fun givenCartItemsQuantity80WhenToStringThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM1_QUANTITY), sampleCartItem2(CART_ITEM1_QUANTITY))
        cart.cartItems = cartItems
        // Act
        val result = cart.toString()
        // Assert
        assertEquals("Product List:\n" +
                "Product: Product1, Price: 200.0, Quantity: 80, Total Price: 16000.0, Total Discount: 0.0 (%0), Total Price With Discount: 16000.0\n" +
                "Product: Product2, Price: 50.0, Quantity: 80, Total Price: 4000.0, Total Discount: 200.0 (%5), Total Price With Discount: 3800.0\n" +
                "Product List Price: $TOTAL_AMOUNT_WITH_QUANTITY1\n" +
                "Coupon Discount: 1980.0 (%10)\n" +
                "Delivery Fee: 82.0\n" +
                "Total Price: 17902.0\n", result)
    }
    @Test
    fun givenCartItemsQuantity150WhenToStringThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM2_QUANTITY), sampleCartItem2(CART_ITEM2_QUANTITY))
        cart.cartItems = cartItems
        // Act
        val result = cart.toString()
        // Assert
        assertEquals("Product List:\n" +
                "Product: Product1, Price: 200.0, Quantity: 150, Total Price: 30000.0, Total Discount: 3000.0 (%10), Total Price With Discount: 27000.0\n" +
                "Product: Product2, Price: 50.0, Quantity: 150, Total Price: 7500.0, Total Discount: 1125.0 (%15), Total Price With Discount: 6375.0\n" +
                "Product List Price: $TOTAL_AMOUNT_WITH_QUANTITY2\n" +
                "Coupon Discount: 5006.25 (%15)\n" +
                "Delivery Fee: 152.0\n" +
                "Total Price: 28520.75\n", result)
    }

    @Test
    fun givenCartItemsQuantity250WhenToStringThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM3_QUANTITY), sampleCartItem2(CART_ITEM3_QUANTITY))
        cart.cartItems = cartItems
        // Act
        val result = cart.toString()
        // Assert
        assertEquals("Product List:\n" +
                "Product: Product1, Price: 200.0, Quantity: 250, Total Price: 50000.0, Total Discount: 10000.0 (%20), Total Price With Discount: 40000.0\n" +
                "Product: Product2, Price: 50.0, Quantity: 250, Total Price: 12500.0, Total Discount: 1875.0 (%15), Total Price With Discount: 10625.0\n" +
                "Product List Price: $TOTAL_AMOUNT_WITH_QUANTITY3\n" +
                "Coupon Discount: 10125.0 (%20)\n" +
                "Delivery Fee: 252.0\n" +
                "Total Price: 40752.0\n", result)
    }
}