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
    private lateinit var cart: Cart

    @BeforeEach
    fun setUp() {
        val cartItems =  listOf(sampleCartItem1(), sampleCartItem2())
        cart = Cart(cartItems = cartItems, coupons = sampleCouponList(), deliveryCost = sampleDeliveryCost())
    }

    @Test
    fun givenTotalDiscountedPrice1000WhenGetBestCouponThenAssertCoupon() {
        // Arrange And Act
        val bestCoupon = cart.bestCoupon(1000.0)
        // Assert
        assertNull(bestCoupon)
    }

    @Test
    fun givenTotalDiscountedPrice3000WhenGetBestCouponThenAssertCoupon() {
        // Arrange And Act
        val bestCoupon = cart.bestCoupon(3000.0)
        // Assert
        assertEquals(coupon1, bestCoupon)
    }

    @Test
    fun givenTotalDiscountedPrice6000WhenGetBestCouponThenAssertCoupon() {
        // Arrange And Act
        val bestCoupon = cart.bestCoupon(6000.0)
        // Assert
        assertEquals(coupon2, bestCoupon)
    }

    @Test
    fun givenTotalDiscountedPrice9000WhenGetBestCouponThenAssertCoupon() {
        // Arrange And Act
        val bestCoupon = cart.bestCoupon(9000.0)
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
        assertEquals(19800.0, result)
    }

    @Test
    fun givenCartItemsQuantity150WhenCalculateCartItemsThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM2_QUANTITY), sampleCartItem2(CART_ITEM2_QUANTITY))
        cart.cartItems = cartItems
        // Act
        val result = cart.calculateCartItems()
        // Assert
        assertEquals(33375.0, result)
    }

    @Test
    fun givenCartItemsQuantity250WhenCalculateCartItemsThenAssertResult() {
        // Arrange
        val cartItems =  listOf(sampleCartItem1(CART_ITEM3_QUANTITY), sampleCartItem2(CART_ITEM3_QUANTITY))
        cart.cartItems = cartItems
        // Act
        val result = cart.calculateCartItems()
        // Assert
        assertEquals(50625.0, result)
    }
}