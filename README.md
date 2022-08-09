# net-price-calculator

## Description
This SpringBoot application provides an API/service which allows consumers to calculate the net price from a gross price for a given country for standard taxable goods.

To formulate, 
Gross price = Net price + Tax

Below data was collected from official source regarding VAT for few countries. I have used this data in the application.
"DE": 0.19
"FR": 0.20
"BE": 0.21
"CY": 0.19
"DK": 0.25
"FI": 0.24
"LU": 0.17
"HU": 0.27


## Requirements
- Java 1.8
- Gradle 7.5
- Unix environment


## How to Build / Test / Run
- Build
    ```
    cd PROJECT_DIRECTORY
    ./gradlew clean build
    ```
- Test
    ```
    cd PROJECT_DIRECTORY
    ./gradlew test
    ```
- Run
    ```
    cd PROJECT_DIRECTORY
    java -jar build/libs/netpricecalculator-0.0.1-SNAPSHOT.jar
    ```

## API Responses using Postman

