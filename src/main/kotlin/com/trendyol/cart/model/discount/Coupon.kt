package com.trendyol.cart.model.discount

/**
 * @param discountPercentage discount percentage for coupon
 * @param minCartValue minimum amount for coupon
 */
class Coupon(private val discountPercentage: Int, private val minCartValue: Double): Discount(discountPercentage) {

    /**
     * Checks if amount is greater than minimum product count
     * @param value quantity
     */
    override fun isApplicable(value: Number) = minCartValue <= value.toDouble()
}