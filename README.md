# Library Inventory API

## Overview
This is a RESTful API for managing a library's book inventory. It allows CRUD operations for books, authors, students, and lending history.

## Tech Stack
- **Java** (Spring Boot)
- **Spring Data JPA**
- **Hibernate**
- **MySQL** (or any other relational database)
- **Lombok**
- **Maven**

---

## Setup Instructions

### Prerequisites
- JDK 17+
- Maven
- MySQL (or any compatible RDBMS)
- Postman/Insomnia (optional, for API testing)

### Steps to Run the Project

1. **Clone the Repository**
   ```sh
   git clone https://github.com/princeprag/library-management-system
   cd library-management-system
   ```

2. **Configure Database**
   Update `application.properties` with your database details:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/librarysystem
   spring.datasource.username=root
   spring.datasource.password=root
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build and Run the Project**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

---

## API Endpoints

### **1. Books API** `/api/books`

| Method | Endpoint            | Description |
|--------|---------------------|-------------|
| `POST` | `/api/books`        | Add a new book |
| `GET`  | `/api/books`        | Retrieve all books |
| `GET`  | `/api/books/search?title={title}` | Search books by title (partial match) |
| `GET`  | `/api/books/search?author={author}` | Search books by author (partial match) |
| `PUT`  | `/api/books/{id}` | Update book details |
| `DELETE` | `/api/books/{id}` | Delete a book |

Example JSON Payload for Adding a Book:
```json
{
    "title": "One Indian Girl",
    "author": {
        "id": 4
    },
    "isbn": "45685213",
    "publishedYear": 2003,
    "availabilityStatus": "AVAILABLE"
}
```

---

### **2. Authors API** `/api/authors`

| Method | Endpoint        | Description |
|--------|----------------|-------------|
| `POST` | `/api/authors` | Add a new author |
| `GET`  | `/api/authors` | Retrieve all authors |

Example JSON Payload for Adding an Author:
```json
{
    "name":"Chetan Bhagat"
}
```

---

### **3. Students API** `/api/students`

| Method | Endpoint        | Description |
|--------|----------------|-------------|
| `POST` | `/api/students` | Register a new student |
| `GET`  | `/api/students` | Retrieve all students |

Example JSON Payload for Adding a Student:
```json
{
    "name": "Viraj P",
    "studentId": "180102030"
}
```

---

### **4. Lending API** `/api/lendings`

| Method  | Endpoint              | Description |
|---------|-----------------------|-------------|
| `POST`  | `/api/lendings/borrow?bookId={bookId}&studentId={studentId}` | Borrow a book |
| `POST`  | `/api/lendings/return/{lendingId}` | Return a book |
| `GET`   | `/api/lendings` | Get lending history |

---

## Additional Features
- **Validation**: Ensures unique ISBN, valid published year, and prevents invalid operations.

---

## Future Enhancements
- Authentication & Authorization (Spring Security + JWT)
- Email Notifications for Due Dates
- Advanced Filtering & Sorting for Books
- Rate Limiting
