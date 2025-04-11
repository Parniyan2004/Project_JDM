## Digital CMAS Monitoring System (JDMTracker)

A Java-based CLI application to support children diagnosed with Juvenile Dermatomyositis (JDM).  
The system enables patients or caregivers to enter CMAS test results at home and allows doctors to securely log in, view results, and track disease progression.

## Features

- Add new patient profiles with name and birth date
- Record CMAS test results (date + score)
- Doctors can securely log in using email and password
- View a patient’s full test history by ID
- All data is stored in a local SQLite database

## Background

Juvenile Dermatomyositis (JDM) is a rare autoimmune disease affecting children, leading to muscle weakness and fatigue.  
The CMAS (Childhood Myositis Assessment Scale) is a physical test to track disease progression.
This project provides a digital alternative to paper-based CMAS assessments by enabling remote data entry and centralized access for doctors.

##  Project Structure

Here is the folder structure for the project:

JDMTracker

├── src/                             Java source code (Main, AddPatient, DoctorLogin, etc.)

├── bin/                             Compiled .class files

├── database/                        SQLite database file (cmas_data.db)

├── lib/                             SQLite JDBC driver (sqlite-jdbc-3.49.1.0.jar)

├── Report_Project.pdf                    Final project report (this explains methodology, results, testing)

├── README.md                        This file


## Technologies Used

- Java (with modular CLI structure)
- SQLite (local database)
- JDBC (database connection)
- Visual Studio Code
- IntelliJ IDEA Community
- draw.io (UML diagrams)
- DB Browser for SQLite (data inspection)

## Dataset

The dataset used in this project (`PatientX`) includes:
- Patient records
- CMAS scores (over time)
- [Optionally extendable] Lab measurement files for biomarkers

> Note: The current version integrates only the Patient and TestResult datasets from PatientX. Additional files such as LabResult.csv and Measurement.csv are provided for future integration of biomarker tracking.

## How to Run

1. Clone the repository:
git clone https://github.com/Parniyan2004/Project_JDM.git

3. Compile the Java code:
javac -cp “.;lib/sqlite-jdbc-3.49.1.0.jar” src/*.java

4. Run the application:
java -cp “.;lib/sqlite-jdbc-3.49.1.0.jar;src” Main
> Make sure sqlite-jdbc is present in the lib/ folder and your terminal is inside the project directory.

## UML & Database Design

The system includes:
- UML class diagram showing the main classes and relationships
- SQLite schema with 3 tables:
- Patient(id, name, birth_date)
- Doctor(id, name, email, password)
- TestResult(id, patient_id, date, score)
(See Report_Project.pdf or `design/uml.png`)

## Contributor

- Zahra Amiri  

## License & Notes

This project was developed as an individual submission for the “Introduction to Software Engineering” course at ZUYD University (ADSAI).





