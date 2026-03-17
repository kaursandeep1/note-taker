
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
```
### Test the API
```bash
curl http://localhost:8080/api/notes
```

### 📸 Screenshots
(jyoti nickname)
<img width="1470" height="956" alt="Screenshot 2026-03-17 at 5 51 01 PM" src="https://github.com/user-attachments/assets/600fee5c-bd5d-4d23-b867-67f9e59c8d8a" />
<img width="1470" height="956" alt="Screenshot 2026-03-17 at 5 51 16 PM" src="https://github.com/user-attachments/assets/8906cca2-069d-4c8b-9503-d949d919957d" />
<img width="1470" height="956" alt="Screenshot 2026-03-17 at 6 22 01 PM" src="https://github.com/user-attachments/assets/5720efcf-169c-424c-b52e-036672bfa344" />
<img width="1470" height="956" alt="Screenshot 2026-03-17 at 6 21 53 PM" src="https://github.com/user-attachments/assets/b9a813be-0b5b-4900-a652-bdf23fc33cbf" />
<img width="1470" height="956" alt="Screenshot 2026-03-17 at 6 21 45 PM" src="https://github.com/user-attachments/assets/06e70595-0290-49d7-8b50-d1885a838d01" />



### 🌟 Why This Project
This project demonstrates exactly what employers are looking for:

- Java Development - Spring Boot REST API

- Cloud-Native Skills - AWS DynamoDB integration

- Containerization - Docker packaging

- DevOps - CI/CD with GitHub Actions

- Best Practices - Error handling, environment variables

📝 License
MIT

👨‍💻 Author
Kaur Sandeep


