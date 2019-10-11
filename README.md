# Spring_Postgres_API Project
Example of Springboot API connecting to Postgres DB

* [Local Setup](#local-setup)
* [API Endpoints](#api-endpoints)
* [MVP1 Features](#mvp1-features)
* [MVP2 Backlog Features](#mvp2-backlog-features)

## Local Setup 

These steps enable you to run the app locally within your IDE.  In MVP#2 i will provide a docker container and steps to run locally outside of the IDE.
* IDE and Postgres Setup:

* Step 1:
    * Setup a local or hosted Postgres Server
    * Use the Postgres configurations in the Application Properties for database name and credentials
    * Run the DDL scripts in the Models Customer and Cart files
    
* Step 2:
    * This is a Maven based Spring boot application so you can enter these commands in the project directory:
    * --> mvn --version //Check your maven version, if not present install it
    * --> mvn clean package //Compile the application code, run the test, and package it as determined by your pom.xml
    * --> mvn spring-boot:run . //start up the service.  Ctl-C to stop the service
    * OR
          * Import to your favorite IDE - IntelliJ and run from there if you choose.
    
    * Run the application listening on port http://localhost:8080/ set in the Application properties
    * Check the Health Endpoint status should be 'UP' http://localhost:8080/actuator/health


## API Endpoints


* GET a Customer Information and Hometown Weather: http://localhost:8080/findCust?id=#

{
    "Id": 16,
    "Firstname": "Lucky",
    "Lastname": "Customer",
    "Hometown": "Minneapolis",
    "Weather": [
        {
            "main": "Clouds",
            "description": "overcast clouds"
        }
    ],
    "Main": {
        "temp": 39.09,
        "pressure": 1007,
        "humidity": 60,
        "temp_min": 37.4,
        "temp_max": 41
    }
}

* GET a Cart for a Customer: http://localhost:8080/findCart?id=#&custid=#

{
    "Id": 11,
    "custId": 16,
    "Item": "Lucky Test 500",
    "Item Description": "Very Lucky Toy 500",
    "Retail": 500.50,
    "Cart Number": 3
}

* GET all the Carts for a Customer: 

{
    "Id": 6,
    "Firstname": "Lucky",
    "Lastname": "Six",
    "carts": [
        {
            "Id": 1,
            "custId": 6,
            "Item": "Big Cat Bulldozer",
            "Item Description": "Toy Bulldozer",
            "Retail": 10.25,
            "Cart Number": 1
        },
        {
            "Id": 2,
            "custId": 6,
            "Item": "Pokemon Big Pack",
            "Item Description": "Pokemon Pack",
            "Retail": 9.99,
            "Cart Number": 1
        }
    ]
}

* GET a Cart: 

* GET a Cart: 

* GET a Cart: 

* GET a Cart: 


## MVP1 Features

    * Create a Retail API for a Customer and their Cart details
    * Enable basic CRUD + Get functions to the Customer and Cart Postgres entities
    * Enable an external API call to return current weather conditions based on Customers hometown 
    * Create a custom mapper object for DTO/Model, and enable Mapstruct's mapper library
    * Create Health Endpoint
    * Add Unit Tests / Test Suite


## MVP2 Backlog Features

    * Create a Docker Image of the API, and run it on a Docker Container, connecting to Postgres localhost
    * Beef up unit test coverage from 60% of lines covered to 90%
    * Add endpoint for filtering by Cust Id and Cart Number (http://localhost:8080/findCart?id=11&custid=16)
    * Add Delete by Cart Number endpoint
    * Clean up the code to have better naming, camelCase, and add java Docs
    * Add Metrics 
    * Add Logger/Logback out to file or Elastic
    * Add Custom Error Handling in Event Controller 
    


