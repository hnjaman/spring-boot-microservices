FROM openjdk:8
ADD target/spring-boot-angular.jar spring-boot-angular.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "spring-boot-angular.jar"]