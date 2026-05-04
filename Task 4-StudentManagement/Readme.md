# Student Management System - Backend

This is a backend application built using Spring Boot for managing student data.

## 🚀 Features

* Add student
* View all students
* Update student details
* Delete student
* Search students by name
* Basic input validation

## 🛠 Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* H2 Database

## 📡 API Endpoints

### Get All Students

GET /students

### Add Student

POST /students

### Update Student

PUT /students/{id}

### Delete Student

DELETE /students/{id}

### Search Students

GET /students/search?name=value

## ▶️ How to Run

1. Navigate to backend folder:
   cd backend

2. Run the application:
   mvn spring-boot:run

3. Open in browser:
   http://localhost:8080/students

## 📌 Note

This is a basic backend version developed as part of internship task. A full-stack version will be built using Angular and a database.
