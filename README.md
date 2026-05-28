# Student CRUD Operation System

## Project Overview

Student CRUD Operation System is a backend application developed using Java, Spring Boot, Hibernate, JPA, and MySQL. The application performs CRUD (Create, Read, Update, Delete) operations for managing student records efficiently using RESTful APIs.

This project demonstrates backend development concepts such as layered architecture, database integration, REST API development, validation, and exception handling.

---

# 🚀 Features

* Add Student Details
* View All Students
* Get Student By ID
* Update Student Information
* Delete Student Record
* RESTful API Development
* Validation Handling
* Exception Handling
* Layered Architecture
* MySQL Database Integration

---

# 🔐 Backend Functionalities

* CRUD Operations
* Spring Boot REST APIs
* Hibernate ORM
* JPA Repository
* Global Exception Handling
* Request Validation
* JSON Request & Response Handling

---

# 🛠️ Technologies Used

## Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* REST APIs

## Database

* MySQL

## Tools

* Maven
* Git
* GitHub
* Postman
* Swagger UI

---

# 📂 Project Architecture

```text id="s1"
Controller → Service → Repository → Database
```

---

# 📌 API Endpoints

| Method | Endpoint              | Description       |
| ------ | --------------------- | ----------------- |
| POST   | /students/save        | Save Student      |
| GET    | /students/get         | Get All Students  |
| GET    | /students/get/{id}    | Get Student By ID |
| PUT    | /students/update/{id} | Update Student    |
| DELETE | /students/delete/{id} | Delete Student    |

---

# ▶️ Run Project

## Clone Repository

```bash id="s2"
git clone https://github.com/nitesh2027/CRUD-Operation.git
```

---

## Configure Database

Update `application.properties`:

```properties id="s3"
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=root
```

---

## Run Application

```bash id="s4"
mvn spring-boot:run
```
---
# 🔮 Future Enhancements

* JWT Authentication
* Student Login System
* Role-Based Authorization
* Docker Integration
* Jenkins CI/CD
* AWS Deployment

---

# 👨‍💻 Author

Nitesh Kumar

Java Developer
