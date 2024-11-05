MyHospInfo Spring Boot Application
This Spring Boot application provides a hospital information management system, offering RESTful endpoints for creating, updating, searching, and deleting hospital records. The application uses Spring Boot, Spring Security with OAuth2, MySQL, and Swagger for API documentation.

Table of Contents
Prerequisites
Installation
Running the Application
API Endpoints
Project Structure
Prerequisites
Java 17
Maven
MySQL (running with a database created for this application)
A GitHub account (for cloning the repository if necessary)
Installation
Clone the repository:
bash
Copy code
git clone https://github.com/yourusername/myHospInfo_springBoot.git
Navigate to the project directory:
bash
Copy code
cd myHospInfo_springBoot
Configure the MySQL database:
Open application.properties or application.yml.
Update the following properties with your MySQL credentials:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_user
spring.datasource.password=your_database_password
Install project dependencies:
bash
Copy code
mvn clean install
Running the Application
Start the application:
bash
Copy code
mvn spring-boot:run
Swagger API documentation is available at:
bash
Copy code
http://localhost:8085/swagger-ui.html
Authentication
This project uses OAuth2 authentication. To get an access token, use the following curl command:

bash
Copy code
curl --location 'http://localhost:8085/oauth/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Authorization: Basic QUVNUyBBUFBMSUNBVElPTjplbXNAc3RhckhlYWx0aDEyMw==' \
--data-urlencode 'password=E@pi$123' \
--data-urlencode 'username=emsapi' \
--data-urlencode 'grant_type=password'
Use the token from this request in the Authorization header for other API calls.

API Endpoints
Method	Endpoint	Description
POST	/api/hosp/create	Create a new hospital record
GET	/api/hosp/search	Retrieve all hospital records
GET	/api/hosp/search/{status}	Retrieve hospitals by status
GET	/api/hosp/{HospId}	Retrieve a hospital by its ID
PUT	/api/hosp/update/{hospId}	Update a hospital record
DELETE	/api/hosp/delete/{id}	Delete a hospital by its ID
Example Usage
Search Hospitals:
bash
Copy code
curl --location 'http://localhost:8085/api/hosp/search' \
--header 'Authorization: Bearer <access_token>'
Project Structure
Controller (HospController): Defines the API endpoints.
Service (HospService and HospServiceImpl): Contains the business logic.
Repository (HospRepo): Provides data access using Spring Data JPA.
Exception (HospInfoException): Custom exception handling.
Utils (HospCodeGenerator): Helper class for generating unique hospital codes.
Security: Configured with OAuth2 authentication using spring-security-oauth2 dependency.
Dependencies
Spring Boot (Web, Data JPA, Security)
MySQL Connector (JDBC for MySQL)
Springfox Swagger (API Documentation)
OAuth2 Security (For token-based authentication)
Log4j2 (For application logging)
License
This project is licensed under the MIT License. See the LICENSE file for details.
