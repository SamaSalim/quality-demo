# Robust Bank System - QA & Core Backend Showcase

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-Testing-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Mockito](https://img.shields.io/badge/Mockito-Mocking-78A22F?style=for-the-badge)
![CI/CD](https://img.shields.io/badge/GitHub_Actions-CI%2FCD-2088FF?style=for-the-badge&logo=github-actions&logoColor=white)

An enterprise-grade demonstration of Backend Architecture, Clean Code, and rigorous Quality Assurance (QA) practices. 

## Architectural Highlights
* **Dependency Injection (DI):** Decoupled `BankService` and `TransactionLogger` to ensure high testability and adhere to SOLID principles.
* **Defensive Programming:** Strict domain validation and exception handling within the `BankAccount` entity.
* **Continuous Integration:** Fully automated GitHub Actions workflow enforcing build stability and code coverage gates.

## Quality Assurance & Testing Strategy
This project demonstrates advanced testing methodologies to ensure zero defect leakage:
1. **Unit Testing:** Comprehensive test coverage using **JUnit 5**.
2. **Parameterized Testing:** Boundary Value Analysis (BVA) testing edge cases on deposits and withdrawals.
3. **Mocking Strategies:** Used **Mockito** to isolate domain logic from external dependencies (Loggers/Databases).
4. **Code Coverage Gates:** Integrated **JaCoCo** with a strict `>= 80%` instruction coverage rule enforced at the build phase.

## Getting Started

### Run Tests and Generate Coverage Report
```bash
mvn clean test jacoco:report