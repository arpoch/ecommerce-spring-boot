# Ecommerce Spring Boot

## Overview
This project includes three micro-services
- Catalog Microservice: It handles the catalog operations
- Cart Microservice: It handles the cart operations
- Eureka Microservice: It handles Client discovery

The database used in this project is MS-SQL server

## Features
- Catalog microservice:
  - It lists all the item avaliable to purchase
  - Update the item quantity to purchase
- Cart microservice:
  - Add the selected item to cart
  - Remove the item from cart
- MS-SQL server database acts as the repository
- Postman is used for API testing
- The whole project is containerised using docker

## Getting Started
- Create Jar's for all the micro-services
- The Docker compose file is started with ```dokcer compose up```
- The project will start locally on ports
  - Catalog Microservice: 8085
  - Cart Microservice: 8080
  - MS-SQL Server: 1400
- Enpoints for
  - Catalog Micrservice:
    - context-path=/catalog
      - `show-item`
      - `add-item/{item-code}`
      - `update-quantity/{item-code}/{quantity}`
  - Cart Microservice:
    - context-path=/cart
      - `show-items`
      - `show-items/{item-code}`


