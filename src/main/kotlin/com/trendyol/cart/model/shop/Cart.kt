package com.trendyol.cart.model.shop

import com.trendyol.cart.model.discount.Discount
import java.util.stream.Collectors

/**
 * @param cartItems
 * @param coupons
 * @param deliveryCost
 */
class Cart(var cartItems: List<CartItem> = ArrayList(), var coupons: List<Discount> = ArrayList(), private val deliveryCost: DeliveryCost) {

    /**
     * Calculates all carts with campaign discounts without coupon discount
     */
    private fun calculateCartItems() = cartItems.stream()
            .mapToDouble { i -> i.totalAmount() - i.totalDiscount() }
            .sum()

    /**
     * Calculates most discount rate of all coupons corresponding to the cart amount
     */
    private fun bestCoupon(totalDiscountedPrice: Double): Discount? =
        coupons.stream()
                // Descending sort
                .sorted { o1, o2 ->
                    o2.calculateDiscount(totalDiscountedPrice)
                            .compareTo(o1.calculateDiscount(totalDiscountedPrice))
                }
                .findFirst()
                .get()

    /**
     * Calculates coupon discount
     */
    private fun couponDiscount(): Double {
        val cartItemsPrice = calculateCartItems()
        val bestCoupon : Discount? = bestCoupon(cartItemsPrice)
        if (bestCoupon != null) {
            return cartItemsPrice * bestCoupon.calculateDiscount(cartItemsPrice)
        }
        return 0.0
    }

    /**
     * Printing Cart
     */
    override fun toString(): String {
        val productList = cartItems.stream()
                .map { p -> p.toString() }
                .collect(Collectors.joining("\n"))
        val totalProductListPrice = calculateCartItems()
        val couponDiscount = couponDiscount()
        val couponPercentage = (100 * couponDiscount / totalProductListPrice).toInt()
        val deliveryFee = deliveryFee()
        val total = totalProductListPrice - couponDiscount + deliveryFee
        return "Product List:\n$productList\n" +
                "Product List Price: $totalProductListPrice\n" +
                "Coupon Discount: $couponDiscount (%$couponPercentage)\n" +
                "Delivery Fee: $deliveryFee\n" +
                "Total Price: $total\n"
    }

    /**
     * Calculates delivery fee with respect to chart item count and product count
     */
    private fun deliveryFee(): Double {
        return deliveryCost.deliveryPrice(deliveryCount = cartItems.size, productItemCount = cartItems
                .stream()
                .mapToInt{c -> c.quantity}
                .sum()
        )
    }
}
