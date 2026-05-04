# CODSOFT Internship Projects

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring-boot&logoColor=white)
![Angular](https://img.shields.io/badge/Angular-DD0031?style=flat&logo=angular&logoColor=white)
![TypeScript](https://img.shields.io/badge/TypeScript-007ACC?style=flat&logo=typescript&logoColor=white)

This repository contains all the tasks completed as part of the **CodSoft Java Programming Internship**, progressing from core Java fundamentals to full-stack web development.

---

## 🚀 Completed Tasks

### 🔹 Task 1: Number Guessing Game

📂 [`Task 1-NumberGame/`](Task%201-NumberGame/)

* Console-based Java application + Swing GUI version
* Random number generation with limited attempts (5 tries)
* Feedback on each guess: Too high / Too low
* **Tech:** Java SE, Scanner, Random, Swing

---

### 🔹 Task 2: Student Grade Calculator

📂 [`Task2-StudentGradeCalculator/`](Task2-StudentGradeCalculator/)

* Console + GUI application that calculates total, average, highest/lowest marks
* Grade assignment (A–F) with input validation (0–100 range)
* **Tech:** Java SE, Scanner, Arrays, Swing

---

### 🔹 Task 3: ATM System

📂 [`Task3-ATM/`](Task3-ATM/)

* Object-Oriented ATM simulation with `BankAccount` class
* Features: Deposit, Withdraw, Balance check, Last transaction

#### ⭐ Enhanced Version (`Task3-ATM/Task3-ATM-Enhanced/`)

* PIN-based authentication with 3-attempt lockout
* Full transaction history per account
* Money transfer between accounts via `Bank` manager class
* **Tech:** Java SE, OOP (Encapsulation, Classes), Scanner

---

### 🔹 Task 4: Student Management System (Full Stack)

📂 [`Task4-StudentManagement/`](Task4-StudentManagement/)

A full-stack CRUD web application to manage student records.

**Backend — Spring Boot**
* REST APIs for Add / Update / Delete / Search students
* Spring Data JPA with H2 in-memory database
* Runs on: `http://localhost:8080`

**Frontend — Angular**
* TypeScript + component-based UI
* Form-based record management with real-time updates
* Runs on: `http://localhost:4200`

**Quick start:**

```bash
# Backend
cd Task4-StudentManagement/backend
mvn spring-boot:run

# Frontend (new terminal)
cd Task4-StudentManagement/frontend
npm install && ng serve
```

---

## 🏗 Tech Stack

| Layer | Technologies |
|---|---|
| Language | Java SE |
| GUI | Java Swing |
| Backend | Spring Boot, Spring Data JPA |
| Frontend | Angular, TypeScript, HTML/CSS |
| Database | H2 (in-memory) |
| Build | Maven, npm |
| VCS | Git & GitHub |

---

## 📁 Repository Structure

```text
CODSOFT/
 ├── Task 1-NumberGame/
 │    ├── NumberGame.java         ← Console version
 │    ├── NumberGameGUI.java      ← Swing GUI version
 │    └── Readme.md
 ├── Task2-StudentGradeCalculator/
 │    ├── StudentGradeCalculator.java
 │    ├── StudentGradeGUI.java
 │    └── Readme.md
 ├── Task3-ATM/
 │    ├── ATM.java
 │    ├── BankAccount.java
 │    ├── README.md
 │    └── Task3-ATM-Enhanced/    ← Auth + transfer + history
 │         ├── ATM.java
 │         ├── Bank.java
 │         └── BankAccount.java
 └── Task4-StudentManagement/
      ├── backend/               ← Spring Boot REST API
      ├── frontend/              ← Angular UI
      └── Readme.md
```

---

## 📌 Note

This repository reflects a learning journey from basic Java programs through OOP design to
building a full-stack web application — the four tasks form a deliberate progression in
complexity and architecture.

---

## 👤 Author

**Anuj Vijay Mhatre** · IT Student, TCET (Class of 2027)

[![GitHub](https://img.shields.io/badge/GitHub-Anuj18m-181717?style=flat&logo=github)](https://github.com/Anuj18m)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-anujmhatre17-0077B5?style=flat&logo=linkedin)](https://linkedin.com/in/anujmhatre17)
