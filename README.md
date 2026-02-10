# School Management System

## Overview
This project is a JavaFX-based School Management System built as part of the Object Oriented Programming course (CSC-241) at COMSATS University Islamabad, Lahore Campus. It provides a desktop interface for administrators to manage students, teachers, staff, and financial summaries using a MySQL database backend.

## Objectives
- Centralize academic and administrative records.
- Provide fast, reliable CRUD operations for people records.
- Offer a clear, menu-driven JavaFX UI for non-technical users.
- Enable basic financial reporting (salary and fee analysis).

## Tech Stack
- **Language:** Java
- **UI:** JavaFX
- **Build:** Maven
- **Database:** MySQL

## Key Features
- **Admin authentication** to access management modules.
- **Student management** (add, update, remove, view all).
- **Teacher management** (add, update, remove, view all).
- **Staff management** (add, update, remove, view all).
- **Financial analysis** for fee and salary summaries.
- **MySQL persistence** for reliable data storage.

## Project Structure
- [src/main/java/com/danish/sms](src/main/java/com/danish/sms)
  - `Main` entry point and JavaFX bootstrap
  - UI pages (e.g., `LoginPage`, `AdminMenu`, `StudentManagementMenu`, `TeacherManagementMenu`, `StaffManagementMenu`)
  - Data models: `Person`, `Student`, `Teacher`, `Staff`
  - Database utilities: `LoadDataFromMySQL`, `SaveDataToMySQL`, `UpdateDataInMySQL`, `RemoveDataFromMySQL`, `GetDataByIdFromMySQL`
- [src/main/resources](src/main/resources) for app resources

## Prerequisites
- **JDK 17+** installed and configured.
- **Maven** (or use the provided wrapper: `mvnw` / `mvnw.cmd`).
- **MySQL Server** running locally or remotely.
- JavaFX dependencies handled through Maven.

## Database Setup
1. Create a MySQL database (e.g., `school_management`).
2. Create the required tables for students, teachers, and staff.
3. Update the DB connection configuration in the database utility classes under [src/main/java/com/danish/sms](src/main/java/com/danish/sms).

> If you already have a schema, update the table names and columns in the SQL queries inside the `*MySQL` utility classes to match your schema.

## Build and Run
### Using Maven Wrapper (Windows)
1. Open a terminal at the project root.
2. Run:
	- `mvnw.cmd clean install`
	- `mvnw.cmd javafx:run`

### Using Maven (macOS/Linux)
1. Open a terminal at the project root.
2. Run:
	- `./mvnw clean install`
	- `./mvnw javafx:run`

## How to Use
1. Launch the application.
2. Log in as an admin.
3. Use the management menus to add, update, remove, or view records.
4. Navigate to the Financial Analysis page for summary calculations.

## Known Limitations
- Admin-only access (no separate student/teacher portals yet).
- Basic reporting (advanced analytics not implemented).

## Future Enhancements
- Dedicated portals for students and teachers.
- Role-based access control with stronger authentication.
- Exportable reports (PDF/CSV).
- Attendance and grading modules.

## Contributors
- **Muhammad Danish** (FA23-BSE-105)

## Instructor
- **Mr. Muhammad Shahid Bhatti**
