# AIS
Automatic Irrigation System for efficient watering cultivation lands

Demonstrates a solution to efficiently manage the irrigation of cultivation lands, use an api to configure land plots and their irrigation schedules, and additionally overrides the configuration via sensing the soil moisture and water levels.


The system comprises of below containers/application :
* The edge service - that will have the core implementation of the above solution, designed following a best practice from 'clean-architecture',  which interacts with external via gateways for Database (MySQL) and MQTT Middleware (Eclipse Mosquitto) , also expose a Rest API to manage the land plot resource and configure its irrigation schedules.

> Containing services/modules :
> 1.  Entity - Implements the core business rules  
> 2.  UseCases - Services that implements user stories, also contains models/DTO that are transferred across boundaries
> 3.  Interface Adaptors - Services expose or consume external services/applications      
>     - Cross-cutting concerns like transactions and exceptions are handled using inbuilt Spring AOP Advice
 

 
		

* The Web application - will provide the UI to maintain the land plots and consume the Rest API provided by the edge service

* MySQL database - for persisting the land plot configurations and collected soil sensor data  

* Eclipse Mosquitto (implements MQTT protocol) - event-driven, light weight messaging between the edge service and the IoT devices  

### The High level architecture diagram
![image info](./docs/Irrigation-System-Architecture.jpg)

  
   
Cross-cutting concerns like transactions and exceptions are handled using inbuilt Spring AOP Advice Exception mapping from application exceptions to the right HTTP response with exception details in the body
Spring Data Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations.
Automatic CRUD functionality against the data source using Spring Repository pattern
Demonstrates MockMVC test framework with associated libraries
All APIs are "self-documented" by Swagger2 using annotations


## Pre-requesites :
*  Java  1.8+
*  MySQL 8
*  Maven 3.2+
*  Eclipse Mosquitto 2.15 (optional) 
		


## Setup a runtime env. for the application:

** Clone this repository and build the application using :**  
>> -  mvn clean package   
   (Note: the built artifact 'automatic-irrigation-system'.jar, will be found in location ./target/ )

** Start the application with below command :   **  
>> -  java -jar ./target/automatic-irrigation-system.jar --server.port=8080 --mysql.host=localhost --mysql.port=3306 --mysql.database=ais --mysql.username=aisapp --mysql.password=123    
   (Note: the sensitive or environment specific configuration parameters are overridden with CLI options to above java command ) 
   
** TODO: Optionally run within a docker container : **
>> -  docker build -t andela/ais .
>> -  docker run -p 8080:8080 andela/ais
	

## Access the API document
		
**APIs are "self-documented" by OpenApi/Swagger using annotations**   
>  - OpenAPI document is accessed ( or download yaml format) from :    
>  		-  http://localhost:8080/api/doc   
>  		-  http://localhost:8080/api/doc.yaml

>  - A more user friendly UI (Swagger) of OpenAPI document is accessed format from :  
>  		-  http://localhost:8080/api/swagger

>   ![image info](./docs/rest-api-swagger.jpg)    	
   	

 
  
 
