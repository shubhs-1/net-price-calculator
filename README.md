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
    
## cURL for Postman
    ```
    curl --location --request POST 'http://localhost:8080/api/v1/calculate/netprice' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "grossPrice": 100,
        "countryIso": "DE"
    }'
    ```


## How to Import cURL in Postman
- Open Postman -> Import -> Raw Text -> Paste above cURL -> Import


## Example API Responses using Postman
<img width="1015" alt="image" src="https://user-images.githubusercontent.com/30280454/183746811-53e7a986-194e-4fa4-816e-edab0aa4c821.png">

<img width="1014" alt="image" src="https://user-images.githubusercontent.com/30280454/183747065-57efb5d6-ab93-419f-8e42-a11d3f465e1d.png">

<img width="1012" alt="image" src="https://user-images.githubusercontent.com/30280454/183747206-a27f9680-ae0c-48f6-a559-3e997385144f.png">

<img width="1010" alt="image" src="https://user-images.githubusercontent.com/30280454/183747343-25d5df4a-807a-4e72-97b3-d829c34b58b5.png">

