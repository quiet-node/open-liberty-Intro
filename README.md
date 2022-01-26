## Open Liberty

- Open Liberty is an open framework for the Java ecosystem that allows developing microservices using features of the Eclipse MicroProfile and Jakarta EE platforms.

## Eclipse MicroProfile Services
- EM (Eclipse Microprofile) is a set of specifications or technologies which fill up the gap of Java EE.

- EM has three layers and includes these technologies bellow: 
- ![image](https://user-images.githubusercontent.com/66233296/151029970-d8ce03aa-25dd-4f49-98b3-4427e5dad23d.png)

    - Open Tracing: allows services to easily participate in a distributed tracing environment (quite unsure what this means)
  
    - Open API: provides a Java API for the OpenAPI specification that can use to expose API documentation for REST APIs. OpenAPI can be natively produced from JAX-RS apps. 

    - Rest Client: provides a type safe client (as defined by JAX-RS) that handles the communication between the client and service

    - Config: Allow developers to use outside sources to config the project. It externalizes configuration from the application to improve portability of the application

    - Fault Tolerance: provides an API and annotations for building robust behavior to cope with unexpected failures in the service you depend on

    - Metrics: is an API uses JAX-RS that provides common REST endpoints for monitoring the telemetry data of a running microservice

    - JWT Propagation: provides for interoperable authentication and role-based access control for your services.

    - Health check:  provides a common REST endpoint format to determine whether a microservice is healthy or not (it's running or not)

    - CDI (Context and Dependency Injection): Through @Inject annotation provides objects with dependencies needed

    - JSON-P and JSON-B: make it easy to work with JSON by providing APIs for provessing JSON

    - JAX-RS: provides Java APIs used for creating RESTful web endpoints



Resources:
- Intro to open liberty: https://www.baeldung.com/java-open-liberty 
- MicroProfile: https://openliberty.io/docs/22.0.0.1/microprofile.html
- MP Rest Client: https://developer.ibm.com/series/what-is-microprofile/
