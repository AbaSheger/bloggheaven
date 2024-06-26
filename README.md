# Bloggheaven Application Documentation

## Overview
Bloggheaven is a Spring Boot application designed for blogging, featuring authentication and authorization managed by Keycloak.

## Structure
The application is organized into several components:
- Entities: `Post`, `User`, `Address`
- Repositories: `PostRepository`, `UserRepository`, `AddressRepository`
- Services: `PostService`, `UserService`, `AddressService`
- Controllers: `PostController`, `UserController`
- Security: `JwtAuthConverter` for JWT token conversion and `SecurityConfig` for security configurations

## Security
The application employs JWT for securing API endpoints and integrates with Keycloak for identity and access management. JWT tokens are used to authenticate users and authorize their access to specific resources within the application.

## Configuration
Configuration settings are specified in the `application.properties` file, which includes details for database connections, server ports, and security configurations.

## Data Initialization
The `data.sql` file is used to initialize the database with sample data, ensuring the application has the necessary data to function correctly.

## Running the Application
To run the application, execute the `BloggheavenApplication` class. This will start the Spring Boot application.

### Steps to Run:
1. Ensure Keycloak is configured and running.
2. Configure the `application.properties` file with the correct Keycloak and database settings.
3. Execute the `BloggheavenApplication` class from your IDE or command line.

## Conclusion
The Bloggheaven application demonstrates the integration of Spring Boot with Keycloak for robust authentication and authorization. Proper configuration of the application.properties file and careful management of database initialization are critical for seamless operation. By following this documentation, users can set up and run the application effectively.