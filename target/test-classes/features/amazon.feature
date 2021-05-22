Feature: Amazon product search

@RegTest
Scenario: Search the product and add to cart
Given Land of the Amazon website
When search for the product "mouse"
Then click on the "keyword" to add it to cart and click on the cart icon and verify the product name

@SmokeTest
Scenario Outline: Search the product and add to cart
Given Land of the Amazon website
When search for the product <category> field
Then click on the <name> to add it to cart and click on the cart icon and verify the product names

Examples:
|category	|name	|
|mouse	    |AmazonBasics Ergonomic Wireless	|
|keyboard	|Amkette Xcite Pro USB Keyboard (Black)	|
