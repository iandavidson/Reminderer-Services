# Reminderer-Services
Web Service used email reminders for who ever, when ever.

## Getting Started

### Versions Used:

- Maven: 3.6.0
- Java jdk: 12.0.1
- JUnit 5 (eventually)


### Important to mention:
 
- This Java project uses the library Lombok, so make sure you correctly install that package. [Instructions](http://codeomitted.com/setup-lombok-with-stseclipse-based-ide/)
- I use the IDE Spring Tool Suite 4 for my development; I would suggest you the same :)

## Starting up application

- Use standard Maven Lifecycle commands to build and run application. 
  - [Maven Command Cheat sheet](https://www.jrebel.com/blog/maven-cheat-sheet)
  - [Actual Apache Maven Documentation](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)

- Build:
   - `mvn clean install`
   
- Run:
   - `mvn spring-boot:run`
   
- Run with conditions:
   - `mvn clean install`
   - `java -jar -D<condition> target/reminderer-services-0.0.1-SNAPSHOT.jar`
   
### Look at SwaggerUI while system is running:
- `http://localhost:8081/swagger-ui.html#/`   
   
# Contact me:

If you want to contribute to this project shoot me an email: Ianmattdavidson@gmail.com

Also if you have cool ideas for another project, and need some help feel free to contact me.
