Online Assessment for fetch - Steps to run application in local
Pre-requisites:
1. IntelliJ
2. Docker
3. Docker Compose
4. Java SDK 22
5. Maven
6. Port 8081 should be available

Steps To Run:
1. Clone the repository using the link on github and then checkout the master branch (preferably in IntelliJ)
2. open project structure in IntelliJ and set the SDK to openjdk-22
3. IntelliJ will automatically detect the maven dependency and ask to load maven dependency
4. Please select "load maven dependencies"
5. Once dependencies are loaded you can do a mvn clean install
6. Once build is successful start the docker using command "docker-compose build"
7. Run the command "docker-compose up" to start the docker and the service
8. To test if local setup is working hit this endpoint using intelliJ generated requests GET http://localhost:8081/receipts/projectName which should return WELCOME TO RECEIPT PROCESSOR
9. Now you can test the other endpoints in the code.

Example:
1.
###
POST http://localhost:8081/receipts/process
Content-Type: application/json

{
  "retailer": "M&M Corner Market",
  "purchaseDate": "2022-03-20",
  "purchaseTime": "14:33",
  "items": [
    {
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    }
  ],
  "total": "9.00"
}

2.
###
GET http://localhost:8081/receipts/{receipt_id}/points 
