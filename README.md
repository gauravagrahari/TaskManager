# TaskManager

TaskManager - A Simple Task Management Application
Overview
TaskManager is a RESTful API built using Java Spring Boot that allows users to manage tasks. It includes features for creating, retrieving, updating, and deleting tasks, all stored in a PostgreSQL database.

Prerequisites
JDK 19: Ensure that JDK 19 is installed on your machine.
Maven: TaskManager uses Maven as the build tool.
PostgreSQL: Make sure you have PostgreSQL installed and running.
Getting Started
Clone the Repository
bash
Copy code
git clone https://github.com/your-repository-url/TaskManager.git
cd TaskManager
PostgreSQL Setup
Install PostgreSQL: If you don't have PostgreSQL installed, you can download and install it from here.

Create a Database:

Open the PostgreSQL shell and log in as the postgres user or another superuser.
Create a new database:
sql
Copy code
CREATE DATABASE task_manager;
Optionally, create a new user with a password and grant privileges to the new database:
sql
Copy code
CREATE USER task_user WITH PASSWORD 'yourpassword';
GRANT ALL PRIVILEGES ON DATABASE task_manager TO task_user;
Configure application.properties:

Open the src/main/resources/application.properties file.
Update the following properties with your PostgreSQL credentials:
properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/task_manager
spring.datasource.username=task_user
spring.datasource.password=yourpassword

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
Build and Run the Application
Build the Project:

Navigate to the project directory and run:
bash
Copy code
mvn clean install
Run the Application:

Start the Spring Boot application:
bash
Copy code
mvn spring-boot:run
Access the API:

The application will run on http://localhost:8080.
You can use tools like Postman or Curl to interact with the API.
Running Tests
Run Unit Tests:
To run the unit tests, execute:
bash
Copy code
mvn test
Assumptions and Considerations
JDK 19: This project assumes you are using JDK 19. Make sure your environment is set up accordingly.
Database Setup: It is assumed that you have a basic understanding of PostgreSQL and can set up the database as instructed.
Time Zone Handling: Tasks are stored in UTC, but the application handles the conversion based on the user's time zone if provided.
Error Handling: The application uses global exception handling to manage common errors such as validation failures and resource not found.