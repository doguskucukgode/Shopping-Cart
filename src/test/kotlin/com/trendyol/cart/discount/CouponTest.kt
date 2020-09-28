package com.trendyol.cart.discount

import org.junit.jupiter.api.Assertions.assertEquals
import com.trendyol.cart.model.discount.Coupon
import com.trendyol.cart.model.discount.Discount
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

class CouponTest {

    private val DISCOUNT_PERCENTAGE = 20
    private val MIN_CART_VALUE = 100.0

    private lateinit var coupon: Discount

    @BeforeEach
    fun setUp() {
        coupon = Coupon(DISCOUNT_PERCENTAGE, MIN_CART_VALUE)
    }

    @Test
    fun givenMinChartValueBiggerWhenIsApplicableThenAssertTrue() {
        val result = coupon.isApplicable(MIN_CART_VALUE + 50)
        assertEquals(true, result)
    }

    @Test
    fun givenMinChartValueSmallerWhenIsApplicableThenAssertTrue() {
        val result = coupon.isApplicable(MIN_CART_VALUE - 50)
        assertEquals(false, result)
    }

    @Test
    fun givenMinChartValueBiggerWhenCalculateThenAssertResult() {
        val percentage = (DISCOUNT_PERCENTAGE/ 100.0).toDouble()
        val result = coupon.calculateDiscount(MIN_CART_VALUE + 50);
        assertEquals(percentage, result)
    }

    @Test
    fun givenMinChartValueSmallerWhenCalculateThenAssertResult() {
        val result = coupon.calculateDiscount(MIN_CART_VALUE - 50);
        assertEquals(0.0, result)
    }
}