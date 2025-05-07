# Fleet GPS Backend Project

This is a Spring Boot based application for managing a fleet of vehicles. It tracks GPS locations and logs, and provides a RESTful API for interaction with vehicles and their respective GPS logs.

## Features

- Vehicle Management: Add, update, and get details of vehicles.
- GPS Log Management: Track and view GPS logs for each vehicle, including last known location and history of movements.
- API Documentation: Integrated Swagger UI for easy access to the API documentation.

## Technologies Used

- **Spring Boot**: Backend framework for building RESTful APIs.
- **Spring Security**: For securing endpoints.
- **JPA**: For database persistence with Hibernate.
- **PostgreSQL**: Database for storing vehicle and GPS logs data.
- **Swagger/OpenAPI**: API documentation and testing.
- **Maven**: Project management and build automation.
- **Java 17**: The application is built using Java 17.

## API Endpoints

### 1. **Vehicle Endpoints**
- `POST /api/vehicles` - Create a new vehicle.
- `GET /api/vehicles/{id}` - Get details of a specific vehicle by ID.
- `GET /api/vehicles/{id}/last-location` - Get the last known GPS location of a vehicle.
- `GET /api/vehicles/{id}/history` - Get the history of GPS logs for a vehicle in a specific date range.

## Running the Project Locally

### Prerequisites
- **Java 17** (for compiling and running the application)
- **Maven** (for building the project)
- **PostgreSQL Database** (or any other database you prefer)

### Steps to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Hann6/FleetGPS.git
