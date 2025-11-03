# School Management System

## 📝 Description
A robust Spring Boot application for managing students and disciplines in educational institutions. The system is built with a layered architecture, using DTOs for data transfer, JPA for persistence, and includes comprehensive validation and exception handling. It supports full CRUD operations for both students and disciplines, as well as student enrollment in disciplines.

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/com/jpdevv/schoolsys/
│   │   ├── SchoolSystemApplication.java         # Main Spring Boot application class
│   │   ├── business/
│   │   │   ├── dto/
│   │   │   │   ├── DisciplineDTO.java          # DTO for discipline data transfer
│   │   │   │   └── StudentDTO.java             # DTO for student data transfer
│   │   │   └── services/
│   │   │       ├── ConverterService.java       # Converts between DTOs and entities
│   │   │       ├── DisciplineService.java      # Business logic for disciplines
│   │   │       ├── ExceptionsService.java      # Centralized exception handling
│   │   │       └── StudentService.java         # Business logic for students
│   │   ├── model/
│   │   │   ├── entities/
│   │   │   │   ├── Discipline.java             # JPA entity for disciplines
│   │   │   │   └── Student.java                # JPA entity for students
│   │   │   └── repositories/
│   │   │       ├── DisciplineRepository.java   # Repository for discipline persistence
│   │   │       └── StudentRepository.java      # Repository for student persistence
│   │   └── presentation/
│   │       └── controller/
│   │           ├── DisciplineController.java   # REST endpoints for disciplines
│   │           └── StudentController.java      # REST endpoints for students
├── resources/
│   ├── application.properties                  # Spring Boot configuration
│   ├── static/
│   │   └── .gitkeep                            # Placeholder for static files (e.g., CSS)
│   └── templates/
│       └── .gitkeep                            # Placeholder for Thymeleaf templates
├── test/
│   └── java/com/jpdev/school_system/
│       └── SchoolSystemApplicationTests.java   # Unit tests for the application
```

## 🚀 Features

### Student Management
- Create, read, update, and delete student records
- Validate registration number format (`YYYY###`)
- Ensure email uniqueness and proper format
- Track address and contact information
- Manage student status

### Discipline Management
- Create, read, update, and delete disciplines
- Validate unique discipline code (`ABC###`)
- Manage and validate workload (30-120 hours)
- Handle course prerequisites
- Track academic periods

### Enrollment
- Enroll students in disciplines
- Unenroll students from disciplines

## 🛠️ Technologies Used

- **Java 21** (LTS)
- **Spring Boot 3.5.x**
  - Spring Web MVC
  - Spring Data JPA
  - Spring Validation
- **PostgreSQL 15**
- **Maven 3.9**
- **Lombok 1.18**
- **JUnit 5 & Mockito**

## ⚙️ How to Run

### Prerequisites
- JDK 21
- PostgreSQL 15+
- Maven 3.9+
- Git

### Steps to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/jpdevv/school-system-spring.git
   cd school-system-spring
   ```

2. **Configure the database in `application.properties`:**
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/schoolsystem
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. **Build and run the application:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## 📱 API Endpoints

### Students
- `GET /api/students` — Retrieve all students
- `POST /api/students` — Create a new student
- `PUT /api/students/{id}` — Update an existing student
- `DELETE /api/students/{id}` — Delete a student

### Disciplines
- `GET /api/disciplines` — Retrieve all disciplines
- `POST /api/disciplines` — Create a new discipline
- `PUT /api/disciplines` — Update an existing discipline
- `DELETE /api/disciplines/{code}` — Delete a discipline

### Enrollment
- `POST /api/disciplines/enroll?code={code}&registration={registration}` — Enroll a student in a discipline
- `DELETE /api/disciplines/unenroll?code={code}&registration={registration}` — Unenroll a student from a discipline

## 🏗️ Architecture

- **Presentation Layer:** REST controllers for handling HTTP requests and responses, input validation
- **Business Layer:** Services implementing business logic, validation, and transaction management
- **Data Layer:** JPA repositories for database operations, entity management
- **DTOs:** Used for transferring data between layers
- **Exception Handling:** Centralized service for managing application errors

## 🔍 Validations

### Student Validations
- Registration number: must follow the `YYYY###` pattern (e.g., 2023001)
- Email: must be valid and unique
- Required fields: name, email, registration

### Discipline Validations
- Code: must follow the `ABC###` pattern (e.g., MAT101)
- Workload: must be between 30 and 120 hours
- Required fields: code, name, workload

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/NewFeature`)
3. Commit your changes (`git commit -m 'Add NewFeature'`)
4. Push to the branch (`git push origin feature/NewFeature`)
5. Open a Pull Request

## 📫 Contact

- Email: joaoaraujo.developer@gmail.com
- GitHub: [@jpincode](https://github.com/jpincode)

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

