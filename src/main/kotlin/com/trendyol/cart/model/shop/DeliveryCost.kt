package com.trendyol.cart.model.shop

/**
 * Calculates delivery cost
 * @param deliveryFee Delivery fee for single chart item
 * @param productItemFee Product fee for sing product item
 */
class DeliveryCost(private val deliveryFee: Double, private val productItemFee: Double){

    /**
     * Calculates delivery cost with respect to delivery item count and product item count
     * @param deliveryCount Delivery Count
     * @param productItemCount Product Item Count
     */
    fun deliveryPrice(deliveryCount: Int, productItemCount: Int) =
            (deliveryFee * deliveryCount) + (productItemFee * productItemCount)
}