# Spring Boot Data Jpa
This project demonstrates a simple Spring Boot application configured with Spring Data JPA to interact with a MySQL database running in a Docker container.

### MySQL
MySQL is a widely used open-source relational database management system. It is known for its reliability, performance, and ease of use. In this project, MySQL serves as the database backend for storing and managing application data.

### Spring data jpa
Spring Data JPA is a powerful abstraction layer built on top of JPA (Java Persistence API) that simplifies data access in Spring Boot applications. It streamlines database interactions, reduces boilerplate code, and promotes developer productivity. This guide delves into the core functionalities, benefits, and best practices for using Spring Data JPA effectively.

#### CRUD Operations (Out-of-the-Box):
1. **save(entity):** Persists a new entity or updates an existing one.
2. **findById(id):** Retrieves an entity by its ID.
3. **findAll():** Fetches all entities of a particular type.
4. **deleteById(id):** Deletes an entity by its ID.
5. **existsById(id):** Checks if an entity with a specific ID exists.

#### Derived Queries:
Spring Data JPA allows creating finder methods based on naming conventions. The method name translates to the corresponding JPA query. Here are some examples:
- **findByFirstNameAndLastName(String firstName, String lastName):** Finds entities by first and last name.
- **findByPriceGreaterThan(double price):** Finds entities with a price greater than a specified value.
- **countByEnabled(boolean enabled):** Counts the number of entities with a specific enabled flag.

#### JPA Query Methods (For Complex Scenarios):
Spring Data JPA still supports native JPA query methods like **@Query** and **Criteria API** for complex queries that don't fit the naming convention approach.

#### Benefits of Using Spring Data JPA:

1. **Reduced Boilerplate Code:** Spring Data JPA automates tedious JPA details, freeing developers to focus on business logic.
2. **Improved Developer Productivity:** Clear and concise repository methods enhance development speed and maintainability.
3. **Maintainable Code:** Focus on the meaning of operations rather than low-level JPA syntax, leading to more readable code.
4. **Type Safety:** Entities enforce type safety, minimizing runtime errors.
5. **Seamless Integration with Spring Boot:** Spring Data JPA integrates seamlessly with Spring Boot for efficient project setup.

### OpenAPI
OpenAPI is a specification for building and documenting RESTful APIs. It defines a standardized format (JSON or YAML) to describe an API's structure, endpoints, and functionality, promoting easy understanding, machine-readability, and interoperability. This allows for efficient development, documentation, and interaction with APIs.

## Setup
### Mysql Docker Container
1. Install [Docker](https://www.docker.com/products/docker-desktop/) on your machine if not already installed.
2. Pull the MySQL Docker image:
   `docker pull mysql:8.0`
3. Run the MySQL Docker container:
   `docker run --name mysql-server-8.0 -e MYSQL_ROOT_PASSWORD=my_password -d -p 3306:3306 mysql:8.0`
4. Bash to container:
   `docker exec -it mysql-server-8.0 bash`
5. Access Mysql client:
   `mysql -h 127.0.0.1 -P 3306 -u root -p`
### Application
1. Clone the Repository:
   `git@github.com:manjinderrooprai/SpringBoot.git`
2. Open Directory:
   `cd ~/SpringBoot`
3. Open Project in Vscode:
   `code .`
4. Go to specific project directory:
   `cd SpringBootDataJpaMysql`
5. Build the project:
   `Gradle clean build -x test`
6. Run the Application with main class.

Once the application has started, you can access it by opening a web browser and navigating to http://localhost:8000 (assuming the application runs on port 8000).

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.3/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

