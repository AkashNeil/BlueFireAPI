# REST API

### Running the application

```
mvn spring-boot:run
```

### Format of link where API is exposed

```
http://localhost:8080/api/...
```
---
### Interacting with Book Records

#### CREATE a new book : ``/createNewBook``

``
HTTP Method: POST | Params: JSON data in Body
``

\+ Send the appropriate JSON data in the body, for e.g. :
 
```json
{
  "name": "The Art of War",
  "author": "Sun Tzu", 
  "format": "EPUB",
  "read": true
}
```

#### RETRIEVE all books from database : ``/books``

``
HTTP Method: GET | Params: N/A
``
#### RETRIEVE books by name : ``/booksByName``

``
HTTP Method: GET | Params: name
``

#### UPDATE a book : `` /updateBook?id=x ``

`` HTTP Method: PUT | Params: id (required)``

\+ Send the appropriate JSON data in the body, for e.g. :

```
{
  "name": "The Art of War",
  "author": "Sun Tzu", 
  "format": "PDF",
  "read": false
}
```

#### DELETE a book : `` /deleteBook?id=x ``

`` HTTP Method: DELETE | Params: id (required)``

---
### Interacting with Tutorial Records

---

### Technologies used : 
- Java 11
- Spring Boot 2.4.1 
- JPA 
- H2
---

## References

- https://restfulapi.net/
- https://www.restapitutorial.com/
- https://medium.com/@kumaraksi/using-http-methods-for-restful-services-e6671cf70d4d
- https://dzone.com/articles/spring-boot-passing-parameters
- https://www.baeldung.com/spring-data-jpa-query
- https://www.baeldung.com/spring-cors

Security:
- [Spring Boot + Spring Security JWT Authentication & Authorization](https://bezkoder.com/spring-boot-jwt-authentication/)

---

###### © Developed by akashneil.github.io
