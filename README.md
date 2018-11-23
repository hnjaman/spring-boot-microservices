# sping-boot-microservices
## RESTful microservices
## Cross-Origin Resource Sharing with Spring boot and Angular

### Services:
  NID and Passport service
  
  SMS service
  
  Location service (coming soon)
  
###  How to run?

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

### Copyright & License

MIT License, see the link:LICENSE[LICENSE] file for details.
