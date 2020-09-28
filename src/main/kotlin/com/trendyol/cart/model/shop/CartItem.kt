package com.trendyol.cart.model.shop

import com.trendyol.cart.model.discount.Campaign
import com.trendyol.cart.model.product.Product

/**
 * Product with quantity in cart
 * @param product product to be purchased
 * @param quantity Product count
 */
class CartItem(private val product: Product, var quantity: Int = 1) {

    /**
     * Calculates most discount rate of all campaigns corresponding to the product
     */
    fun bestCampaign(): Campaign? = product.getAllCampaigns()
            .stream()
            .filter{ c -> c.isApplicable(quantity) }
            // Descending sort
            .sorted { o1, o2 ->
                o2.calculateDiscount(quantity)
                        .compareTo(o1.calculateDiscount(quantity))
            }
            .findFirst()
            .orElse(null)

    /**
     * Calculates total amount of chart item
     */
    fun totalAmount() = product.price * quantity

    /**
     * Calculates total discount of chart item
     */
    fun totalDiscount(): Double {
        val bestCampaign : Campaign? = bestCampaign()
        if (bestCampaign != null) {
            return totalAmount() * bestCampaign.calculateDiscount(quantity)
        }
        return 0.0
    }

    /**
     * Printing Chart Item
     */
    override fun toString(): String {
        val totalAmount =  totalAmount()
        val totalDiscount =  totalDiscount()
        val percentage = (100 * totalDiscount / totalAmount).toInt()
        val totalPrice =  totalAmount - totalDiscount

        return "Product: " + product.title +
                ", Price: " + product.price +
                ", Quantity: " + quantity +
                ", Total Price: $totalAmount" +
                ", Total Discount: $totalDiscount (%$percentage)" +
                ", Total Price With Discount: $totalPrice"
    }
}