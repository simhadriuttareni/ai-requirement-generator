# 🚀 AI Requirement Generator – Backend System

A **production-grade Spring Boot backend** that generates structured software requirement documents from high-level project ideas and persists them using PostgreSQL.
Designed with **clean architecture, security, and containerization**, suitable for real-world backend and AI-driven systems.

---

## ⚠️ Note on Online Sandboxes

This project is a production-style Spring Boot backend that relies on:
- Docker
- PostgreSQL
- JVM runtime

Online sandboxes (GitHub preview, StackBlitz, etc.) may not support
Docker or database containers.

Please run locally using Docker Compose (instructions below).


## 📌 Project Overview

In real software teams, requirement gathering is often manual, inconsistent, and time-consuming.
This project solves that by providing a backend system that:

* Accepts a high-level project idea
* Generates structured requirement sections
* Persists them for future reference
* Exposes REST APIs for integration
* Runs fully containerized using Docker

This system can be extended later to integrate **LLMs (GPT APIs)** or workflow automation tools.

---

## ✨ Features

* Generate structured requirement documents:

  * Functional requirements
  * Non-functional requirements
  * User stories
  * Assumptions
  * Constraints
  * Risks
  * Acceptance criteria
* RESTful API design
* PostgreSQL persistence using JPA/Hibernate
* JWT-based security foundation
* Health monitoring via Actuator
* Fully Dockerized (App + DB)
* Clean, layered architecture

---

## 🛠 Tech Stack

### Backend

* **Java 17**
* **Spring Boot 3**
* Spring Web (REST APIs)
* Spring Data JPA (Hibernate)
* Spring Security (JWT ready)
* Spring Validation
* Spring Boot Actuator

### Database

* **PostgreSQL 15**

### DevOps / Infra

* **Docker**
* **Docker Compose**
* Maven

### API Documentation

* **Swagger / OpenAPI (springdoc)**

---

## 🧱 Project Architecture

```
src/main/java/com/simhadri/aireq
│
├── controller        # REST Controllers
├── service           # Business interfaces
│   └── impl           # Service implementations
├── repository        # JPA Repositories
├── entity            # JPA Entities
├── dto               # Request / Response DTOs
├── security
│   ├── jwt            # JWT utilities & filters
│   └── config         # Security configuration
├── config             # Application configuration
├── exception          # Global exception handling
└── util               # Utility helpers
```

---

## 🐳 Running the Project (Recommended Way)

### Prerequisites

* Docker
* Docker Compose

### 1️⃣ Build the application JAR

```bash
mvn clean package
```

### 2️⃣ Start Application + PostgreSQL

```bash
docker compose up
```

This will:

* Start PostgreSQL container
* Start Spring Boot application container
* Automatically connect app ↔ database
* Create database tables on startup

---

## 🔍 Verify Application Health

Open in browser:

```
http://localhost:8080/actuator/health
```

Expected response:

```json
{
  "status": "UP"
}
```

---

## 📖 API Documentation (Swagger)

Once running, access Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

---

## 🔐 Security Notes

* Spring Security is enabled
* JWT infrastructure is in place
* Default security configuration is for **development only**
* Can be extended to:

  * Login API
  * Role-based access
  * Token refresh

---

## 📦 Docker Files

### Dockerfile

```dockerfile
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/aireq-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
```

### docker-compose.yml

```yaml
services:
  postgres:
    image: postgres:15
    container_name: aireq-postgres
    environment:
      POSTGRES_DB: aireqgen
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: 1234
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

  app:
    build: .
    container_name: aireq-app
    ports:
      - "8080:8080"
    depends_on:
      - postgres

volumes:
  postgres_data:
```

---

## 🚀 Future Enhancements

* Integrate GPT / LLM APIs for real AI-generated requirements
* User authentication & authorization
* Versioning of requirement documents
* Export to PDF / DOCX
* Event-driven architecture using Kafka
* Cloud deployment (AWS / GCP)

---

## 👤 Author

**Simhadri Dev**
Backend & AI Engineer
Tech Stack: Java, Spring Boot, PostgreSQL, Docker, AWS, Kafka, Redis

🔗 LinkedIn: (https://www.linkedin.com/in/simhadri-uttareni)
🔗 GitHub: (https://github.com/simhadriuttareni/)
🔗 Leetcode: (https://leetcode.com/u/simhadri_02/)


---

## ⭐ Final Note

This project is intentionally built to reflect **real backend engineering standards**, not just CRUD operations.
It demonstrates **architecture, scalability, and production readiness**, making it suitable for:

* Backend Engineer roles
* Junior / Entry-level Software Engineer roles
* Remote & product-based companies


