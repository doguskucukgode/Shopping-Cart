package com.trendyol.cart.model.shop

class DeliveryCost(private val deliveryFee: Double, private val productItemFee: Double){

    fun deliveryPrice(deliveryCount: Int, productItem: Int) =
            (deliveryFee * deliveryCount) + (productItemFee * productItem)
}