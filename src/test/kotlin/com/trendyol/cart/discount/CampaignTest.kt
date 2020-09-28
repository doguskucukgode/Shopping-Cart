package com.trendyol.cart.discount

import com.trendyol.cart.model.discount.Campaign
import com.trendyol.cart.model.discount.Discount
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CampaignTest {

    private val DISCOUNT_PERCENTAGE = 30
    private val MIN_PRODUCT_COUNT = 50

    private lateinit var campaign: Discount

    @BeforeEach
    fun setUp() {
        campaign = Campaign(DISCOUNT_PERCENTAGE, MIN_PRODUCT_COUNT)
    }

    @Test
    fun givenMinChartValueBiggerWhenIsApplicableThenAssertTrue() {
        val result = campaign.isApplicable(MIN_PRODUCT_COUNT + 5)
        assertEquals(true, result)
    }

    @Test
    fun givenMinChartValueSmallerWhenIsApplicableThenAssertTrue() {
        val result = campaign.isApplicable(MIN_PRODUCT_COUNT - 5)
        assertEquals(false, result)
    }

    @Test
    fun givenMinChartValueBiggerWhenCalculateThenAssertResult() {
        val percentage = (DISCOUNT_PERCENTAGE/ 100.0).toDouble()
        val result = campaign.calculateDiscount(MIN_PRODUCT_COUNT + 5);
        assertEquals(percentage, result)
    }

    @Test
    fun givenMinChartValueSmallerWhenCalculateThenAssertResult() {
        val result = campaign.calculateDiscount(MIN_PRODUCT_COUNT - 5);
        assertEquals(0.0, result)
    }
}