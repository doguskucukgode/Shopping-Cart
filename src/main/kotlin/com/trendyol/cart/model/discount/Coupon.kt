package com.trendyol.cart.model.discount

class Coupon(private val discountPercentage: Int, private val minCartValue: Double): Discount(discountPercentage) {

    override fun isApplicable(value: Number) = minCartValue <= value.toDouble()
}