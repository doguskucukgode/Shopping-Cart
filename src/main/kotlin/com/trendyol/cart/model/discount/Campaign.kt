package com.trendyol.cart.model.discount

/**
 * @param discountPercentage discount percentage for campaign
 * @param minProductCount minimum product count for campaign
 */
class Campaign(private val discountPercentage: Int, private val minProductCount: Int): Discount(discountPercentage) {

    /**
     * Checks if quantity is greater than minimum product count
     * @param value quantity
     */
    override fun isApplicable(value: Number) = minProductCount <= value.toInt()
}