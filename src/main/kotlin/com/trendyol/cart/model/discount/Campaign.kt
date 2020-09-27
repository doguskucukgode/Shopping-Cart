package com.trendyol.cart.model.discount

class Campaign(private val discountPercentage: Int, private val minProductCount: Int): Discount(discountPercentage) {

    /**
     *
     */
    override fun isApplicable(value: Number) = minProductCount <= value.toInt()
}