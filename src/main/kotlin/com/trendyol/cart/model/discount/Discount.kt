package com.trendyol.cart.model.discount

/**
 * @param discountPercentage Range 0-100 percentage of discount
 */
abstract class Discount(private val discountPercentage: Int) {

    /**
     * Calculating discount rate if it is applicable
     * @param value discount value can be quantity or amount
     */
    fun calculateDiscount(value: Number) :Double
            = if (isApplicable(value)) discountPercentage / 100.0 else 0.0

    /**
     * Determining for discount policy based on value
     * @param value discount value can be quantity or amount
     */
    abstract fun isApplicable(value: Number): Boolean
}