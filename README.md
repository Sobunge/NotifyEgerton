# NotifyEgerton

NotifyEgerton is a Spring Boot web application that facilitates communication among students and staff by allowing them to post and view notifications. This platform aims to enhance information sharing within the Egerton University community.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installing](#installing)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Features

- **User Authentication:** Secure access to the platform with user authentication.
- **Role-based Access Control:** Different roles for students and staff, each with specific permissions.
- **Post Notifications:** Users can post announcements, updates, and other notifications.
- **View Notifications:** Users can browse through notifications posted by others.
- **Responsive Design:** The application is designed to be accessible on various devices.

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/#java17) - Ensure you have JDK 17 installed.
- [Maven](https://maven.apache.org/download.cgi) - Dependency management tool.
- [MySQL Server](https://dev.mysql.com/downloads/mysql/) - Ensure you have MySQL server installed and database uni setup

### Installing

1. Clone the repository:

   ```bash
   git clone https://github.com/Sobunge/NotifyEgerton.git

2. Navigate to the project directory:
   ```bash
   cd NotifyEgerton
   
4. Build the project:
   ```bash
   mvn clean install
  
6. Run the application:
   ```bash
   java -jar target/notify-egerton-1.0.0.jar

The application should now be running locally. Access it by navigating to 'http://localhost:8080' in your web browser.

## Usage

1. Register for an account or log in if you already have one.
2. Explore the dashboard to view and post notifications.
3. Choose the appropriate role (user or admin) to access specific features.

## Contributing

If you'd like to contribute to this project, please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature: git checkout -b feature-name.
3. Commit your changes: git commit -m 'Add some feature'.
4. Push to the branch: git push origin feature-name.
5. Submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](https://mit-license.org/) file for details.

## Acknowledgments

- The NotifyEgerton team acknowledges the support and contributions from the Egerton University community.
