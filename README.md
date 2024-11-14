# DAM-BBDD-Object

Este proyecto muestra cómo crear y manipular una base de datos objeto-relacional utilizando **PostgreSQL** en **Docker** y **Java** para interactuar con la base de datos mediante JDBC.

## Descripción

En este repositorio se incluyen los pasos necesarios para levantar un contenedor de **PostgreSQL** mediante Docker, interactuar con la base de datos desde Java utilizando **JDBC** y realizar operaciones básicas como crear tablas, insertar datos y consultar la base de datos.

## Requisitos previos

Antes de empezar, necesitas tener instalados los siguientes programas:

1. **Docker**: [Instrucciones de instalación de Docker](https://docs.docker.com/get-docker/)
2. **Docker Compose**: [Instrucciones de instalación de Docker Compose](https://docs.docker.com/compose/install/)
3. **Java Development Kit (JDK)**: [Instrucciones de instalación de JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
4. **Visual Studio Code** o cualquier IDE de tu preferencia, como IntelliJ IDEA.

## Pasos para ejecutar el proyecto

### 1. **Clonar el repositorio**

Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/tu_usuario/DAM-BBDD-Object.git
cd DAM-BBDD-Object

### 2. Configurar y ejecutar PostgreSQL con Docker

El archivo docker-compose.yml ya está configurado para levantar tanto el contenedor de PostgreSQL como PgAdmin.
2.1 Levantar los contenedores de Docker

Para iniciar los servicios de PostgreSQL y PgAdmin, ejecuta el siguiente comando en el directorio donde tienes el archivo docker-compose.yml:

docker-compose up -d
