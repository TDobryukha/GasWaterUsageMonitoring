Microservice to manage measurements of gas, cold and hot water usage.
Without UI, only REST API. 
Implemented custom methods for submitting the current measurements for a given user,
getting the history of previously submitted measurements for a given user or a given parameter. 
To adding measurement user must be authorized. User inputs are validated to reject incomplete or invalid data.

Used:
Spring Boot: MVC,  Data JPA, MVC, Security
Maven
Lombok