package com.trendyol.cart.product

import com.trendyol.cart.model.discount.Campaign
import com.trendyol.cart.model.product.Category
import com.trendyol.cart.model.product.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class ProductTest {

    private val CATEGORY_NAME1 = "Category1"
    private val CATEGORY_NAME2 = "Category2"
    private val PRODUCT_NAME = "Product"
    private val PRODUCT_PRICE = 200.0

    private lateinit var product: Product
    private lateinit var category1: Category
    private lateinit var category2: Category
    private lateinit var campaign1: Campaign
    private lateinit var campaign2: Campaign
    private lateinit var campaign3: Campaign


    @BeforeEach
    fun setUp() {
        category1 = Category(title = CATEGORY_NAME1)
        category2 = Category(title = CATEGORY_NAME2)
        campaign1 = Campaign(10, 100)
        campaign2 = Campaign(20, 200)
        campaign3 = Campaign(25, 200)
        category1.campaigns = listOf(campaign1, campaign2)
        category2.campaigns = listOf(campaign3)
        product = Product(title = PRODUCT_NAME, category = category1, price = PRODUCT_PRICE)
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