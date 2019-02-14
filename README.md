# SpringBoot-MySql
Used tech
  1. Spring Boot
  2. Maven
  3. MySql
  4. JPA Hibernate
  5. Tomcat server
  
  
  Build:
  mvn clean install -- creates a .war file
  
  Deploy:
 1. copy the .war to tomcat server under <tomcat_home>/webapps
 2. go to the <tomcat_home>/bin
 3. run ./startup.sh
 4. check the logs under <tomcat_home>/logs/catalina.out
 5. http://localhost:8080 host for the server.

  
