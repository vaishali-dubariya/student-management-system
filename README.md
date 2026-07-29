# Student Management System

A Spring Boot based REST API application for managing student information with CRUD operations, MySQL database integration, DTO pattern, validation, exception handling, and Swagger API documentation.

## Features

- Create student records
- Retrieve all students
- Retrieve student by ID
- Update student details
- Partially update student details
- Delete student records
- DTO based request and response handling
- Input validation
- Global exception handling
- Swagger API documentation

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Swagger/OpenAPI

## Project Architecture

Controller  
↓  
Service  
↓  
Repository  
↓  
Database

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| POST | `/students` | Create student |
| PUT | `/students/{id}` | Update student |
| PATCH | `/students/{id}` | Partial update |
| DELETE | `/students/{id}` | Delete student |

## Running the Application

1. Clone the repository

2. Configure MySQL database in:application.properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password

3. mvn spring-boot:run

## Swagger Documentation

After starting the application, open:
http://localhost:8080/swagger-ui/index.html


Swagger UI allows you to view and test all available REST API endpoints.

## Future Improvements

- Add Spring Security with JWT authentication
- Add role-based authorization
- Add pagination and sorting
- Add unit testing

## Author

Vaishali Dubariya
