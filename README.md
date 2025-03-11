# 🗨️ RealChat-App

**RealChat-App** is a **real-time group chat application** built with **Spring Boot, WebSockets, and Thymeleaf**. It supports **user authentication, secure messaging, and database persistence** using MySQL.

## 🚀 Features

✅ **User Authentication** (Spring Security, Session-based login)  
✅ **Real-time Messaging** (WebSockets with STOMP)  
✅ **Group Chat Support** (Messages broadcasted to all users)  
✅ **Message Persistence** (Stored in MySQL via JPA & Hibernate)  
✅ **WebSocket Event Logging** (Tracks user connections)  
✅ **Thymeleaf UI with JavaScript WebSockets**  

---

## 🛠️ Technologies Used

| Tech | Description |
|------|------------|
| **Spring Boot 3.4.3** | Backend framework |
| **Spring Security** | User authentication |
| **Spring WebSockets** | Real-time messaging |
| **Spring Data JPA** | Database ORM |
| **MySQL** | Database for storing messages & users |
| **Thymeleaf** | HTML templating engine |
| **SockJS & Stomp.js** | WebSocket communication |

---

## 📂 Project Structure

RealChat-App/ │── src/main/java/com/app/realchatapp/ │ ├── config/ # Security & WebSocket Config │ ├── controller/ # API & Page Controllers │ ├── entity/ # JPA Entities (User, Message) │ ├── repository/ # Data Repositories │ ├── service/ # Business Logic Services │── src/main/resources/ │ ├── templates/ # Thymeleaf HTML Pages │ ├── static/css/ # Stylesheets │ ├── static/js/ # JavaScript (WebSockets, UI) │── application.properties # Database & Server Config │── pom.xml # Maven Dependencies
