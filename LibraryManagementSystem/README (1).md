# 📘 Library Management System

A **Java-based Library Management System** designed for academic purposes, enabling easy management of books and members. It supports key library operations such as adding books, registering members, issuing books, and searching for library resources using a console-driven interface.

---

## 🚀 Features

- 📚 Add, search, and view book details
- 👥 Register and manage student and faculty members
- 🔄 Issue books to members with validation
- 🔍 Search book by title and member by name
- ✅ User-friendly, menu-driven CLI (Command Line Interface)
- 🧱 Designed using object-oriented programming principles (OOP)

---

## 🛠️ Technologies Used

- Java (JDK 8 or higher)
- OOP Concepts (Abstraction, Inheritance, Polymorphism)
- UUID for unique identification
- Collections Framework (ArrayList)
- LocalDate for date handling

---

## 🧪 How to Run

1. **Clone this repository**:
   ```bash
   git clone https://github.com/your-username/LibraryManagementSystem.git
   cd LibraryManagementSystem
   ```

2. **Compile the Java file**:
   ```bash
   javac LibraryManagementSystem.java
   ```

3. **Run the program**:
   ```bash
   java LibraryManagementSystem
   ```

---

## 🧾 Menu Options

1. Add Book  
2. Register Member  
3. Issue Book  
4. View All Books  
5. Find Book by Title  
6. Find Member by Name  
7. Exit  

---

## 🧑‍💻 Project Structure

```
LibraryManagementSystem.java
```

The program contains:
- Abstract base class: `Member`
- Subclasses: `Student`, `Faculty`
- Core entities: `Book`, `Library`
- Service class: `LibraryService`
- Interface: `Librarian` with concrete class `HeadLibrarian`

---

## 📝 Sample Input/Output

```
--Library Management System--
1. Add Book
2. Register Member
3. Issue Book
...
Enter choice: 1
Book Title: Java Basics
Author: James Gosling
Genre: Programming
=> Book Added!
```

---

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

## ✍️ Author

**Nagarakshita K M**  
_Designed as a final-year project with educational intent._

## 📸 Sample Output Screenshots

![Sample Output](Screenshot 2025-06-14 124126.png)

![Sample Output](Screenshot 2025-06-14 124155.png)

![Sample Output](Screenshot 2025-06-14 130355.png)

![Sample Output](Screenshot 2025-06-14 130438.png)