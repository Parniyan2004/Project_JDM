# JDM Tracker System (Digital CMAS Monitoring)

A Java-based CLI application designed to assist with tracking and managing CMAS scores for patients diagnosed with Juvenile Dermatomyositis (JDM). This tool allows adding new patients, assigning exercises, reporting CMAS results, and viewing progress over time.



## Features

- Register new patients with name and age
- Assign CMAS exercise tasks with description and date
- Add new CMAS scores (manual entry for now)
- View patient progress and CMAS report history
- Command-Line Interface (CLI) based user interaction
- Stores and reads data from a local SQLite database (`jdm.db`)
- Imports real patient data from CSV files (`PatientX` dataset)



## Background

**Juvenile Dermatomyositis (JDM)** is a rare autoimmune disease affecting muscles in children. The **CMAS (Childhood Myositis Assessment Scale)** is a standardized test used to measure muscle strength and physical function.

This system aims to:
- Simplify CMAS reporting at home
- Digitally store results
- Provide a centralized view for caregivers or doctors



## Project Structure
JDM_TRACKER_PROJECT/
│
├── src/
│ ├── main/ # Main.java (entry point)
│ ├── dao/ # Database access classes (PatientDAO, ExerciseDAO, ReportDAO)
│ ├── model/ # Data models (Patient, Exercise, Report)
│
├── out/ # Compiled .class files
├── lib/ # SQLite JDBC driver (sqlite-jdbc-3.50.2.0.jar)
├── jdm.db # SQLite database used by the application
├── PatientX/ # Dataset (CSV files)
├── README.md # This file
└── Report_Project_JDM.pdf # Final report




## How to Run

### Requirements

- Java 17 or higher
- SQLite JDBC driver (already included in `lib/`)
- DB Browser for SQLite (for importing CSV)

### Step 1 – Compile:

```bash
javac -d out -cp "src/main/lib/sqlite-jdbc-3.50.2.0.jar" src/dao/*.java src/model/*.java src/main/*.java

## Step 2 – Run:
java -cp "src/main/lib/sqlite-jdbc-3.50.2.0.jar;out" main.Main

Dataset
The dataset used (PatientX) contains:

Patient basic info

CMAS scores

Additional lab and measurement files (optional)

You can import the CSV files into jdm.db using DB Browser for SQLite.

Use-Cases Implemented
Add and view patient profiles

Assign CMAS exercises

Add CMAS reports

View reports by patient

Compare patients (optional)

Search by name/ID (optional)

Technologies Used
Java 17

SQLite + JDBC

Visual Studio Code

DB Browser for SQLite

License
This project was developed for the course Introduction to Software Engineering at ZUYD University (ADSAI 2025).



