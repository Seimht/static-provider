# README

## Project Overview
This project is a web-based application for managing **Products**, **Providers**, and **Sales**. The system allows users to log in as providers, manage their products and sales, and view sales statistics. The application is built using **Spring Boot**, **Thymeleaf**, **MySQL**, and **Spring Security**.

---

## Features
1. **Provider Management:**
   - Log in and log out.
   - Manage products and sales.
   - Secure authentication and role-based access control.

2. **Product Management:**
   - Add, update, delete, and view product details.
   - Fields include Product ID, Name, Provider ID, Stock, and Price.

3. **Sales Management:**
   - Create, update, delete, and view sales.
   - Fields include Sale ID, Product ID, Quantity, Total, and Date.

4. **Sales Statistics:**
   - View aggregated sales data (e.g., total sales, top-performing products).

5. **Navigation:**
   - Easily navigate between Products, Providers, and Sales pages using a navigation bar.

---

## Prerequisites

1. **Java Development Kit (JDK):** Version 21 or higher.
2. **Maven:** Ensure Maven is installed for building the project.
3. **MySQL Database:**
   - Install MySQL.
   - Create a database named `nothingbutnet`.
4. **Spring Boot:** Version 3.3.4.
5. **Web Browser:** For accessing the application.

---

## Setup Instructions

### Step 1: Clone the Repository
```bash
git clone <repository-url>
cd demo
```

### Step 2: Configure the Database
1. Update the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3307/nothingbutnet
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   ```
2. Run the following SQL commands to set up default data:
   ```sql
   INSERT INTO user (email, username, password, roles) VALUES
   ('provider1@example.com', 'provider_user1', '$2a$10$kB9ubZKk3quz1SXip17wbeLsyZTjG6ve11/5fdVR/AMAndz/euVMO', 'ROLES_PROVIDER');
   ```
   - **Username:** `test@example.com`
   - **Password:** `provider_password`

### Step 3: Build and Run the Project
1. Build the project using Maven:
   ```bash
   mvn clean install
   ```
2. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

### Step 4: Access the Application
1. Open your browser and navigate to:
   ```
   http://localhost:8080
   ```
2. Log in using the default provider credentials:
   - **Email:** `test@example.com`
   - **Password:** `provider_password`

---

## Using the Application

### 1. **Provider Dashboard**
   After logging in, you will be redirected to the **Products** page. From here, you can:

   - **Manage Products:** Add, update, view, and delete products.
   - **Manage Sales:** Create, update, view, and delete sales.
   - **View Sales Statistics:** Access an overview of sales performance.

### 2. **Navigation**
   Use the navigation bar at the top to switch between:
   - **Products**: Manage all product-related activities.
   - **Providers**: View and manage provider details.
   - **Sales**: Manage sales-related activities.

### 3. **Log Out**
   Click the **Logout** button in the navigation bar to securely log out of the application.

---

## Notes
- Ensure that the database is running before starting the application.
- Update `application.properties` for your local environment settings.
- Default credentials can be customized by modifying the `users` table in the database.

---

## Technologies Used
- **Backend:** Spring Boot, Spring Security
- **Frontend:** Thymeleaf, HTML, CSS
- **Database:** MySQL
- **Build Tool:** Maven
