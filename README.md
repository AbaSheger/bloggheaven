# Bloggheaven Application Documentation

## Overview
Bloggheaven is a Spring Boot application for blogging, secured with Keycloak for authentication and authorization.

## Structure
The application is divided into entities (`Post`, `User`, `Address`), repositories (`PostRepository`, `UserRepository`, `AddressRepository`), services (`PostService`, `UserService`, `AddressService`), and controllers (`PostController`, `UserController`). It also includes a `JwtAuthConverter` for JWT token conversion and a `SecurityConfig` for security settings.

## Security
The application uses JWT for authentication and Keycloak for Identity and Access Management.

## Configuration
Configuration settings are in the `application.properties` file.

## Data Initialization
The `data.sql` file initializes the database with sample data.

## Running the Application
The application is started from the `BloggheavenApplication` class.