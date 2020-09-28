package com.trendyol.cart.product

import com.trendyol.cart.model.product.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class ProductTest : ProductBaseTest() {

    private lateinit var product: Product

    @BeforeEach
    fun setUp() {
        product = sampleProduct1()
    }

    @Test
    fun givenCategoryWithoutParentWhenGetCampaignsThenAssertResult() {
        // Arrange And Act
        val result = product.getAllCampaigns()
        // Assert
        assertAll(PRODUCT_NAME,
                { assertEquals(2, result.size) },
                { assertEquals(campaign1, result[0])})
    }

    @Test
    fun givenCategoryWithParentWhenGetCampaignsThenAssertResult() {
        // Arrange
        category1.parentCategory = category2
        // Act
        val result = product.getAllCampaigns()
        // Assert
        assertAll(PRODUCT_NAME,
                { assertEquals(3, result.size) },
                { assertEquals(campaign3, result[2])})
    }

}