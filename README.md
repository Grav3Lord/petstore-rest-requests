# Petstore REST Requests

This project is an automated testing suite for the [Swagger Petstore API](https://petstore.swagger.io/).

## Project Overview

The goal of this project is to test the core functionality of the Petstore API, including operations for `Pet`, `Store`, and `User` resources.

### Features
- **Modular Architecture**: API Object model, data models, tests, and utilities.
- **Type-Safe Models**: Uses POJO classes with Jackson for JSON serialization/deserialization.
- **Test Data Generation**: Dynamic test data created with DataFaker.
- **Comprehensive Tests**: Covers CRUD operations.
- **Logging**: Detailed request/response logging via RestAssured.

## Project Structure
```markdown
petstore-rest-requests/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org.petstore/
│   │           ├── api/
│   │           │   ├── PetService.java     # Pet API endpoints
│   │           │   ├── StoreService.java   # Store API endpoints
│   │           │   └── UserService.java    # User API endpoints
│   │           ├── config/
│   │           │   └── Config.java         # RestAssured configuration
│   │           ├── models/
│   │           │   ├── order/
│   │           │   │   ├── OrderStatus.java  # Enum for order status
│   │           │   │   └── Order.java       # Order model
│   │           │   ├── pet/
│   │           │   │   ├── Category.java    # Category model
│   │           │   │   ├── Tag.java         # Tag model
│   │           │   │   └── Pet.java         # Pet model
│   │           │   └── user/
│   │           │       └── User.java        # User model
│   │           └── util/
│   │               └── factory/
│   │                   ├── order/
│   │                   │   └── OrderFactory.java  # Factory for Order data
│   │                   ├── pet/
│   │                   │   └── PetFactory.java   # Factory for Pet data
│   │                   └── user/
│   │                       └── UserFactory.java  # Factory for User data
│   └── test/
│       └── java/
│           ├── pets/
│           │   └── PetsTest.java           # Pet tests
│           ├── store/
│           │   └── StoreTest.java          # Store tests
│           └── users/
│               └── UserTest.java           # User tests
├── pom.xml                                 # Maven configuration
└── README.md                               # This file
```


### Key Components
- **`api`**: Implements API Object Model for endpoint interactions (`PetService`, `StoreService`, `UserService`).
- **`config`**: Sets up RestAssured with base URI, content type, and logging.
- **`models`**: Defines data structures with enums (e.g., `OrderStatus`).
- **`util.factory`**: Provides factories for generating test data (`PetFactory`, `OrderFactory`, `UserFactory`).
- **`test`**: Contains JUnit 5 test cases (`PetsTest`, `StoreTest`, `UserTest`).

## Prerequisites

- **Java**: 17+ (tested with OpenJDK 22.0.1)
- **Maven**: 3.6.0+
- **IDE**: IntelliJ IDEA (optional)

## Dependencies

Managed via Maven (`pom.xml`):
- `io.rest-assured:rest-assured:5.5.1`
- `org.junit.jupiter:junit-jupiter:5.12.0`
- `org.hamcrest:hamcrest:2.2`
- `net.datafaker:datafaker:2.4.2`
- `com.fasterxml.jackson.core:jackson-databind:2.18.3`
- `com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.3`

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/Grav3Lord/petstore-rest-requests.git
cd petstore-rest-requests
```
### Build the Project
```bash
mvn clean install
```

### Run specific tests

```bash
mvn test -Dtest=StoreTest
```
