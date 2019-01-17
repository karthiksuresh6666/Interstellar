Running the project:
I have used the embedded tomcat of Spring Boot
You can run like java application with InterstellarApplication.java
Endpoints: 
1. To import the data first (mandatory - ddl-auto=create-drop).
http://localhost:8080/data/import

2. To calculate the minimum distance
http://localhost:8080/distance/calculate_distance

Project Design and Tools Used:
1. Dependency and build management - maven.
2. Apache POI for importing the data from Excel sheet.
3. Embedded database - Apache Derby for relational transaction.
4. Hibernate for Entity management.
5. Spring boot parent and MVC architecture to serve the business purpose.
6. Servlet container - Apache tomcat


Areas to Improve:
1. Could have used JSP servlet and spring Model View resolver (Haven’t used MVC for application development – Have exposed the rest services which bill be used by the Angular application for view).
2. Caching could be implemented to prevent repetitive computation in a session.
3. Swagger framework can be used to test the exposed rest service.
4. Exception Handling with resource bundle to delegate appropriate error message.
5. Logging could be implemented.
6. Method and class level comments for code readability.
7. Algorithm performance tuning using Priority Queue for weighted graphs.
8. Good UX and UI design.
