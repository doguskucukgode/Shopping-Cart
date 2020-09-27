package com.trendyol.cart.model.product

import com.trendyol.cart.model.discount.Campaign

/**
 *
 * @param title product name
 * @param price product price for one
 * @param category product to be based on
 */
data class Product (val title: String, val price: Double, private val category: Category){

    /**
     * Getting all campaigns with also upper categories
     */
    fun getAllCampaigns(): List<Campaign> {
        val campaigns: MutableList<Campaign> = ArrayList()
        var currentCategory: Category? = category;
        while(currentCategory != null) {
            campaigns.addAll(currentCategory.campaigns)
            currentCategory = currentCategory.parentCategory
        }
        return campaigns
    }
}
