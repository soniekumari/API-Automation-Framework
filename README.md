# API Automation Framework

A robust REST API Automation Framework built using Java, Rest Assured, TestNG, Maven, and Extent Reports for validating CRUD operations on Swagger Petstore APIs.

---

# Project Overview

This framework is designed to automate API testing for different modules such as:

- User APIs
- Pet APIs
- Store APIs

The framework follows a structured and scalable design using:

- Endpoint classes
- Payload POJOs
- Test classes
- Reporting utilities
- Logging mechanism

It supports end-to-end API validation including:

- Create API Requests
- Read API Requests
- Update API Requests
- Delete API Requests
- Response Validation
- Status Code Validation
- Logging & Reporting

---

# Tech Stack

| Technology | Usage |
|---|---|
| Java | Programming Language |
| Rest Assured | API Automation |
| TestNG | Test Execution Framework |
| Maven | Build Management |
| Log4j | Logging |
| Extent Reports | HTML Reporting |
| Java Faker | Dynamic Test Data |
| JSON | Payload Handling |

---

# Project Structure

```bash
APIAutomationFramework
│
├── src/main/java
│   ├── api/endpoints
│   │   ├── UserEndPoints.java
│   │   ├── PetEndPoints.java
│   │   ├── StoreEndPoints.java
│   │   └── Routes.java
│   │
│   ├── api/payload
│   │   ├── User.java
│   │   ├── Pet.java
│   │   ├── Store.java
│   │   ├── Category.java
│   │   └── Tag.java
│   │
│   └── api/utilities
│        └── ExtendReportManager.java
├── src/test/java
│   └── api/test
│        ├── UserTest.java
│        ├── PetTest.java
│        └── StoreTest.java
│
├── reports
├── logs
├── test-output
├── pom.xml
└── testng.xml
```

---

# Features Implemented

## User API Automation

- Create User
- Get User Details
- Update User
- Delete User

## Pet API Automation

- Create Pet
- Get Pet Details
- Update Pet
- Delete Pet

## Store API Automation

- Create Order
- Get Order Details
- Delete Order

---

# Framework Highlights

## Modular Design

Endpoints, payloads, utilities, and test classes are separated for better maintainability.

## Dynamic Test Data

Used Java Faker library for generating random and realistic test data.

## Logging Support

Integrated Log4j for detailed execution logs.

## Reporting

Integrated Extent Reports for HTML execution reports.

## Scalable Architecture

Easy to add new APIs, modules, and validations.

---

# How to Run the Project

## Clone Repository

```bash
git clone <repository-url>
```

## Import Project

Import the project as a Maven Project in Eclipse or IntelliJ IDEA.

## Install Dependencies

```bash
mvn clean install
```

## Run Test Suite

```bash
mvn test
```

Or run directly using:

```bash
testng.xml
```

---

# Reporting

After execution:

- Extent Reports will be generated
- TestNG Reports will be available inside:

```bash
/test-output
```

---

# Sample Validations

- HTTP Status Code Validation
- Response Body Validation
- CRUD Operation Verification
- API Response Logging

---

# APIs Used

Swagger Petstore APIs:

```bash
https://petstore.swagger.io/
```

---

# Conclusion

This project demonstrates practical implementation of REST API automation using Java, Rest Assured, TestNG, and Maven. It focuses on clean architecture, reusability, maintainability, and scalable API testing practices.
