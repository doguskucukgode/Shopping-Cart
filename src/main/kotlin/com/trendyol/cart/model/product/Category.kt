package com.trendyol.cart.model.product

import com.trendyol.cart.model.discount.Campaign

/**
 *
 * @param title category name
 * @param parentCategory upper category
 * @param campaigns List of campaigns for category
 */
data class Category (var title: String, val parentCategory: Category? = null, var campaigns: List<Campaign> = ArrayList())