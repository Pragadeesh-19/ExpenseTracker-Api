# Expense Tracker Api Backend

## Overview

This is a RESTful API for an expense tracker application built with Spring Boot. This application uses Java, Spring Boot, Spring Security (with JWT authentication), PostgreSQL, and Spring data JPA for data persistence. The API allows users to manage their expenses, including adding, updating, and deleting expenses, as well as listing and filtering them based on various criteria.


## Features
- **User Registration**: Sign up as a new user.
- **JWT Authentication**: Generate and validate JWT tokens for user authentication and session management.
- **Expense Management**:
  - List all expenses with filtering options:
  - Add new expenses
  - Remove existing expenses
  - Update existing expenses

## Technologies

- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework for building the RESTful API.
- **Spring Security**: Provides security and JWT-based authentication.
- **PostgreSQL**: Database for data storage.
- **JPA**: Java Persistence API for database operations.
- **Postman**: Tool used for API testing.

## Getting Started

### Prerequisites

- Java 22
- Maven
- PostgreSQL
- Postman

### Installation

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/Pragadeesh-19/ExpenseTracker-Api.git
    cd Expensetracker-Api
    ```

2. **Configure the Database:**

    Create a PostgreSQL database and update the `application.properties` file with your database credentials:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/expenseTracker
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```

3. **Build and Run the Application:**

    Using Maven:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### API Endpoints

### User Authentication

- **Register New User**
  - `POST /register`
  - Request Body: `User` object

- **Login**
  - `POST /login`
  - Request Body: `User` object
  - Response: JWT token in `JwtResponse`

### Expense Management

- **Add Expense**
  - `POST /api/expenses`
  - Request Body: `Expense` object
  - Authenticated Request

- **Get Expenses**
  - `GET /api/expenses`
  - Query Parameters:
    - `category` (optional)
    - `startDate` (optional, format: YYYY-MM-DD)
    - `endDate` (optional, format: YYYY-MM-DD)
  - Authenticated Request

- **Update Expense**
  - `PUT /api/expenses/{id}`
  - Request Body: `Expense` object
  - Path Variable: `id` of the expense to update
  - Authenticated Request

- **Delete Expense**
  - `DELETE /api/expenses/{id}`
  - Path Variable: `id` of the expense to delete
  - Authenticated Request


### Testing

Use Postman to test the API endpoints.

### Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes or enhancements.

