package com.trendyol.cart.model.product

import com.trendyol.cart.model.discount.Campaign

data class Product (val title: String, val price: Double, private val category: Category){

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
