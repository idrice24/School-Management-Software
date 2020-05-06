# A School Management Software project

it is demonstrating how to implement simple CRUD operations with a `Product` entity.

## Technologies (IDE) client/server
**#Server
This project is based on the [Spring Boot](http://projects.spring.io/spring-boot/) project use these packages :
- [Neteans IDE](https://netbeans.org/index.html)
* this ide help us to :
    Setting Up the Project
    Adding Code to the Generated Source File
    Compiling and Running the Application
    Building and Deploying the Application
    Next Steps
  To complete this tutorial, you need the following software and resources
- [Maven](https://maven.apache.org/)
- [Spring Core](https://spring.io/projects/spring-boot)
- [Spring Data](https://spring.io/projects/spring-data-jdbc)
- [Spring MVC](https://www.tutorialspoint.com/spring/spring_web_mvc_framework.htm)
- [Thymleaf](https://www.thymeleaf.org/)
-[JDK](http://java.sun.com/javase/downloads/index.jsp)
  Which stand for Java Development Kit, which help us to develop, text, protype, and demonstrate JAVA Apps.

## Installation 
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database configuration 
Create a MySQL database with the name `springbootdb`and add the credentials to `/resources/application.properties`.  
The default ones are :

```
spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

## Usage 
Run the project and head out to [http://localhost:8080](http://localhost:8080)
