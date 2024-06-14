# Medical Clinic System

PRECONDITION: If the user wants to execute the program, it is necessary to configure the database first. For this, I exported an SQL file
with all the tables and data originally created from my PostgreSQL software. That file is located inside "psql_database_backup" folder inside the project directory.
Load it inside any SQL database software, and then complete the "application.properties" file with your database credentials.
  
This Spring application was made as a way to manage a Medical Clinic system, in wich the user can create information about clients, doctors, departments in the clinic,
specializations and appointments, and visualize it through HTML pages. Appointments need a client, a doctor, a date and a time in order to be created and saved.
By default, I also created two users for Spring Security: a standard user with USER role, and an admin with both USER and ADMIN roles. Creation of new users is not
available inside the program at the moment.
Users have the freedom to create instances of Client, Doctor and Appointment, save them to the database and visualize the respective tables. Meanwhile, the administrators
have the addition of managing the departments and specializations in the clinic (this means that common users have no access to this information).
Since this application shares funcionalities from previous projects of mine, a lot of the code of this project was reused from my other program, the "Student Management System".
The program includes i18n with two languages, english (default) and spanish.

- JDK version: 21
- Spring Framework version: 3.2.4

UPDATE 2.0 (June 13, 2024)
The application has been updated to include Bootstrap 5.3.3
Key features include:
- Enhanced UI components.
- Predefined styling classes for forms, buttons, and other UI components.
- Responsive design.
- Pages have been separated in sections through layout pages ('src/main/java/resources/templates/layout'), and then loaded with Thymeleaf fragments.

IMPORTANT: Right now, there is a problem in which the Bootstrap styles (sometimes) don't load in the login page. This happens in two parts of
the application: the first time the server is up, and after a session timeout. Still working on a solution.

![msedge_NsuoR1UETk](https://github.com/nicolasPalomares/MedicalClinic-System/assets/106792719/8fd0a9fe-3164-406b-afa3-b96189fcba06)
