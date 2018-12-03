# sping-boot-microservices
is a microservice application with User authentication, National Id and Passport
service, sms service and some other service are under processing like payment service, location
service etc. 
All of the services are separate application which can be operated in a single page
Angular UI. All the services can be reused to any other application.

## Features:
- RESTful Microservices
- JWT authentication
- Cross-Origin Resource Sharing
- Spring Boot, Spring cloud, Spring Data JPA, Spring Security
- Eureka Naming Server
- Zuul API Gateway
- Angular
- Java 8 (recommended), 10
- Docker

## Services:
 - NID and Passport service
 
 - [User Authentication service](https://github.com/hnjaman/sping-boot-microservices/tree/master/user-authentication)
  
 - [SMS service](https://github.com/hnjaman/sping-boot-microservices/tree/master/sms-service)
 
 - [Contacts service](https://github.com/hnjaman/spring-boot-microservices/tree/master/contact-service)
  
 - [Location service](https://github.com/hnjaman/sping-boot-microservices/tree/master/location-service)
 
 - Payment service (Coming)
  
##  How to run?

```
# Set mysql database 
mysql -u root -p
create user 'cfbd'@'localhost' identified by '1234';
grant all privileges on *.* to 'cfbd'@'localhost';
create database if not exists user_db;
# Initially tables and data will be created automatically by Java Persistence API
# Update and new operation can be happened from UI
```

```
# Run Eureka naming server to register your services  
mvn clean install
mvn spring-boot:run
# Go to http://localhost:8761
# Check "Instances currently registered with Eureka"
# nothing will be shown because you didn't start any services
# Its Eureka dashboard, where we can inspecting the registered instances later. 
# In the microservices world, Service Registry and Discovery play role since we most likely run 
# multiple instances of services and we need a mechanism to call other services without hardcoding their hostnames 
# or port numbers. In Cloud environments service instances may come up and go down anytime.
# So we need some automatic service registration and discovery mechanism. 
# Spring Cloud provides Service Registry and Discovery features, as usual, with multiple options.
```

```
# Build and run user authentication services  
mvn spring-boot:run
# It will start on http://localhost:8777//api/auth
# for signup -> http://localhost:8777/api/auth/signup
# refresh Eureka (http://localhost:8761)
# Check again "Instances currently registered with Eureka"
# you will see user-authentication is UP
# if you stop this services then it will be DOWN

# When Eureka server didn’t get received any notification from a service. 
# Then the service will be unregistered from the Eureka server automatically.
```

```
# Run Contact service
cd contact-service
mvn spring-boot:run
# It will start on http://localhost:8555/
# and insert 2 dummy contacts info in contact table with name, contact number and address
# Get all Contacts -> http://localhost:8555/contacts/all
# Search by name -> http://localhost:8555/contacts/name/hnjaman
# here hnjaman is the name you searching 
# it will send all contacts containing "hnjaman"
```

```
# Run sms service
cd sms-service
mvn spring-boot:run
# It will start on http://localhost:8999/sms
# To check message for "hnjaman" -> http://localhost:8999/contacts/name/hnjaman/sms
# it will get name and contact number from contact service and generate a custom message for "hnjaman"
# Refresh and check Eureka
```

```
# All service are started use them on Angular UI
# Run Angular User interface
cd microservice-ui
# install node package manager (just for first time)
npm install
ng s --open
# It will open automatically in http://localhost:4200/home
```

## Copyright & License

MIT License, see the link: [LICENSE](https://github.com/hnjaman/sping-boot-microservices/blob/master/LICENSE) file for details.
