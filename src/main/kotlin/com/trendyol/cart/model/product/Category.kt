package com.trendyol.cart.model.product

import com.trendyol.cart.model.discount.Campaign

data class Category (var title: String, val parentCategory: Category? = null, var campaigns: List<Campaign> = ArrayList())