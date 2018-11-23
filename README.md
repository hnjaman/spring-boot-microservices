# sping-boot-microservices
is a microservice application with National Id and Passport
service, sms service and some other service are under processing like payment service, location
service etc. 
All of the services are separate application which can be operated in a single page
Angular UI. All the services can be reused to any other application.

## Features:
- RESTful Microservices
- Cross-Origin Resource Sharing with Spring boot and Angular
- Docker

## Services:
 - NID and Passport service
  
 - [SMS service](https://github.com/hnjaman/sping-boot-microservices/tree/master/sms-service)
  
 - [Location service](https://github.com/hnjaman/sping-boot-microservices/tree/master/location-service) (coming soon)
 
 - Payment service (Coming)
  
##  How to run?

```
# Build and run NID, Passport services  
mvn clean install
mvn spring-boot:run
# Go to http://localhost:8888/nids; http://localhost:8888/passports
```

```
# Run sms service
cd sms-service
mvn spring-boot:run
# Go to http://localhost:8999/sms
```

```
# Run Angular User interface
cd microservice-ui
# install node package manager
npm install
ng s --open
# Go to http://localhost:4200/
```

## Copyright & License

MIT License, see the link: [LICENSE](https://github.com/hnjaman/sping-boot-microservices/blob/master/LICENSE) file for details.
