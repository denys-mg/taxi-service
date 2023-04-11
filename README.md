# Taxi Service

## Project Description:

A simple web-application to manage taxi cars, their drivers and cars manufacturers. The main point of this project is to learn how to create CRUD programs, familiarize with the Servlet API and get more practice with a database.

## Features:

- Authentication and Registration (as a driver).
- Show information about car / driver / manufacturer.
- Manage cars by changing characteristics.
- Create new and deleting existing entity.

## How to run:

- Clone the project repository to your local machine
- Initialize your database: run the SQL script located in src/main/resources/init_db.sql file
  (You can Configure connection in src/main/java/taxi/util/ConnectionUtil class)
- Build the project using Maven: ___mvn clean package___
- Configure and deploy the generated WAR file by server such as Tomcat.

## Structure:

- __Controllers__ (Presentation layer, handling http-requests and showing required JSP)
    - /login - authentication
    - /logout - invalidate current session
    - /manufacturers - display all Manufacturers
    - /manufacturers/add - create a new Manufacturer
    - /manufacturers/delete - delete Manufacturer
    - /drivers - display all Drivers
    - /drivers/add - registration/creation of a new Driver
    - /drivers/delete - delete Driver
    - /drivers/cars - display all Cars for a specific Driver
    - /cars - display all Cars
    - /cars/add - create a new Car
    - /cars/delete - delete Car
    - /cars/drivers - display all Drivers for a specific Car
    - /cars/drivers/add - management of Car Drivers
    - / OR /index - root page
- __DAO__ (Data layer, organization of work with databases)
- __Exception__ (Custom exceptions)
- __Lib__ (annotations and Injector realization)
    - Injector - component of a dependency injection, responsible for creating and managing the objects,
      and injecting the required dependencies into them.
- __Model__ (The classes that represent the business data or domain objects of an application)
- __Service__ (Logic layer, handling all business logic)
- __Util__ (Utility classes and helper methods that are used throughout the application)
- __Filter__ (Servlet filter - a way to perform pre-processing or post-processing of requests and responses
  before they are handled by the servlet or returned to the client).
- __Resources__ (Directory that typically contains the non-Java files that are required by the application)
- __Webapp__ (Web resources: JSP files, configuration file - web.xml)

## Used technologies:

- JDK ```17```
- Apache Maven ```3.8.7```
- JDBC ```4.2```
- MySQL ```8.0.32```
- JSTL ```1.2```
- Bootstrap ```5.3```
- Java Servlets ```4.0.1```
- Apache Tomcat ```9.0.73```

## Overview:

![Overview](/src/main/assets/cars.png)
