package com.trendyol.cart.product

import com.trendyol.cart.model.discount.Campaign
import com.trendyol.cart.model.product.Category
import com.trendyol.cart.model.product.Product

open class ProductBaseTest {

    private val CATEGORY_NAME1 = "Category1"
    private val CATEGORY_NAME2 = "Category2"
    private val CATEGORY_NAME3 = "Category3"
    private val CATEGORY_NAME4 = "Category4"
    private val PRODUCT_PRICE1 = 200.0
    private val PRODUCT_PRICE2 = 50.0
    protected val PRODUCT_NAME1 = "Product1"
    protected val PRODUCT_NAME2 = "Product2"

    // Categories
    protected lateinit var category1: Category
    protected lateinit var category2: Category
    protected lateinit var category3: Category
    protected lateinit var category4: Category
    // Campaigns
    protected lateinit var campaign1: Campaign
    protected lateinit var campaign2: Campaign
    protected lateinit var campaign3: Campaign
    protected lateinit var campaign4: Campaign
    protected lateinit var campaign5: Campaign
    protected lateinit var campaign6: Campaign

    fun sampleProduct1(): Product {
        category1 = Category(title = CATEGORY_NAME1)
        category2 = Category(title = CATEGORY_NAME2)
        campaign1 = Campaign(10, 100)
        campaign2 = Campaign(20, 200)
        campaign3 = Campaign(25, 200)
        category1.campaigns = listOf(campaign1, campaign2)
        category2.campaigns = listOf(campaign3)
        return Product(title = PRODUCT_NAME1, category = category1, price = PRODUCT_PRICE1)
    }

    fun sampleProduct2(): Product {
        category3 = Category(title = CATEGORY_NAME3)
        category4 = Category(title = CATEGORY_NAME4)
        campaign4 = Campaign(5, 40)
        campaign5 = Campaign(10, 90)
        campaign6 = Campaign(15, 130)
        category3.campaigns = listOf(campaign4, campaign5)
        category4.campaigns = listOf(campaign6)
        category3.parentCategory =category4
        return Product(title = PRODUCT_NAME2, category = category3, price = PRODUCT_PRICE2)
    }
}
