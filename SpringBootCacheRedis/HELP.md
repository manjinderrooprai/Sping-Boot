# Spring Boot Cache with redis
This project serves as a Proof of Concept (PoC) for integrating caching in a Spring Boot application using Redis as the caching provider.

### Overview
Caching is a technique used to store frequently accessed data in memory, thereby improving the performance and scalability of applications. In this PoC, we demonstrate how to configure and utilize caching in a Spring Boot application leveraging Redis, an in-memory data store.

### Spring Boot Cache
Spring Boot offers a caching abstraction layer that simplifies cache integration. Here's the general flow:
1. **Enable Caching:** Annotate your main application class with @EnableCaching. This activates caching functionality.
2. **Caching Annotations:** Use annotations like @Cacheable, @CachePut, and @CacheEvict to mark methods for caching behavior.
   1. **@Cacheable:** This method's result gets cached. Subsequent calls with the same arguments retrieve data from the cache if available.
   2. **@CachePut:** Updates the cache with the method's return value after successful execution.
   3. **@CacheEvict:** Removes specific cache entries based on arguments or conditions.
3. **Cache Configuration:**
   - **Auto-configuration:** Spring Boot auto-configures a basic cache manager if necessary.
   - **Custom configuration:** You can create a custom CacheManager bean for more control over caching behavior (cache names, expiration times).
4. **Cache Provider:** Spring Boot supports various cache providers like Redis, EhCache, and Caffeine. You can choose a provider based on your requirements.

#### Benefits of Spring Boot Caching:
1. **Improved Performance:** Reduces database load, leading to faster response times.
2. **Scalability:** Makes applications more scalable by handling increased traffic efficiently.
3. **Reduced Costs:** Lower database load can translate to cost savings (depending on your database model).

### Redis Cache
Redis is an open-source, in-memory data structure store that can be used as a database, cache, and message broker. It supports various data structures such as strings, hashes, lists, sets, sorted sets with range queries, bitmaps, hyperloglogs, and geospatial indexes with radius queries.

### OpenAPI
OpenAPI is a specification for building and documenting RESTful APIs. It defines a standardized format (JSON or YAML) to describe an API's structure, endpoints, and functionality, promoting easy understanding, machine-readability, and interoperability. This allows for efficient development, documentation, and interaction with APIs.

## Setup
### Redis Docker Container
1. Install [Docker](https://www.docker.com/products/docker-desktop/) on your machine if not already installed.
2. Pull the Redis Docker image:
   `docker pull redis:7.2.4
3. Run the Redis Docker container:
   `docker run --name redis-server-7.2.4 -d -p 6379:6379 redis:7.2.4`
4. Bash to container:
   `docker exec -it redis-server-7.2.4 bash`
5. Access Redis client:
   `redis-cli -r 5 INCR counter_value`
### Application
1. Clone the Repository:
   `git@github.com:manjinderrooprai/SpringBoot.git`
2. Open Directory:
   `cd ~/SpringBoot`
3. Open Project in Vscode:
   `code .`
4. Go to specific project directory:
   `cd SpringBootCacheRedis`
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

