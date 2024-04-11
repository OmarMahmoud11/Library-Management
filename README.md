# Library-Management

# Introduction
The Library Management System is a web-based application designed to facilitate the management of a library's resources and operations. It provides features for managing books, patrons, and borrowing records.

# Features
**1. Book Management**
  - Add Book: Allows librarians to add new books to the library's collection.
  - Update Book: Enables librarians to update existing book information such as title, author, publication year, and ISBN.
  - Delete Book: Allows librarians to remove books from the library's collection.
  - Retrieve All Books: Provides a list of all books available in the library.
    
**2. Patron Management**
  - Add Patron: Enables librarians to add new patrons to the library's database.
  - Update Patron: Allows librarians to update patron information such as name and contact information.
  - Delete Patron: Allows librarians to remove patrons from the library's database.
  - Retrieve All Patrons: Provides a list of all patrons registered with the library.
    
**3. Borrowing Management**
  - Borrow Book: Allows patrons to borrow books from the library by specifying the book ID and patron ID. Automatically records borrowing information, including the return date.
  - Return Book: Enables patrons to return borrowed books to the library. Updates the borrowing record to indicate that the book has been returned.

# To run the application and interact with its API endpoints, follow these steps:
**1. Clone the Repository:** Clone the repository containing the application code from your preferred version control system (e.g., GitHub).

**2. Set Up the Environment:**
  - Ensure you have Java Development Kit (JDK) installed on your machine.
  - Make sure you have Apache Maven or Gradle installed. The application might use one of these build tools for dependency management and building the project.

**3. Configure the Database:** Ensure that you have the required database set up locally or in your environment. This might involve installing and configuring a database server such as MySQL, PostgreSQL, or H2.

**4. Update Database Configuration:** If the application uses a database, ensure that the database connection properties (e.g., URL, username, password) are correctly configured. This information is typically found in the application.properties or application.yml file in the application resources.

**5. Build the Application: ** 
  - Open a terminal or command prompt.
  - Navigate to the root directory of the cloned repository.
  - Run the appropriate build command based on the build tool used by the application:
      For Maven: mvn clean install
      For Gradle: gradle clean build
    
**6. Run the Application:**
  - After successfully building the application, you can run it using the following command:
      For Maven: mvn spring-boot:run
      For Gradle: gradle bootRun
  - Alternatively, you can run the generated JAR file directly:
      java -jar <path-to-jar-file>

**7. Access API Endpoints:**
  - Once the application is running, you can access its API endpoints using a tool like Postman, or a web browser.
  - The API endpoints should be accessible at the base URL http://localhost:<port>/api, where <port> is the port number specified in the application configuration (usually 8080 by default).
  - Interact with the endpoints according to the defined API documentation or specifications.

Once you have finished testing or using the application, gracefully shut it down by stopping the execution process (e.g., pressing Ctrl + C in the terminal window where the application is running).

# Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- RESTful API
- Maven (build tool)
- MySQL (database)

# API Documentation
**Book management endpoints:**
  - GET /api/books: Retrieve a list of all books.
  - GET /api/books/{id}: Retrieve details of a specific book by ID.
  - POST /api/books: Add a new book to the library.
  - PUT /api/books/{id}: Update an existing book's information.
  - DELETE /api/books/{id}: Remove a book from the library.
**Patron management endpoints:**
  - GET /api/patrons: Retrieve a list of all patrons.
  - GET /api/patrons/{id}: Retrieve details of a specific patron by ID.
  - POST /api/patrons: Add a new patron to the system.
  - PUT /api/patrons/{id}: Update an existing patron's information.
  - DELETE /api/patrons/{id}: Remove a patron from the system.
**Borrowing endpoints:**
  - POST /api/borrow/{bookId}/patron/{patronId}: Allow a patron to borrow a book.
  - PUT /api/return/{bookId}/patron/{patronId}: Record the return of a borrowed book by a patron.

# Contributors
**Omar Mahmoud**
