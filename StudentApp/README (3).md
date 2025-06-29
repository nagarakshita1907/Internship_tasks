
# 📚 Student Management System (Java + JDBC)

This is a modular, console-based **Student Management System** built using **Java 19** and **JDBC** for MySQL database operations. The system supports secure login/signup, update, search, delete, view operations, and exports student data to CSV.

---

## 📁 Project Structure

```
studentApp/
├── src/
│   ├── in.pentagon.studentapp.dao/
│   │   ├── CSVExporter.java
│   │   ├── StudentDAO.java
│   │   └── StudentDAOImpl.java
│   ├── in.pentagon.studentapp.model/
│   │   ├── Login.java
│   │   ├── Signup.java
│   │   ├── Update.java
│   │   ├── Password.java
│   │   └── index.java
│   ├── in.pentagons.studentapp.Connection/
│   │   └── Connector.java
│   ├── in.ps.Studentapp.dto/
│   │   ├── Student.java
│   │   └── module-info.java
├── students.csv
```

---

## ✨ Features

- 🔐 **Login / Signup / Forgot Password**
- 📝 **Add / Update / Delete Student Records**
- 🔍 **Search User & View All Students**
- 📁 **CSV Export Functionality**
- ✅ **Validation & Clean Architecture**
- 💾 **MySQL + JDBC Integration**

---

## 🛠 Technologies

- Java 19
- JDBC
- MySQL
- Object-Oriented Programming
- CSV File Handling
- Modular Java (`module-info.java`)

---

## 📤 Sample Output Screenshots

> 📌 Below are screenshots of the console interface for various functionalities.

### ✅ Login & Menu View
![Login Output](./Screenshot%202025-06-29%20184452.png)

### 📄 View & Delete Students
![Student List Output](./Screenshot%202025-06-28%20204550.png)

### 🗂 Signup Process
![Signup](./Screenshot%202025-06-29%20185121.png)

### 🔄 Update Student Info
![Update](./Screenshot%202025-06-29%20185702.png)

### 🔐 Forgot Password Flow
![Password Reset](./Screenshot%202025-06-29%20185727.png)

---

## 📄 Sample CSV Export

Example of `students.csv` exported:

| ID  | Name      | Phone       | Mail           | Branch | Location | Password | Date       |
|-----|-----------|-------------|----------------|--------|----------|----------|------------|
| 10  | rakshita  | 99223366778 | raksh@gm       | CSE    | hospet   | rak123   | 2025-06-29 |
| 11  | vanisha   | 123456789   | anu12@gn       | CSE    | hospet   | vanu123  | 2025-06-29 |
| ... | ...       | ...         | ...            | ...    | ...      | ...      | ...        |

---

## 🚀 How to Run

1. Clone the repository
2. Set up MySQL DB and table schema
3. Configure DB credentials in `Connector.java`
4. Compile and run `index.java`

---

## 📧 Author

**Your Name**  
📧 your.email@example.com

---

## 📄 License

This project is licensed under the [MIT License](LICENSE)
