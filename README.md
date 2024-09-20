# 📚 Book Repository Manager

A **Book Repository Manager** built to streamline the management of a book repository. This application provides distinct functionalities for two types of users: **Admin** and **Librarian**, each with their own roles in managing the repository's resources.

## 🚀 Features

### 🔑 Admin Role:
- **Add Librarians**: Create librarian accounts to manage the book repository.
- **View Librarians**: View a detailed list of all existing librarians.
- **Delete Librarians**: Remove librarian accounts when necessary.

### 📘 Librarian Role:
- **Add Books**: Add new books to the repository.
- **View Books**: Browse the complete collection of books in the repository.
- **Delete Books**: Remove outdated or irrelevant books from the collection.
- **Issue Books**: Issue books to students, track and manage the issued books.
- **View Issued Books**: View and manage the list of all books currently issued to students.

## 🛠️ Tech Stack

| Technology      | Description                         |
|-----------------|-------------------------------------|
| **Backend**     | Java, Spring Boot                   |
| **Frontend**    | HTML, CSS, JavaScript               |
| **Database**    | PostgresQL |
| **Build Tool**  | Maven                               |
| **Version Control** | Git                             |

## 📂 Project Structure

```bash
book-repository-manager/
├── src/
│   ├── main/
│   │   ├── java/          # Java source code (controllers, services, models)
│   │   ├── resources/     # Application properties, static resources
│   │   └── webapp/        # Frontend HTML, CSS, JS
├── pom.xml                # Maven build file
└── README.md              # Project documentation
