# Shopping-Cart
E-Comerce shopping card delivery cost calculator. This is a SpringBoot Kotlin Project which has a CommandLineRunner component. It calculates sample input in Shopping class and prints Cart Value. Project can be run with gradle or docker with choice.

## Running with gradle
`gradle clean build bootRun`
## Running with docker
`docker-compose up`

### Sample Output
```
Product List:
Product: apple, Price: 5.0, Quantity: 10, Total Price: 50.0, Total Discount: 10.0 (%20), Total Price With Discount: 40.0
Product: pepper, Price: 3.0, Quantity: 20, Total Price: 60.0, Total Discount: 12.0 (%20), Total Price With Discount: 48.0
Product List Price: 88.0
Coupon Discount: 0.0 (%0)
Delivery Fee: 12.2
Total Price: 100.2

Product List:
Product: apple, Price: 5.0, Quantity: 50, Total Price: 250.0, Total Discount: 75.0 (%30), Total Price With Discount: 175.0
Product: pepper, Price: 3.0, Quantity: 40, Total Price: 120.0, Total Discount: 24.0 (%20), Total Price With Discount: 96.0
Product List Price: 271.0
Coupon Discount: 40.65 (%15)
Delivery Fee: 54.4
Total Price: 284.75

```
