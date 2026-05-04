# Student Management System (Full Stack)

A full-stack web application to manage student records, built using Spring Boot and Angular.

---

## Features

* Add, update, delete student records
* View all students
* Search students by name
* Form-based UI with real-time updates
* RESTful backend with database integration

---

## Architecture

Frontend (Angular) -> Backend (Spring Boot API) -> Database (H2)

---

## Tech Stack

Frontend

* Angular
* TypeScript
* HTML/CSS

Backend

* Java
* Spring Boot
* Spring Data JPA

Database

* H2 (in-memory)

---

## Project Structure

```text
Task4-StudentManagement/
 ├── backend/
 └── frontend/
```

---

## Running the Project

### Backend

```text
cd backend
mvn spring-boot:run
```

Runs on:
http://localhost:8080

---

### Frontend

```text
cd frontend
npm install
ng serve
```

Runs on:
http://localhost:4200

---

## API Endpoints

| Method | Endpoint               | Description      |
| ------ | ---------------------- | ---------------- |
| GET    | /students              | Get all students |
| POST   | /students              | Add student      |
| PUT    | /students/{id}         | Update student   |
| DELETE | /students/{id}         | Delete student   |
| GET    | /students/search?name= | Search student   |

---

## Future Improvements

* Authentication (login system)
* Role-based access (Admin/User)
* Persistent database (MySQL/PostgreSQL)
* UI enhancements (Material UI / Tailwind)
* Deployment with cloud services

---

## Note

This project was developed as part of an internship task and later extended into a full-stack application.

---

## Repository

https://github.com/Anuj18m/CODSOFT
