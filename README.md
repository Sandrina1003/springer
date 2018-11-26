# Drawing Application

The solution is a maven project that builds with java 8.

In order to build the project you need the standard installation of maven(3.6.0) and java jdk(1.8+).

Steps to work with the application
1. Checkout the application
2. Build with maven (mvn clean install)
3. Run the application (java -jar drawapplication/target/drawapplication-1.0-SNAPSHOT.jar)


#Design

The drawing operations are implemented using the command design pattern.
Drawing the line and rectangle are simple math problems. but filling the area is 
implemented using the bfs(breadth-first-search) algorithm. 
For deciding which command should be executed in runtime, factory design pattern is used.

The validation of user input is implemented as a separate concern in an isolated validation service.

#Tests

For testing mockito and junit libraries are used. 
The edge cases are covered with boundary values analysis.
The tests achieve 70% line coverage.  
 
