package com.trendyol.cart.model.shop

import com.trendyol.cart.model.discount.Discount
import java.util.stream.Collectors

class Cart(var cartItems: List<CartItem> = ArrayList(), var coupons: List<Discount> = ArrayList(),val deliveryCost: DeliveryCost) {

    private fun calculateCartItems() = cartItems.stream()
            .mapToDouble { i -> i.totalAmount() - i.totalDiscount() }
            .sum()

    private fun bestCoupon(totalDiscountedPrice: Double): Discount? =
        coupons.stream()
                // Descending sort
                .sorted { o1, o2 ->
                    o2.calculateDiscount(totalDiscountedPrice)
                            .compareTo(o1.calculateDiscount(totalDiscountedPrice))
                }
                .findFirst()
                .get()

    private fun couponDiscount(): Double {
        val cartItemsPrice = calculateCartItems()
        val bestCoupon : Discount? = bestCoupon(cartItemsPrice)
        if (bestCoupon != null) {
            return cartItemsPrice * bestCoupon.calculateDiscount(cartItemsPrice)
        }
        return 0.0
    }

    override fun toString(): String {
        val productList = cartItems.stream()
                .map { p -> p.toString() }
                .collect(Collectors.joining("\n"))
        val totalProductListPrice = calculateCartItems()
        val couponDiscount = couponDiscount()
        val deliveryFee = deliveryFee()
        val total = totalProductListPrice - couponDiscount + deliveryFee
        return "Product List:\n$productList\n" +
                "Product List Price: $totalProductListPrice\n" +
                "Coupon Discount: $couponDiscount\n" +
                "Delivery Fee: $deliveryFee\n" +
                "Total Price: $total\n"
    }

    private fun deliveryFee(): Double {
        return deliveryCost.deliveryPrice(deliveryCount = cartItems.size, productItem = cartItems
                .stream()
                .mapToInt{c -> c.quantity}
                .sum()
        )
    }
}
