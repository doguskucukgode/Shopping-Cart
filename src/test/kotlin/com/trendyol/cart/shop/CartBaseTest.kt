package com.trendyol.cart.shop

import com.trendyol.cart.model.discount.Coupon
import com.trendyol.cart.model.shop.CartItem
import com.trendyol.cart.model.shop.DeliveryCost
import com.trendyol.cart.product.ProductBaseTest

open class CartBaseTest : ProductBaseTest() {

    private val DELIVERY_FEE = 1.0
    private val PRODUCT_ITEM_FEE = 0.5

    protected lateinit var coupon1: Coupon
    protected lateinit var coupon2: Coupon
    protected lateinit var coupon3: Coupon

    fun sampleCartItem1(quantity: Int = 1): CartItem {
        return CartItem(product = sampleProduct1(), quantity = quantity)
    }

    fun sampleCartItem2(quantity: Int = 1): CartItem {
        return CartItem(product = sampleProduct2(), quantity = quantity)
    }

    fun sampleCouponList() : List<Coupon> {
        coupon1 = Coupon(discountPercentage = 10, minCartValue = 2500.0)
        coupon2 = Coupon(discountPercentage = 15, minCartValue = 5000.0)
        coupon3 = Coupon(discountPercentage = 20, minCartValue = 7500.0)
        return listOf(coupon1, coupon2, coupon3)
    }

    fun sampleDeliveryCost(): DeliveryCost {
        return DeliveryCost(deliveryFee = DELIVERY_FEE, productItemFee = PRODUCT_ITEM_FEE)
    }
}