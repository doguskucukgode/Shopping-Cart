package com.trendyol.cart.shop

import com.trendyol.cart.model.product.Product
import com.trendyol.cart.model.shop.CartItem
import com.trendyol.cart.product.ProductBaseTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CartItemTest: ProductBaseTest() {


    private val QUANTITY1 = 50
    private val QUANTITY2 = 100
    private val QUANTITY3 = 200
    private val QUANTITY4 = 300
    private lateinit var product: Product
    private lateinit var cartItem: CartItem

    @BeforeEach
    fun setUp() {
        product = sampleProduct1()
        cartItem = CartItem(product = product)
    }

    @Test
    fun givenProductWithoutQuantityWhenGetQuantityThenAssertResult() {
        // Act
        val result = cartItem.quantity
        // Assert
        assertEquals(1, result)
    }

    @Test
    fun givenProductWithQuantity50WhenGetBestCampaignThenAssertResult() {
        // Arrange
        cartItem.quantity = QUANTITY1
        // Act
        val bestCampaign = cartItem.bestCampaign()
        // Assert
        assertNull(bestCampaign)
    }

    @Test
    fun givenProductWithQuantity100WhenGetBestCampaignThenAssertResult() {
        // Arrange
        cartItem.quantity = QUANTITY2
        // Act
        val bestCampaign = cartItem.bestCampaign()
        // Assert
        assertEquals(campaign1, bestCampaign)
    }

    @Test
    fun givenProductWithQuantity200WhenGetBestCampaignThenAssertResult() {
        // Arrange
        cartItem.quantity = QUANTITY3
        // Act
        val bestCampaign = cartItem.bestCampaign()
        // Assert
        assertEquals(campaign2, bestCampaign)
    }

    @Test
    fun givenProductWithQuantity300WhenGetBestCampaignThenAssertResult() {
        // Arrange
        cartItem.quantity = QUANTITY4
        category1.parentCategory = category2
        // Act
        val bestCampaign = cartItem.bestCampaign()
        // Assert
        assertEquals(campaign3, bestCampaign)
    }

    @Test
    fun givenProductWithQuantity100WhenTotalAmountThenAssertResult() {
        // Arrange
        cartItem.quantity = QUANTITY2
        // Act
        val result = cartItem.totalAmount()
        // Assert
        assertEquals(20000.0, result)
    }

    @Test
    fun givenProductWithQuantity100WhenTotalDiscountThenAssertResult() {
        // Arrange
        cartItem.quantity = QUANTITY2
        // Act
        val result = cartItem.totalDiscount()
        // Assert
        assertEquals(2000.0, result)
    }

    @Test
    fun givenProductWithQuantity200WhenTotalDiscountThenAssertResult() {
        // Arrange
        cartItem.quantity = QUANTITY3
        // Act
        val result = cartItem.totalDiscount()
        // Assert
        assertEquals(8000.0, result)
    }

    @Test
    fun givenProductWithQuantity300WhenTotalDiscountThenAssertResult() {
        // Arrange
        cartItem.quantity = QUANTITY4
        category1.parentCategory = category2
        // Act
        val result = cartItem.totalDiscount()
        // Assert
        assertEquals(15000.0, result)
    }

    @Test
    fun givenProductWithQuantity1WhenTotalDiscountThenAssertResult() {
        // Arrange And Act
        val result = cartItem.totalDiscount()
        // Assert
        assertEquals(0.0, result)
    }

    @Test
    fun givenProductWithQuantity100WhenToStringThenAssertResult() {
        // Arrange
        cartItem.quantity = QUANTITY2
        // Act
        val result = cartItem.toString()
        // Assert
        assertEquals("Product: Product1, Price: 200.0, Quantity: 100, Total Price: 20000.0, Total Discount: 2000.0 (%10), Total Price With Discount: 18000.0", result)
    }

    @Test
    fun givenProductWithQuantity200WhenToStringThenAssertResult() {
        // Arrange
        cartItem.quantity = QUANTITY3
        // Act
        val result = cartItem.toString()
        // Assert
        assertEquals("Product: Product1, Price: 200.0, Quantity: 200, Total Price: 40000.0, Total Discount: 8000.0 (%20), Total Price With Discount: 32000.0", result)
    }

    @Test
    fun givenProductWithQuantity300WhenToStringThenAssertResult() {
        // Arrange
        cartItem.quantity = QUANTITY4
        category1.parentCategory = category2
        // Act
        val result = cartItem.toString()
        // Assert
        assertEquals("Product: Product1, Price: 200.0, Quantity: 300, Total Price: 60000.0, Total Discount: 15000.0 (%25), Total Price With Discount: 45000.0", result)
    }
}
