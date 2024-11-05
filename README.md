# MyHospInfo Spring Boot Application

This project is a Spring Boot-based RESTful API for managing hospital information, including creating, updating, searching, and deleting hospital records. It uses OAuth2 for security and integrates MySQL for data storage.

## Table of Contents
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Usage](#api-usage)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)

## Getting Started

This application manages hospital records by providing a set of RESTful APIs. Follow the instructions below to set up and run the application locally.

### Prerequisites
- **Java 17**: Ensure Java 17 is installed and `JAVA_HOME` is set.
- **Maven**: For dependency management and building the project.
- **MySQL**: Ensure a MySQL instance is running with a database prepared for this app.
- **Git**: For cloning the repository.

### Installation

**Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/myHospInfo_springBoot.git
   ```

## API Documentation

Swagger UI is available for API documentation at:

[Swagger UI](http://localhost:8085/swagger-ui.html)

## API Usage

### Authentication

This application uses OAuth2 for authentication. To generate an access token, use the following curl command:

```bash
curl --location 'http://localhost:8085/oauth/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Authorization: Basic QUVNUyBBUFBMSUNBVElPTjplbXNAc3RhckhlYWx0aDEyMw==' \
--data-urlencode 'password=E@pi$123' \
--data-urlencode 'username=emsapi' \
--data-urlencode 'grant_type=password'
```
## Search Hospitals:
```curl --location 'http://localhost:8085/api/hosp/search' \
--header 'Authorization: Bearer 6443acd6-69d9-48e7-be24-b82fd502a890'
```

# My Hospital Information System
A Spring Boot application for managing hospital records. This application provides RESTful APIs to create, retrieve, update, and delete hospital records using OAuth2 for authentication.





