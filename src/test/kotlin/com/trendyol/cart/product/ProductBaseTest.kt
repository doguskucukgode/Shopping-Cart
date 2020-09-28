package com.trendyol.cart.product

import com.trendyol.cart.model.discount.Campaign
import com.trendyol.cart.model.product.Category
import com.trendyol.cart.model.product.Product

open class ProductBaseTest {

    private val CATEGORY_NAME1 = "Category1"
    private val CATEGORY_NAME2 = "Category2"
    private val PRODUCT_PRICE = 200.0
    protected val PRODUCT_NAME = "Product"

    protected lateinit var category1: Category
    protected lateinit var category2: Category
    protected lateinit var campaign1: Campaign
    protected lateinit var campaign2: Campaign
    protected lateinit var campaign3: Campaign

    fun sampleProduct1(): Product {
        category1 = Category(title = CATEGORY_NAME1)
        category2 = Category(title = CATEGORY_NAME2)
        campaign1 = Campaign(10, 100)
        campaign2 = Campaign(20, 200)
        campaign3 = Campaign(25, 200)
        category1.campaigns = listOf(campaign1, campaign2)
        category2.campaigns = listOf(campaign3)
        return Product(title = PRODUCT_NAME, category = category1, price = PRODUCT_PRICE)
    }
}
