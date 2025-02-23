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
-  **Database**: MySQL
-  **IDE**: Apache NetBeans
-  **Version Control**: Git & GitHub
-  **GUI Framework**: Swing (with FlatLaf theme)

## 📥 Installation
### **1️⃣ Extract the ZIP File**
- Download and extract **StayTracked.zip**.
- You will get a folder named **StayTracked/** (NetBeans project).
- Keep the **Additional NetBeans Libraries/** folder in the same location (it contains required external JARs).

### **2️⃣ Import Project in NetBeans**
1. Open **Apache NetBeans**.
2. Go to **File** → **Open Project**.
3. Select the extracted **StayTracked/** folder and open it.
4. If prompted, install missing plugins.

### **3️⃣ Configure Libraries**
1. Right-click **StayTracked** in NetBeans.
2. Select **Properties** → **Libraries**.
3. Click **Add JAR/Folder**.
4. Navigate to the **Additional NetBeans Libraries/** folder.
5. Select all JAR files inside and add them to the project.
6. Click **OK** to save changes.

### **4️⃣ Set Up MySQL Database**
1. Open **MySQL Workbench** (or any SQL client).
2. Create a new database named **`StayTracked`**:
   ```sql
   CREATE DATABASE StayTracked;
   ```  
3. Inside the **StayTracked/** project folder, find `StayTrackedDB.sql`.
4. Import `StayTrackedDB.sql` into MySQL:
   - In MySQL Workbench, go to **Server** → **Data Import**.
   - Select **Import from Self-Contained File** and choose `StayTrackedDB.sql`.
   - Click **Start Import**.

### **5️⃣ Update Database Credentials**
1. Open **`DBConnectionManager.java`** inside NetBeans.
2. Update your database credentials:
   ```java
   String userName = "[your SQL username]";
   String passWord = "[your SQL password, if any]";
   ```  

### **6️⃣ Run the Project**
- In NetBeans, right-click **StayTracked** and select **Run**.
- The StayTracked system should now launch successfully! 

## 🏗️ Usage
### **1. Creating a New Account**
-  Manager accounts can create teams and manage projects.
-  Normal accounts can join teams and track tasks.

### **2. Managing Projects**
-  Managers can **create, assign projects to team members, and delete** projects.
-  Team members can **view, update, and track** project tasks.

## 🖼️ Preview
### **1. Login And Sign Up**
<p align="left">
  <img src="https://github.com/user-attachments/assets/5dded603-c518-4450-8a93-30dc69d25d2e" width="30%">
  <img src="https://github.com/user-attachments/assets/0799dda3-0ae3-4911-a879-5830f95343a4" width="30%">
  <img src="https://github.com/user-attachments/assets/68d45607-c71a-4219-8894-29784b606421" width="30%">
</p>

<p align="left" >
  <img src="https://github.com/user-attachments/assets/631c95cf-18d6-4a7f-9ea5-e34e66e9beaf" width="30%">
  <img src="https://github.com/user-attachments/assets/06728251-af71-460e-b30d-99aeca20d6c7" width="30%">
</p>

### **2. Dashboard**
<p align="left">
  <img src="https://github.com/user-attachments/assets/91ba5895-6849-40c3-b281-e16788182f2c" width="30%">
</p>

### **3. Projects**
<p align="left">
  <img src="https://github.com/user-attachments/assets/da56047d-b5d5-4ddd-8b7d-b5fd2740fea4" width="30%">
  <img src="https://github.com/user-attachments/assets/81cf730b-1469-4cd8-bb25-d13cf3a8d0bb" width="30%">
  <img src="https://github.com/user-attachments/assets/ff4cdcbf-c0bb-4488-9394-7fce0db9899d" width="30%">
  <img src="https://github.com/user-attachments/assets/c040cd4b-49c8-474a-8db1-5a232a361505" width="30%">
</p>

### **4. Profile**
<p align="left">
  <img src="https://github.com/user-attachments/assets/93c6cc8a-e697-4c42-a476-df433582759f" width="30%">
  <img src="https://github.com/user-attachments/assets/4b4ce317-02fe-4d5e-b92b-674fb9c9964e" width="30%">
  <img src="https://github.com/user-attachments/assets/3de4d8ea-cc65-47c2-900a-5d59eaac2c58" width="30%">
</p>

### **5. Teams**
<p align="left">
  <img src="https://github.com/user-attachments/assets/cbcecf22-2f0f-4fd1-9eb1-0f0bfbde3936" width="30%">
</p>

### **6. About**
<p align="lrft">
  <img src="https://github.com/user-attachments/assets/60e7e7a3-aa9d-4074-bbee-a286c60b2cb7" width="30%">
  <img src="https://github.com/user-attachments/assets/71485348-d9bb-4982-ac46-1cd4ccf6bbd8" width="30%">
</p>






## 📩 Contact
For questions, contact us at **aayan.shazim@gmail.com** and **malikharis2003@gmail.com**.
