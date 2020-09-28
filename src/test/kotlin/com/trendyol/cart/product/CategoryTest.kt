package com.trendyol.cart.product

import com.trendyol.cart.model.product.Category
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CategoryTest {

    private val CATEGORY_NAME = "Category"

    private lateinit var category: Category

    @BeforeEach
    fun setUp() {
        category = Category(title = CATEGORY_NAME)
    }

    @Test
    fun givenCategoryWhenGetCampaignsThenAssertResult() {
        // Arrange And Act
        val result = category.campaigns
        // Assert
        Assertions.assertEquals(0, result.size)
    }
}