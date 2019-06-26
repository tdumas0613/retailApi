# retailApi
An api that pulls data from various sources to serve up information about retail products. Created for demonstration purposes

Dependencies Required to run Project:
- Maven (Recommend latest version)
- MongoDB (Minimum version 4.0.10)
  - Must have a running Mongo Database named "retail" with a colletion named retail_products and at least one document with the following json structure:
  {
	"_id" : <Integer>,
	"price" : <Double>,
	"name" : <String>,
	"currencyCode" : <String>,
	"_class" : com.dumas.retail.api.domain.RetailProduct
}
  - NOTE: RetailProduct class can be found in Java project
- Java (Minimum version 1.8)

To Run project locally:
- Clone to local computer
- Launch shell (command line on windows)
- Navigate to project folder in shell
- Run "mvn clean package" to create runnable artifact
- Navigate to target folder within project structure and run command "java -jar retail.api-0.0.1-SNAPSHOT.jar"
  - OR Run "java -jar target/retail.api-0.0.1-SNAPSHOT.jar" from base project folder
- Project can also be ran from IDE by running "MyRetailApplication.java" as a Java Project
- Can run in debug mode if desired

Link To PostMan Collection for hitting project locally:
https://www.getpostman.com/collections/3baa3c28017e1b8b8319

Project tests can be ran from IDE by running any or all test(s) in the src/test/java package. May also invoke "mvn clean package" to run tests. Project can also be tested by running the project (see instructions above) and using PostMan requests linked above to hit the API
