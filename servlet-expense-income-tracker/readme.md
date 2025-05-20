# Expense Income Tracker

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Getting Started](#getting-started)
5. [Installation](#installation)
6. [Usage](#usage)
7. [Contributing](#contributing)
8. [Contact](#contact)

---

## Introduction

Expense Income Tracker is a simple Java web application designed to help users manage their finances by tracking wallets, expenses, and incomes. The project uses Java Servlets and JSP for the backend and frontend, with in-memory data storage.

---

## Features

- Create, update, delete wallets
- Add income and expense transactions linked to wallets
- View wallets and transaction histories
- Simple user interface using JSP and Servlets
- No database required (in-memory storage)

---

## Technologies Used

- Java
- Java Servlets & JSP
- HTML, CSS, JavaScript
- Apache Tomcat (or any Java Servlet container)

---

## Installation & Setup
Prerequisites
Java Development Kit (JDK) 8 or above

Apache Tomcat server (version 9 or above recommended)

MySQL Server (for database)

IDE like Eclipse or IntelliJ IDEA (optional but recommended)


---
## Prerequisites
Java Development Kit (JDK) 8 or above

Apache Tomcat server (version 9 or above recommended)

MySQL Server (for database)

IDE like Eclipse or IntelliJ IDEA (optional but recommended)

---
## Getting Started

To get started with this project, ensure you have:

- JDK 8 or higher installed
- Apache Tomcat server installed

---

## Installation

1. Clone or download this repository.
2. Import the project into your favorite IDE ( IntelliJ).
3. Configure the project to use Apache Tomcat server.
4. Build and deploy the project on Tomcat.
5. Start the Tomcat server.
6. Open your browser and navigate to `http://localhost:8080/yourapp/`.

---
## Steps 
1.Clone or Download the Project
 - git clone git@github.com:RD-2000/servlet-expense-income-tracker.git
 - cd expense-income-tracker

2.Setup Database

  - Start MySQL server
  - Run the SQL script provided in the Database Schema section to create database and tables

3.Configure Database Connection

  - Modify com.rd.databaseconnection.java to update the DB URL, username, and password if needed

4.Import Project in IDE

  - Import the project as a Maven or Java web project
  - Add Apache Tomcat server runtime

5.Build and Deploy

  - Build the project

  - Deploy the WAR file or project on Tomcat server

6.Start Tomcat Server

  - Run Tomcat server from IDE or manually

  - Open browser and visit http://localhost:8080/yourapp/


7.Usage

 - Use the UI or API to create wallets, add transactions, view summaries

## Usage

- Use the web interface to create wallets.
- Add transactions for income or expenses linked to those wallets.
- View the summary of wallet balances and transaction history.
- All data is stored in-memory; data will reset when the server restarts.

# Functionality

Feature 

1.User Management -  Users can be registered and associated with their wallets.

2.Wallet Management - 	Users can create, update, delete, and view multiple wallets.

3.Income/Expense Tracking - 	Track transactions (income or expense) for each wallet.

4.Transaction History - 	View all transactions for a specific wallet, ordered by timestamp.

5.Balance Management - 	Wallet balances update automatically when transactions are added or removed.

6.JSON API Responses - 	Controller (Servlet) classes send JSON responses to frontend.

7.Database Integration - 	All data is stored persistently using MySQL database via JDBC.

8.Frontend Interaction - 	Users interact via HTML/JSP forms or JavaScript.



## 📝 Database Schema (POJO Classes)
1.POJO Class - 1.User 2.Wallet 3.Transaction

2.Mapped Table - 1.users 2.wallets.3.transaction

3.Fields in Pojo - 1.id,username,password
                   2. id,userid,name,balance 3.id,walletId,type,amount,timestamp

## Contributing

Contributions are welcome! Feel free to fork the repository and submit pull requests.  
Please ensure your code follows best practices and is well-documented.

---

## Contact

For questions or suggestions, please contact:  
**Your Name** —Rutuja Divase

---

Thank you for using Expense Income Tracker!
