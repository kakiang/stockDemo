# stockDemo

A demo project for managing stock data, built with Spring Boot.

## Features

- Spring Boot REST API
- Spring Data JPA for database access
- MySQL and H2 support
- Lombok for reduced boilerplate code
- Maven build system

## Getting Started

### Prerequisites

- Java 21+
- Maven 3.6+
- MySQL (if not using H2 for testing)

### Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/kakiang/stockDemo.git
   cd stockDemo
   ```

2. **Configure Database:**

   - For MySQL:
     Edit `src/main/resources/application.properties` to set your MySQL credentials.
   - For H2 (default for development/testing):
     No configuration needed.

3. **Build and Run:**
   ```bash
   ./mvnw spring-boot:run
   ```

   Or to build:
   ```bash
   ./mvnw clean package
   java -jar target/stockDemo-0.0.1-SNAPSHOT.jar
   ```

## Project Structure

- `src/main/java` - Application source code.
- `src/main/resources` - Configuration files (e.g., `application.properties`).
- `pom.xml` - Maven dependencies and plugins.

## Dependencies

- `spring-boot-starter-web` - REST API support
- `spring-boot-starter-data-jpa` - JPA and database support
- `mysql-connector-j` - MySQL driver (runtime)
- `h2` - In-memory H2 database (runtime)
- `lombok` - Reduces boilerplate code
- `spring-boot-devtools` - Hot reloading for development
- `spring-boot-starter-test` - Testing support

## API Endpoints
> - `GET /api/produits` - List all categories

## License

This project is for demo purposes.

