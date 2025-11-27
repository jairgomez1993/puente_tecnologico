# Puente Tecnológico

## Descripción

**Puente Tecnológico** es un proyecto personal orientado a cerrar la brecha entre la formación académica y las habilidades prácticas demandadas por la industria. 

La plataforma permite que las empresas describan sus necesidades (herramientas, tiempo de capacitación y vacantes) y que las universidades preparen a los estudiantes en esas tecnologías para facilitar una incorporación más rápida y efectiva al mercado laboral.

## Características Principales

✨ **Formulario de Publicación de Necesidades**
- Las empresas pueden publicar sus necesidades de personal
- Especificar herramientas y tecnologías requeridas
- Indicar tiempo de capacitación estimado
- Publicar vacantes disponibles

📚 **Convenios Universitarios**
- Visualización de universidades con convenios
- Listado de carreras disponibles en cada institución
- Información sobre programas de colaboración

💼 **Gestión de Vacantes**
- Vista de todas las vacantes publicadas
- Información detallada de cada oportunidad
- Filtrado por institución educativa

## Tecnologías Utilizadas

- **Backend**: Spring Boot 3.5.6
- **Java**: JDK 17
- **Base de Datos**: MySQL 8.0
- **Frontend**: Thymeleaf, HTML5, CSS3
- **Build Tool**: Maven
- **ORM**: Hibernate/JPA

## Requisitos Previos

- Java 17 o superior
- Maven 3.9.0 o superior
- MySQL 8.0 o superior
- Git

## Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/jairgomez1993/puente_tecnologico.git
cd puente_tecnologico
```

### 2. Configurar la Base de Datos

Crea una base de datos MySQL:

```sql
CREATE DATABASE puente_tecnologico CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. Configurar Variables de Entorno

Por seguridad, las credenciales se configuran mediante variables de entorno. Copia el archivo `.env.example`:

```bash
cp .env.example .env
```

Edita `.env` con tus credenciales (este archivo está en `.gitignore` y no se subirá a GitHub):

```env
DB_URL=jdbc:mysql://localhost:3306/puente_tecnologico
DB_USERNAME=root
DB_PASSWORD=tu_contraseña_segura
PORT=8081
```

### 4. Ejecutar la aplicación

**Con variables de entorno cargadas:**

```bash
# Linux/Mac
export $(cat .env | xargs)
./mvnw spring-boot:run

# Windows PowerShell
Get-Content .env | ForEach-Object { $parts = $_ -split '='; [System.Environment]::SetEnvironmentVariable($parts[0], $parts[1], 'Process') }
.\mvnw spring-boot:run
```

**O directamente con Maven:**

```bash
# Con Maven
./mvnw spring-boot:run

# O compilar primero
./mvnw clean install
java -jar target/tecnologico-1.0.0.jar
```

La aplicación estará disponible en: **http://localhost:8081**

## 🔒 Seguridad

Este proyecto implementa mejores prácticas de seguridad:

- ✅ **No almacena credenciales en código fuente**
- ✅ **Usa variables de entorno para datos sensibles**
- ✅ **Archivo `.env` está en `.gitignore`** (nunca se sube a GitHub)
- ✅ **Archivo `SECURITY.md`** con instrucciones detalladas

**Importante**: Ver [SECURITY.md](SECURITY.md) para configurar variables de entorno correctamente.

## Estructura del Proyecto

```
puente_tecnologico/
├── src/
│   ├── main/
│   │   ├── java/com/puente/tecnologico/
│   │   │   ├── PuenteTecnologicoApplication.java
│   │   │   ├── controller/
│   │   │   │   └── EmpresaController.java
│   │   │   ├── model/
│   │   │   │   └── Empresa.java
│   │   │   └── repository/
│   │   │       └── EmpresaRepository.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   │           ├── formulario-empresa.html
│   │           ├── convenios.html
│   │           ├── vacantes.html
│   │           └── exito.html
│   └── test/
│       └── java/com/puente/tecnologico/
│           └── PuenteTecnologicoApplicationTests.java
├── pom.xml
└── README.md
```

## Endpoints Disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/` | Página principal con formulario |
| POST | `/registrar-empresa` | Registrar una nueva empresa |
| GET | `/convenios` | Ver convenios universitarios |
| GET | `/vacantes` | Ver vacantes disponibles |

## Modelo de Datos

### Tabla: empresa

```sql
CREATE TABLE empresa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    sector VARCHAR(100),
    nivel VARCHAR(50),
    email VARCHAR(255),
    herramientas TEXT,
    tiempo VARCHAR(100),
    vacantes INT,
    requisitos TEXT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## Universidades Integradas

- **Uniminuto**
  - Ingeniería de Sistemas
  - Administración de Empresas
  - Contaduría

- **Corporación Universitaria Republicana**
  - Técnologo en Desarrollo de Software
  - Negocios Internacionales

## Características Futuras

- [ ] Sistema de autenticación para empresas y universidades
- [ ] Filtrado avanzado de vacantes
- [ ] Panel de administración
- [ ] Sistema de notificaciones
- [ ] Integración con redes sociales
- [ ] API REST completa
- [ ] Aplicación móvil

## Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Contacto

**Desarrollador**: Eduin Jair Gómez Real

- 📱 WhatsApp: [3125377997](https://wa.me/573125377997)
- 💼 LinkedIn: [eduin-jair-gomez](https://www.linkedin.com/in/eduin-jair-gomez/)
- 📧 Email: jairgomez18837@gmail.com

## Licencia

Este proyecto está bajo la Licencia MIT. Ver archivo `LICENSE` para más detalles.

## Agradecimientos

- Spring Boot por el excelente framework
- MySQL por la base de datos confiable
- La comunidad de desarrollo por el apoyo continuo

---

**Nota**: Este es un proyecto personal en desarrollo. Se continuarán agregando nuevas funcionalidades y mejoras.
