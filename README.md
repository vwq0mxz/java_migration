# Java CRUD Operations Demo

This project demonstrates a simple CRUD (Create, Read, Update, Delete) operations implementation using Java 8 and H2 in-memory database.

## Project Structure

```
src/
├── main/java/com/example/
│   ├── model/
│   │   └── User.java
│   └── dao/
│       ├── UserDAO.java
│       └── UserDAOImpl.java
└── test/java/com/example/
    └── dao/
        └── UserDAOImplTest.java
```

## Features

- CRUD operations for User entity
- In-memory H2 database
- JUnit tests for all operations
- Java 8 compatible

## Requirements

- JDK 1.8 or higher
- Maven 3.x

## Building the Project

```bash
mvn clean install
```

## Running Tests

```bash
mvn test
```

## Usage Example

```java
// Create a new UserDAO instance
UserDAO userDAO = new UserDAOImpl();

// Create a new user
User user = new User(null, "John Doe", "john@example.com");
User created = userDAO.create(user);

// Read a user
User read = userDAO.read(created.getId());

// Update a user
user.setName("Jane Doe");
User updated = userDAO.update(user);

// Delete a user
boolean deleted = userDAO.delete(user.getId());
```

## Implementation Details

- Uses JDBC for database operations
- H2 in-memory database for data storage
- DAO pattern for data access abstraction
- Complete test coverage for all CRUD operations
