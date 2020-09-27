package com.trendyol.cart.model.shop

import com.trendyol.cart.model.discount.Campaign
import com.trendyol.cart.model.product.Product

class CartItem(private val product: Product, val quantity: Int) {

    private fun bestCampaign(): Campaign? = product.getAllCampaigns()
            .stream()
            // Descending sort
            .sorted { o1, o2 ->
                o2.calculateDiscount(quantity)
                        .compareTo(o1.calculateDiscount(quantity))
            }
            .findFirst()
            .get()

    fun totalAmount() = product.price * quantity

    fun totalDiscount(): Double {
        val bestCampaign : Campaign? = bestCampaign()
        if (bestCampaign != null) {
            return totalAmount() * bestCampaign.calculateDiscount(quantity)
        }
        return 0.0
    }

    override fun toString(): String {
        val totalAmount =  totalAmount()
        val totalDiscount =  totalDiscount()
        val totalPrice =  totalAmount - totalDiscount

        return "Product: " + product.title +
                ", Quantity: " + quantity +
                ", Total Price: " + totalAmount +
                ", Total Discount: " + totalDiscount +
                ", Total Price With Discount: " + totalPrice
    }
}