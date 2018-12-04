# sping-boot-microservices
is a microservice application with User authentication, sms service, contact service, location service,
National Id and Passport service and some other service are under processing like payment service etc.
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

## Technology

### API Gateway
It itself a service for facing clients. Just like the entry point to get any service.
Receive all the request and delegates the request to the appropriate service.
Like a gatekeeper.
- Zuul

### Service Registry and Service Discovery
All microservice instances will register with a naming server for service registraton. When a service wants 
to use another service, it will ask to naming server what instances are currently running. Server will check
the instances and pass the request to the instance. This is called service discovery.
The advantage is s service registry always updates itself, if one instance goes down, 
it removes it from its registry.
- Eureka
- Zookeeper
- Consul

### Client Side Load Balancing
Multiple instances of a services will be distriduted to calling services.
if one microservice wants to communicate with another microservice, 
it generally ask the service registry which returns all the instances of the 
called microservice to the calling service. Then it is calling service headache 
which instance it will call. This is the process of client side load balancing.
- Ribbon

### Intra Communication among Microservices
Invoking other microservices via http proxy request.
- REST Templete
- Feign
  - Developers don’t have to bother about REST internal details. Encoding request and 
Decoding reponse are happened by Feign.

### Distributed Tracing
Simply the centralized log for all services to tracing complete chain of what happened 
in a specific request. Centralized information container for all the services.
- Spring cloud sleuth 
  - Tracing request as assign an unique id to every request so that the request can be identified
inside every services.
- RabbitMQ 
  - The Advanced Message Queuing Protocol (AMQP) which put all services log in one message queue 
and send it to tracing server like Zipkin. All services are connected with RabbitMQ.
- Zipkin
  - The server application for visualizing what happens on the specific request.

## Services:
 
 - [User Authentication service](https://github.com/hnjaman/sping-boot-microservices/tree/master/user-authentication)
  
 - [SMS service](https://github.com/hnjaman/sping-boot-microservices/tree/master/sms-service)
 
 - [Contacts service](https://github.com/hnjaman/spring-boot-microservices/tree/master/contact-service)
  
 - [Location service](https://github.com/hnjaman/sping-boot-microservices/tree/master/location-service)
 
 - NID and Passport service
 
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
# multiple instances of services and we need a mechanism to call other services without hardcoding
# their hostnames or port numbers. In Cloud environments service instances may come up and go down
# anytime. So we need some automatic service registration and discovery mechanism. 
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
# using RESTTemplete.
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
