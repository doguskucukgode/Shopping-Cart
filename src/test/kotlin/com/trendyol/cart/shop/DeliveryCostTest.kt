package com.trendyol.cart.shop

import com.trendyol.cart.model.shop.DeliveryCost
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DeliveryCostTest {

    private val PRODUCT_ITEM_FEE = 5.0
    private val DELIVERY_FEE = 10.0
    private lateinit var deliveryCost: DeliveryCost


    @BeforeEach
    fun setUp() {
        deliveryCost = DeliveryCost(DELIVERY_FEE, PRODUCT_ITEM_FEE)
    }

    @Test
    fun givenDeliveryCountAndProductItemCountWhen() {
        // Arrange
        val productItemCount = 30
        val deliveryCount = 50
        // Act
        val result = deliveryCost.deliveryPrice(productItemCount = productItemCount, deliveryCount = deliveryCount)
        // Assert
        assertEquals(650.0, result)

    }
}