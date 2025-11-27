# Copilot instructions for puente-tecnologico

These notes are for AI coding agents working on this repository. Keep them short and actionable. Reference files by path when helpful.

- Project type: Spring Boot (Java 17) web application using Spring Data JPA and Thymeleaf. Key files:
  - `src/main/java/com/puente.tecnologico/PuenteTecnologicoApplication.java` — main Spring Boot entrypoint
  - `src/main/java/com/puente/tecnologico/controller/EmpresaController.java` — web controller (Thymeleaf + form handling)
  - `src/main/java/com/puente/tecnologico/model/Empresa.java` — JPA entity mapped to `empresas` table
  - `src/main/java/com/puente/tecnologico/repository/EmpresaRepository.java` — Spring Data JPA repository
  - `src/main/resources/application.properties` — DB and server configs

- Big picture architecture:
  - Single Spring Boot application (monolith) exposing server-side rendered pages with Thymeleaf and simple REST-style controller endpoints.
  - Persistence: Spring Data JPA backed by MySQL (see `application.properties`). The `Empresa` entity uses `GenerationType.IDENTITY` and is persisted via `EmpresaRepository`.
  - UI: Thymeleaf templates live under `src/main/resources/templates` (not currently listed in repo snapshot, but controller returns view names `formulario-empresa` and `exito`).

- Common developer workflows (commands you should use):
  - Build & run locally:
    - Use Maven wrapper from project root: `./mvnw spring-boot:run` (on Windows use `mvnw.cmd spring-boot:run`).
    - Or build jar: `./mvnw package` then run `java -jar target/*.jar`.
  - Run tests: `./mvnw test` (or `mvnw.cmd test` on Windows).
  - If changing DB schema or entities, the project uses `spring.jpa.hibernate.ddl-auto=update` in `application.properties` — prefer migrations for production but `update` is fine for local dev.

- Project-specific conventions and patterns:
  - Controller methods return Thymeleaf view names (e.g., `"formulario-empresa"`). Look in `src/main/resources/templates` for template names.
  - Repositories follow Spring Data JPA naming (interface extends `JpaRepository<Entity,Long>`). Add custom queries by declaring methods in the interface.
  - Logging is minimal; some places use `System.out.println` (e.g., after saving an `Empresa`). Prefer using a logger for new code (`org.slf4j.Logger` / `LoggerFactory`).
  - DTOs are not present; controllers bind directly to entities (e.g., `registrarEmpresa(Empresa empresa)`). Be careful when adding fields — validation and mapping could be required.

- Integration points & external dependencies:
  - MySQL running at `jdbc:mysql://localhost:3306/puente_tecnologico` by default. Credentials are in `application.properties`.
  - PostgreSQL dependency exists in POM but runtime is configured for MySQL; ignore unused dependencies unless intentionally switching DB.
  - Thymeleaf templates under `src/main/resources/templates` for UI rendering; static assets under `src/main/resources/static`.

- Helpful code examples to follow:
  - Saving an entity: `empresaRepository.save(empresa)` (see `EmpresaController.registrarEmpresa`).
  - Controller mapping: `@GetMapping("/")` and `@PostMapping("/registrar-empresa")` patterns.

- What to avoid or watch for:
  - Don't change `spring.jpa.hibernate.ddl-auto=update` to `create` unless you understand the local DB consequences.
  - The codebase currently binds forms directly to JPA entities — adding validation should use `@Valid` and a DTO if you need to decouple form shape from persistence.
  - Avoid introducing heavy frameworks or large dependencies; this is a lightweight demo-style app.

- When creating new features or fixes:
  - Add small unit/integration tests under `src/test/java/com/puente.tecnologico` using Spring Boot Test (there is an existing test class `PuenteTecnologicoApplicationTests`).
  - Keep view names, template locations, and form field names consistent with existing templates.

- Where to look for more context:
  - `HELP.md` for general references and links.
  - `pom.xml` for dependencies and Java version (Java 17).

If anything in these notes is unclear or you want deeper guidance (example: expand controller patterns, recommended logging usage, or introduce DTOs + validation), ask and I will update this file.