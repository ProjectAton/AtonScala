# ATON
Administrador de laboratorios de computadoras implementado en `Scala` con `Play Framework`.

## Funciones
Si tienes un laboratorio de computadoras con sistema operativo Linux, Aton se podrá encargar de múltiples tareas administrativas básicas en conjunto, por ejemplo:
- Instalar o desinstalar software nuevo.
- Apagar, reiniciar o encender (Con la posibilidad de que se haga de forma programada a cierta hora).
- Enviar órdenes personalizadas SSH.
- Verificar cuáles computadores están en uso de forma gráfica.
- Enviar mensajes a los usuarios que se encuentren conectados.

Aton funciona por medio de __SSH__, por lo que el único requisito para registrar un equipo dentro de Aton es que SSH se encuentre ejecutando en el equipo a registrar. Al registrar nuevos equipos, se solicita el __usuario__ y __contraseña__ SSH de un usuario que tenga permisos de __superusuario__(root).

El enfoque de Aton es la __usabilidad__, por lo que la interfaz de usuario es sencilla, intuitiva y sin opciones complejas.

## Advertencia
Este proyecto todavía se encuentra en fase de desarrollo, no se recomienda su uso en producción.

## Como instalar
### 1. Descargar una copia de este proyecto
```bash
git clone https://github.com/ProjectAton/AtonScala.git
```

### 2. Instalar postgresql. Ir al paso 4 si ya se tiene configurado PostgreSQL.

Instalar la base de datos PostgreSQL, usando el gestor de paquetes por defecto o con cualquier otro método.

**Instalación en Ubuntu - Debian**

```bash
sudo apt-get install postgresql
```

**Instalación en RHEL**

```bash
sudo yum install postgresql-server
```

### 3. Asignar un password para acceder a PostgreSQL:

**Ingresar al shell de PostgreSQL:**

```bash
sudo -u postgres psql
```

**Ejecutar para cambiar el password**

```bash
\password postgres
```

### 4. Importar la base de datos de database.sql
```bash
sudo -u postgres psql < database.sql
```

### 5. Modificar los archivos de configuración

#### `src/main/resources/aplicacion.properties`
En este archivo se encuentran todas las configuraciones de la base de datos. Las propiedades importantes son las siguientes:

**jdbc.url**
En este campo se inserta el URL de la base de datos. El formato es *jdbc:postgresql://host:puerto/basededatos*

**jdbc.username**
Nombre de usuario para acceder a la base de datos.

**jdbc.password**
Contraseña para acceder a la base de datos.

### 6. Compilar
Si no se tiene instalado maven instalar antes de este paso.

**Instalación en Ubuntu - Debian**
```bash
sudo apt-get install maven
```

**Instalación en RHEL**
```bash
sudo yum install maven
```

Ejecutar la compilación con Maven

```bash
mvn clean install
```

##