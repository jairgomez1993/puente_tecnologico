# Configuración de Seguridad - Variables de Entorno

## 🔒 Información Importante

Este proyecto no contiene contraseñas visibles en el código fuente por razones de seguridad. Las credenciales se configuran usando **variables de entorno**.

## 📋 Variables de Entorno Requeridas

| Variable | Descripción | Ejemplo |
|----------|-------------|---------|
| `DB_URL` | URL de conexión a la base de datos | `jdbc:mysql://localhost:3306/puente_tecnologico` |
| `DB_USERNAME` | Usuario de la base de datos | `root` |
| `DB_PASSWORD` | Contraseña de la base de datos | `tu_contraseña_segura` |
| `PORT` | Puerto de la aplicación | `8081` |
| `SPRING_PROFILES_ACTIVE` | Perfil de Spring activo | `dev` o `prod` |

## 🚀 Cómo Configurar Localmente

### Opción 1: Variables de Entorno del Sistema (Recomendado)

**Windows PowerShell:**
```powershell
$env:DB_URL = "jdbc:mysql://localhost:3306/puente_tecnologico"
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = "tu_contraseña"
$env:PORT = "8081"
$env:SPRING_PROFILES_ACTIVE = "dev"

# Ejecutar la aplicación
.\mvnw spring-boot:run
```

**Linux/Mac:**
```bash
export DB_URL="jdbc:mysql://localhost:3306/puente_tecnologico"
export DB_USERNAME="root"
export DB_PASSWORD="tu_contraseña"
export PORT="8081"
export SPRING_PROFILES_ACTIVE="dev"

# Ejecutar la aplicación
./mvnw spring-boot:run
```

### Opción 2: Archivo .env (Desarrollo Local)

1. Copia el archivo `.env.example` a `.env`:
   ```bash
   cp .env.example .env
   ```

2. Edita `.env` con tus credenciales reales:
   ```
   DB_URL=jdbc:mysql://localhost:3306/puente_tecnologico
   DB_USERNAME=root
   DB_PASSWORD=tu_contraseña_real
   ```

3. El archivo `.env` está en `.gitignore` y **NO** se subirá a GitHub

### Opción 3: JAR con Parámetros

```bash
java -jar target/tecnologico-1.0.0.jar \
  --spring.datasource.url=jdbc:mysql://localhost:3306/puente_tecnologico \
  --spring.datasource.username=root \
  --spring.datasource.password=tu_contraseña
```

## ☁️ Despliegue en Render/Heroku

1. Ve a tu plataforma (Render, Heroku, AWS, etc.)
2. Configura las variables de entorno en el dashboard:
   ```
   DB_URL = tu_url_remota
   DB_USERNAME = usuario_remoto
   DB_PASSWORD = contraseña_remota
   ```
3. La plataforma inyectará automáticamente estas variables

## ✅ Verificación de Seguridad

### ❌ Lo que NO debes hacer:
- Nunca guardes contraseñas en `application.properties`
- Nunca hagas commit de archivos `.env`
- Nunca compartas credenciales en GitHub

### ✅ Lo que SÍ debes hacer:
- Usar variables de entorno para datos sensibles
- Mantener `.env` en `.gitignore`
- Usar secretos de la plataforma en producción
- Revisar regularmente qué está en el repositorio

## 🔍 Verificar que no hay Secretos

```bash
# Buscar posibles contraseñas en el repositorio
git log -p -S "password=" --all
git log -p -S "secret=" --all
git log -p -S "token=" --all
```

## 📚 Referencias

- [Spring Boot Properties](https://spring.io/blog/2021/08/24/spring-cloud-config-server-backed-by-vault)
- [Environment Variables en Spring](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config)
- [GitHub Secrets Management](https://docs.github.com/en/actions/security-guides/encrypted-secrets)

---

**Nota**: Esta configuración es segura para un repositorio público. Las credenciales reales se configuran en cada ambiente de ejecución.
