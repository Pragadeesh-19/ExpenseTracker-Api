# Expense Tracker API

## Overview

The Expense Tracker API is a RESTful web service designed to help users manage their daily expenses. Users can register, authenticate using JWT tokens, and perform CRUD operations on their expenses. The API supports filtering expenses by date range and category.

## Features

- **User Registration**: Sign up as a new user.
- **JWT Authentication**: Secure access to the API using JSON Web Tokens.
- **Expense Management**:
  - Add new expenses.
  - List all expenses.
  - Filter expenses by category or date range.
  - Update existing expenses.
  - Delete expenses.

## Technologies Used

- **Java 22**
- **Spring Boot 3**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**

## Prerequisites

- JDK 17 or higher
- Maven 3.6.3 or higher
- PostgreSQL
- Postman (for testing the API)

## Getting Started

  ### 1. Clone the Repository
    git clone https://github.com/yourusername/expense-tracker-api.git
    cd expense-tracker-api

  ### 2. Configure Database
    spring.datasource.url=jdbc:postgresql://localhost:5432/expensetracker
    spring.datasource.username=your_db_username
    spring.datasource.password=your_db_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
### 3. Build the project
    mvn clean install

### 4. Run the application
    mvn spring-boot:run
