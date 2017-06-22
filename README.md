# Warpaint

## Overview
Spring Boot based application for Warpaint.

## Installation

### Prerequisites
To build from source, you need the following installed (and available in your $PATH):

* [Java 8+](http://java.oracle.com)

* [Apache Maven 3 or greater](http://maven.apache.org/)

### Building
After cloning the project, you can build it from source with this command:
```
mvn package
```
And you can install it into your Maven repository:
```
mvn install
```

### Running the app
The Spring Boot application can be started with the Spring Boot Maven plugin goal:
```
mvn spring-boot:run
```

## API
### Prices
The Prices API can be reached at the '/price/months' REST endpoint with the GET HTTP method.

If you run your host on the localhost on the default port, the full path would be _http://localhost:8080/price/months_.