package com.trendyol.cart.model.main

import com.trendyol.cart.model.discount.Campaign
import com.trendyol.cart.model.discount.Coupon
import com.trendyol.cart.model.product.Category
import com.trendyol.cart.model.product.Product
import com.trendyol.cart.model.shop.Cart
import com.trendyol.cart.model.shop.CartItem
import com.trendyol.cart.model.shop.DeliveryCost
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.ExitCodeGenerator
import org.springframework.boot.SpringApplication
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component

@Component
class Shopping : CommandLineRunner {

    @Autowired
    private val appContext: ApplicationContext? = null

    override fun run(vararg args: String?) {
        main(args);
    }

    fun main(args: Array<out String?>) {
        // Define campaigns
        val foodCampaign1 = Campaign(20, 10)
        val foodCampaign2 = Campaign(30, 50)
        val fruitCampaign1 = Campaign(5, 5)
        val fruitCampaign2 = Campaign(40, 100)
        val vegetableCampaign = Campaign(5, 2)

        // Define Coupons
        val coupon1 = Coupon(10, 200.0);
        val coupon2 = Coupon(15, 250.0);

        // Define DeliveryCost
        val delivery1 = DeliveryCost(deliveryFee = 0.1, productItemFee = 0.4)
        val delivery2 = DeliveryCost(deliveryFee = 0.2, productItemFee = 0.6)

        // Define categories
        val foodCategory = Category(title = "food", campaigns = listOf(foodCampaign1, foodCampaign2))
        val fruitCategory = Category(title = "fruit", parentCategory = foodCategory, campaigns = listOf(fruitCampaign1, fruitCampaign2))
        val vegetableCategory = Category(title = "vegetable", parentCategory = foodCategory, campaigns = listOf(vegetableCampaign))

        // Define products
        val apple = Product("apple", 5.0, fruitCategory)
        val pepper = Product("pepper", 3.0, vegetableCategory)

        // Define Cart Items
        val appleCartItem1 = CartItem(apple, 10);
        val pepperCartItem1 = CartItem(pepper, 20);
        val appleCartItem2 = CartItem(apple, 50);
        val pepperCartItem2 = CartItem(pepper, 40);

        // Define Carts
        val cart1 = Cart(listOf(appleCartItem1, pepperCartItem1), listOf(coupon1, coupon2), delivery1)
        val cart2 = Cart(listOf(appleCartItem2, pepperCartItem2), listOf(coupon1, coupon2), delivery2)

        println(cart1)
        println(cart2)

        SpringApplication.exit(appContext, ExitCodeGenerator { 0 })
    }
}