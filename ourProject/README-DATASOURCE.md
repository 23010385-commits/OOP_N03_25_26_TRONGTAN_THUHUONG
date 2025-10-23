DataSource configuration
========================

This project includes a Spring-managed HikariCP DataSource configured from environment variables.

Environment variables (used by `DataSourceConfig`):

- `DB_URL` — JDBC URL, default: `jdbc:mysql://localhost:3306/guitardb?serverTimezone=UTC`
- `DB_USER` — Database username, default: `root`
- `DB_PASSWORD` — Database password, default: empty

The configuration also reads the Spring-style properties `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, and `SPRING_DATASOURCE_PASSWORD` as fallbacks.

How to run (PowerShell / Windows):

1. From the project root (`ourProject`):

   - If you have Maven installed globally:

     ```powershell
     mvn -U spring-boot:run
     ```

   - If you prefer the Maven wrapper (included):

     ```powershell
     .\mvnw.cmd -U spring-boot:run
     ```

2. To run tests / build:

   ```powershell
   .\mvnw.cmd -U clean test
   ```

3. Set environment variables before running (example):

   ```powershell
   $env:DB_URL = 'jdbc:mysql://localhost:3306/guitardb?serverTimezone=UTC'
   $env:DB_USER = 'root'
   $env:DB_PASSWORD = 's3cret'
   .\mvnw.cmd -U spring-boot:run
   ```

Notes:
- Dependencies (Spring Boot, HikariCP, MySQL driver) are declared in `pom.xml` and will be resolved by Maven.
- If the Maven wrapper fails to run in your environment, install Maven or copy the Maven wrapper binary (`.mvn/wrapper/maven-wrapper.jar`) into the repo so the wrapper doesn't need to download it.
- For quick local Java checks without Maven, see `DemoApp.java` and `SimpleServer.java` in the project root (they're standalone demos, not wired to Spring).
