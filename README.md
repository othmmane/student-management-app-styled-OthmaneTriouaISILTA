# Student Management App Styled

Mini JEE CRUD project using:

- Servlet + JSP + JSTL
- DAO pattern + interface
- JDBC
- MySQL
- Maven
- Tomcat 10
- Docker Compose

## Delete old containers and rebuild

If you already ran an older version, delete old containers, network, and database volume first:

```bash
docker compose down -v
```

Then rebuild and run:

```bash
docker compose up --build
```

Open the web app:

```text
http://localhost:8080/students
```

Open phpMyAdmin:

```text
http://localhost:8081
```

phpMyAdmin login:

```text
Server: mysql
Username: root
Password: root
```

## Project flow

```text
Browser -> Servlet -> DAO Interface -> DAO Implementation -> DBConnection -> MySQL
        <- JSP with HTML table <- List<Student>
```

## Package name

```text
isil.est.essaouira
```
