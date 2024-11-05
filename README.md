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
```bash
curl --location 'http://localhost:8085/api/hosp/search' \
--header 'Authorization: Bearer 6443acd6-69d9-48e7-be24-b82fd502a890'
```

# My Hospital Information System
A Spring Boot application for managing hospital records. This application provides RESTful APIs to create, retrieve, update, and delete hospital records using OAuth2 for authentication.


## Need to create Tables and after running application need to insert data
INSERT INTO D_USER_HDR_TST (USER_ID, LOGIN_ID, USER_NAME, SYSTEM_DATA, AUTH_CODE, USER_TYPE, EMAIL_ID, ROLE_ID, ACTIVE_STATUS, CREATED_BY, CREATED_ON, UPDATE_BY, UPDATE_ON, VERSION_NO, IMAGE_PATH, LAST_LOGIN, MAIL_SENT_TIME, NO_OF_ATTEMPT, AUTH_CODE1, AUTH_CODE2, OTP, MOBILE_NUMBER, AUTH_KEY) 
VALUES (1001, 'emsapi', 'AEMSAPPLICATION', 'Y', '$2a$10$1d3MdW4MIx/Sozq6o.rpN.vc0uynGReu8ALq4CdCjXsOp2cx.v9aW', 21, 'shi@shi.in', 103, 1, 0, 
STR_TO_DATE('05-11-2024', '%d-%m-%Y'), 0, STR_TO_DATE('05-11-2024', '%d-%m-%Y'), 1, NULL, 
STR_TO_DATE('05-11-2024 11:50:54 AM', '%d-%m-%Y %h:%i:%s %p'), 
STR_TO_DATE('05-11-2024 10:26:48 AM', '%d-%m-%Y %h:%i:%s %p'), 0, '70323228393A30382A262B342E', '70323228393A30382A262B342E', '6682', 7509132214, 'E@pi$123');

INSERT INTO D_USER_HDR_TST (USER_ID, LOGIN_ID, USER_NAME, SYSTEM_DATA, AUTH_CODE, USER_TYPE, EMAIL_ID, ROLE_ID, ACTIVE_STATUS, CREATED_BY, CREATED_ON, UPDATE_BY, UPDATE_ON, VERSION_NO, IMAGE_PATH, LAST_LOGIN, MAIL_SENT_TIME, NO_OF_ATTEMPT, AUTH_CODE1, AUTH_CODE2, OTP, MOBILE_NUMBER, AUTH_KEY) 
VALUES (1002, 'galaxy', 'GALAXY', 'Y', '$2a$10$3osrG1AqwdQSbPXomFfuqejW2JBSk6OKJUkEVXXm0KJZ/54MtdfRm', 21, 'shi@shi.in', 1, 1, 0, 
STR_TO_DATE('05-11-2024', '%d-%m-%Y'), 0, STR_TO_DATE('05-11-2024', '%d-%m-%Y'), 1, NULL, 
STR_TO_DATE('05-11-2024 11:50:54 AM', '%d-%m-%Y %h:%i:%s %p'), 
STR_TO_DATE('05-11-2024 10:26:48 AM', '%d-%m-%Y %h:%i:%s %p'), 0, '70323228393A30382A262B342E', '70323228393A30382A262B342E', '6682', 7509132214, 'G@l@xy$123');

Insert into user_roles (USER_ROLE_ID,USERID,ROLE) values (101,1001,'ROLE_ADMIN');
Insert into user_roles (USER_ROLE_ID,USERID,ROLE) values (102,1002,'ROLE_USER');


INSERT INTO oauth_client_details (ID, ACCESS_TOKEN_VALIDITY, ADDITIONAL_INFORMATION, AUTHORITIES, AUTOAPPROVE, CLIENT_ID, CLIENT_SECRET, CREATED, AUTHORIZED_GRANT_TYPES, LAST_UPDATED, REFRESH_TOKEN_VALIDITY, RESOURCE_IDS, SCOPE, WEB_SERVER_REDIRECT_URI, CUSER_NAME) 
VALUES (1001, 3600, NULL, 'ROLE_USER', 'true', 'AEMS APPLICATION', '$2a$10$CkNGm6Va0j5qUgdg0JUQfOqVg4mjhxFqsIlJsZQYfIBitlIAULsXe', 
STR_TO_DATE('05-11-2024', '%d-%m-%Y'), 'password,authorization_code,refresh_token,client_credentials', NULL, 60, NULL, 'foo,read,write', NULL, 'ems@starHealth123');

INSERT INTO oauth_client_details (ID, ACCESS_TOKEN_VALIDITY, ADDITIONAL_INFORMATION, AUTHORITIES, AUTOAPPROVE, CLIENT_ID, CLIENT_SECRET, CREATED, AUTHORIZED_GRANT_TYPES, LAST_UPDATED, REFRESH_TOKEN_VALIDITY, RESOURCE_IDS, SCOPE, WEB_SERVER_REDIRECT_URI, CUSER_NAME) 
VALUES (1002, 60, NULL, 'ROLE_USER', 'true', 'Galaxy', '$2a$10$nnMkNSJaDJulCRwotGcUX.9DW/scXSrRFQDDsUp2WpODJY3nJb.yq', 
STR_TO_DATE('05-11-2024', '%d-%m-%Y'), 'password,authorization_code,refresh_token,client_credentials', NULL, 60, NULL, 'foo,read,write', NULL, 'ems@Galaxy123');

CREATE TABLE OAUTH_ACCESS_TOKEN 
   (	
    TOKEN_ID VARCHAR(255), 
    TOKEN BLOB, 
    AUTHENTICATION_ID VARCHAR(255), 
    USER_NAME VARCHAR(255), 
    CLIENT_ID VARCHAR(255), 
    AUTHENTICATION BLOB, 
    REFRESH_TOKEN VARCHAR(255), 
    PRIMARY KEY (AUTHENTICATION_ID)
   );
commit;
CREATE TABLE OAUTH_APPROVALS 
   (	
    USERID VARCHAR(255), 
    CLIENTID VARCHAR(255), 
    SCOPE VARCHAR(255), 
    STATUS VARCHAR(10), 
    EXPIRESAT TIMESTAMP, 
    LASTMODIFIEDAT TIMESTAMP
   );
commit;

CREATE TABLE OAUTH_CLIENT_TOKEN 
   (	
    TOKEN_ID VARCHAR(255), 
    TOKEN BLOB, 
    AUTHENTICATION_ID VARCHAR(255), 
    USER_NAME VARCHAR(255), 
    CLIENT_ID VARCHAR(255), 
    PRIMARY KEY (AUTHENTICATION_ID)
   );
commit;

CREATE TABLE OAUTH_CODE 
   (	
    CODE VARCHAR(255), 
    AUTHENTICATION BLOB
   );
commit;

CREATE TABLE OAUTH_REFRESH_TOKEN 
   (	
    TOKEN_ID VARCHAR(255), 
    TOKEN BLOB, 
    AUTHENTICATION BLOB
   );
commit;






