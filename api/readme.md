# 🐾 ChicoHub API – Intelligent Management for Pet Shops

This REST API is the core of the **ChicoHub** ecosystem, designed to provide a robust management solution for pet shops. The project has evolved from a local management tool to a modern architecture based on **Containers** and **Federated Security**.

## 🚀 Technical Highlights

* **Google OAuth2 Security:** Implementation of social authentication that protects pet data, ensuring each owner accesses only their own information.
* **Infrastructure as Code (IaC):** Fully containerized project, allowing for identical deployment and execution in any environment via **Docker Compose**.
* **Data Isolation (Privacy by Design):** Use of authenticated email to filter database records, ensuring total privacy between users.
* **BrasilAPI Integration:** Automated store registration via CNPJ lookup, reducing manual entry errors and setup time.
* **Complex Relational Architecture:** Chain links (Store -> Client -> Pet -> Service) ensuring full data traceability.

## 🛠️ Technologies & Tools

* **Language:** Java 17
* **Framework:** Spring Boot 3.x
* **Security:** Spring Security & OAuth2 (Google Login)
* **DevOps:** Docker & Docker Compose
* **ORM:** Spring Data JPA / Hibernate
* **Database:** MySQL
* **Testing:** Postman

## 🏗️ Project Structure

The project follows a layered pattern for separation of concerns:
* **`controller`**: Manages protected REST endpoints and HTTP requests.
* **`domain`**: Contains business entities and complex JPA mapping.
* **`repository`**: Custom query interfaces with owner-based isolation filters.
* **`config`**: Security and infrastructure configurations (CORS, OAuth2, Docker).

## 📈 Development Journey (Sprints)

### Sprints 1 to 5: Base & Business Rules
* Setup of the Store, Client, Pet, and Service ecosystem.
* BrasilAPI integration and relational database persistence.

### Sprint 6: Security & Identity
* Spring Security implementation with Google OAuth2 integration.
* Creation of the `/meus-pets` endpoint with automatic filtering by `donoEmail`.

### Sprint 7: Infrastructure & DevOps
* Creation of an optimized **Dockerfile** for the Java application.
* Orchestration with **Docker Compose** for automated container and environment variable management.

## 🚥 How to Run (via Docker)

This is the recommended method to ensure the application runs with all dependencies properly configured.

1. **Clone the repository.**
2. **Configure your Google credentials** in the Linux terminal:
   ```bash
   export GOOGLE_CLIENT_ID=your_id
   export GOOGLE_CLIENT_SECRET=your_secret


##Build the project:

./mvnw clean package -DskipTests

##Launch the container:

docker compose up -d

##Access in the browser: http://localhost:8080/api/pets/meus-pets

