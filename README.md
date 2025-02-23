# 🚀 StayTracked

StayTracked is a simple **Project Tracking System** developed in **Java** with a **MySQL** database. It helps users manage projects, track progress, and handle team accounts using **OOP principles** like inheritance and polymorphism.

## ✨ Features
- **🔐 User Management**
  -  Manager and Normal Accounts
  -  Secure authentication
  -  Team-based access control
- **📌 Project Management**
  -  Create, update, and delete projects
  -  Task assignment and tracking
- **🗄️ Database Integration**
  -  Structured MySQL database with relationships
  -  Predefined SQL scripts for easy setup

## ⚙️ Prerequisites
-  **Java Development Kit (JDK 8 or later)**
-  **Apache NetBeans IDE** (Recommended for easier setup)
-  **MySQL Server** (For database management)
-  **MySQL Connector/J** (JDBC driver for Java and MySQL integration)

## 🛠️ Tech Stack
-  **Programming Language**: Java
- 🗄 **Database**: MySQL
-  **IDE**: Apache NetBeans
-  **Version Control**: Git & GitHub
-  **GUI Framework**: Swing (with FlatLaf theme)

## 📥 Installation
### **1. Clone the Repository**
```bash
 git clone https://github.com/your-org/StayTracked.git
 cd StayTracked
```

### **2. Set Up MySQL Database**
1. Create a database named `StayTracked`:
```sql
CREATE DATABASE StayTracked;
```
2. Import the provided SQL script (`staytracked.sql`) to set up tables.
3. Update database connection details in the DBConnectionManager.java file:
```properties
userName= [your sql username]
passWord= [your sql password , if any]
```

### **3. Compile and Run**
#### **Using an IDE (Apache NetBeans)**
1. 📥 Import the project.
2. ⚙️ Configure the MySQL connector.
3. ▶️ Run `StayTracked.java`.

## 🏗️ Usage
### **1. Creating a New Account**
-  Manager accounts can create teams and manage projects.
-  Normal accounts can join teams and track tasks.

### **2. Managing Projects**
-  Managers can **create, assign projects to team members, and delete** projects.
-  Team members can **view, update, and track** project tasks.

## 🖼️ Preview
🚧 We will add it later - or try it yourself! 😆

## 📩 Contact
For questions, contact us at **aayan.shazim@gmail.com** and **malikharis2003@gmail.com**.
