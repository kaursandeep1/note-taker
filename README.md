cat > README.md << 'EOF'
# ☁️ Cloud Note-Taker App

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-green)
![AWS](https://img.shields.io/badge/AWS-DynamoDB-orange)
![Docker](https://img.shields.io/badge/Docker-Containerized-blue)
![CI/CD](https://img.shields.io/badge/CI/CD-GitHub%20Actions-brightgreen)

A cloud-native note-taking application built with Java Spring Boot that stores data in AWS DynamoDB.

## ✨ Features

- ✅ Save notes to AWS Cloud
- ✅ Retrieve all notes
- ✅ Data persistence across app restarts
- ✅ Docker containerization
- ✅ CI/CD with GitHub Actions
- ✅ Web interface (coming soon)

## 🛠️ Tech Stack

- **Backend:** Java 17, Spring Boot 3.2.4
- **Cloud:** AWS DynamoDB (Serverless NoSQL)
- **Container:** Docker
- **CI/CD:** GitHub Actions
- **Build Tool:** Maven

## 📋 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/notes` | Save a note (send plain text) |
| GET | `/api/notes` | Retrieve all notes |
| DELETE | `/api/notes/{id}` | Delete a note |

## 🚀 Quick Start

### Prerequisites
- Java 17
- AWS account with DynamoDB table "Notes"
- Docker (optional)

### Run with Maven
```bash
./mvnw spring-boot:run
