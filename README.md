# Italian Restaurant Application 🍝
Welcome to the Italian Restaurant application! This application is designed to manage various aspects of an Italian restaurant using a microservices architecture. It provides features for handling menu items, orders, and more.

## Setup Instructions 🛠️
To get started with the application, follow these steps:

### 1. Clone the Repository

```bash
git clone <repository-url>
cd <repository-directory>
```

### 2. Run the Database 🗄️
Use Docker to run a MySQL container with the following command:

```bash
docker run -p 3306:3306 --name menu_item_db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=menu_item_db -d mysql
```

This command will:
Map port 3306 of your host to port 3306 of the Docker container.
Set the MySQL root password to root.
Create a MySQL database named menu_item_db.

### 3. Start the Application 🚀
Run the MenuApplication.main class to start the application.

### 4. Check the Swagger Documentation 📄
Once the application is running, you can check the Swagger documentation at:

```bash
http://localhost:8080/swagger-ui.html
```

