# Medical Clinic Management System

PRECONDITION: If the user wants to execute the program, it is necessary to configure the database first. For this, I exported an SQL file
with all the tables and data originally created from my PostgreSQL software. That file is located inside "psql_database_backup" folder inside the project directory.
Load it inside any SQL database software, and then complete the "application.properties" file with your database credentials.
  
This Spring application is designed to manage a medical clinic's operations. Users can create and manage information about clients, doctors, departments, specializations, and appointments, all viewable through user-friendly HTML pages.

## Key Features

- Appointments Management: Create and save appointments with details including client, doctor, date, and time.
- User Roles and Permissions:
-- Standard User: Can create, save, and view clients, doctors, and appointments.
Administrator: Has additional privileges to manage clinic departments and specializations.
Default Users:
Standard user with USER role.
Admin with both USER and ADMIN roles.
Data Management: Users and administrators can create instances of clients, doctors, and appointments, and save them to the database. Administrators have exclusive access to manage departments and specializations.
Internationalization (i18n): Supports English (default) and Spanish.
Code Reusability: Reuses code from the "Student Management System" project, ensuring efficiency and consistency.

June 13, 2024:

The application has been updated to include Bootstrap 5.3.3
Key features include:
- Enhanced UI components.
- Predefined styling classes for forms, buttons, and other UI components.
- Responsive design.
- Pages have been separated in sections through layout pages ('src/main/java/resources/templates/layout'), and then loaded with Thymeleaf fragments.

IMPORTANT: Right now, there is a problem in which the Bootstrap styles (sometimes) don't load in the login page. This happens in two parts of
the application: the first time the server is up, and after a session timeout. Still working on a solution.

Screenshots:

![msedge_NsuoR1UETk](https://github.com/nicolasPalomares/MedicalClinic-System/assets/106792719/8fd0a9fe-3164-406b-afa3-b96189fcba06)
![msedge_2LJ3uPpe8Y](https://github.com/nicolasPalomares/MedicalClinic-System/assets/106792719/0e36bee1-2846-4814-a489-ac4a9daf3b1e)
![msedge_wdDNeNLmOE](https://github.com/nicolasPalomares/MedicalClinic-System/assets/106792719/5b8506dc-7945-45f8-8404-26eb008b009d)
![msedge_JMNi5Yy7zM](https://github.com/nicolasPalomares/MedicalClinic-System/assets/106792719/74b346e0-7105-40d3-b617-5162f4fd81e7)
![msedge_16yKpGosHl](https://github.com/nicolasPalomares/MedicalClinic-System/assets/106792719/48a48a73-dc55-4fbf-8fe4-00fa5ad29d2b)

-JDK 21 & Spring Framework 3.2.4-
