# Microservices-Ecomm

The project consists of 3 microservices developed in JAVA (springboot), namely:
* Product-Service
* Inventory-Service
* Order-Service

Product-Service:
  * Service for CRUD operations on products depending on its skuCode
  * uses mongoDB for storing information
 
Inventory-Service:
  * Service for keeping and tracking inventory, mainly used to check if item required are in stock!
  * Used by order-service
  * Uses mysql for inventory data storage
  
Order-Service:
  * Service used by customer to order a product.
  * Calls inventory-service to confirm if items required are available and enough quantity is in inventory
  * places the order {dummy}

Eureka-Server:
  * Used for microservices discovery, Load Balancing and communication.
 
![image](https://user-images.githubusercontent.com/43819432/210184087-e2d916d9-c37a-44e7-b4bd-7042bca663fa.png)
