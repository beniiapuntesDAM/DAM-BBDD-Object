# DAM-BBDD-Object
<img src="https://static.vecteezy.com/system/resources/previews/029/345/981/non_2x/database-icon-data-analytics-icon-monitoring-big-data-analysis-containing-database-free-png.png" alt="Descripción de la imagen" width="300"/>


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

git clone https://github.com/tu_usuario/DAM-BBDD-Object.git
cd DAM-BBDD-Object


### 2. **Configurar y ejecutar PostgreSQL con Docker

El archivo docker-compose.yml ya está configurado para levantar tanto el contenedor de PostgreSQL como PgAdmin.
]**2.1 Levantar los contenedores de Docker**

Para iniciar los servicios de PostgreSQL y PgAdmin, ejecuta el siguiente comando en el directorio donde tienes el archivo docker-compose.yml:

docker-compose up -d



# Bases de Datos Objeto-Relacionales y Bases de Datos Orientadas a Objetos

## Ejemplo Práctico: Cuándo Usar Cada Tipo de Base de Datos

### 1. Base de Datos Objeto-Relacional (como un almacén)
<img src="https://w7.pngwing.com/pngs/7/117/png-transparent-warehouse-box-warehouse-miscellaneous-building-warehouse.png" alt="Descripción de la imagen" width="300"/>

**Contexto**: Imagina que eres el gerente de un almacén grande que vende productos. En este almacén hay diferentes tipos de productos, como electrónicos, ropa y alimentos. Necesitas organizar toda esta información de manera que puedas buscar rápidamente productos, hacer cálculos de precios, encontrar inventario y mucho más.

**Cómo funciona la base de datos objeto-relacional en este caso**:
- Los **productos** se representan como **filas en tablas**. Por ejemplo, hay una tabla llamada "Productos", con columnas como "Nombre", "Categoría", "Precio", "Cantidad en Inventario", etc.
- Cada tipo de producto puede tener algunas diferencias (como dimensiones para electrónicos o fecha de caducidad para alimentos), y esas diferencias se pueden manejar con extensiones adicionales (relaciones con otras tablas).
- Es fácil hacer consultas estructuradas, como encontrar todos los productos de la categoría "Electrónica" que cuesten menos de 50 euros.
- **Caso de uso ideal**: Si tu principal necesidad es manejar mucha información estructurada de manera muy ordenada y necesitas hacer consultas rápidas y operaciones sobre los datos (como calcular totales o buscar productos), una base de datos objeto-relacional es ideal.

**Analógico**: La base de datos es como tener todos los productos de tu almacén organizados cuidadosamente en estanterías, donde cada estantería y etiqueta facilita encontrar y clasificar cosas.

---

### 2. Base de Datos Orientada a Objetos (como una colección de juguetes)
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvTP46JUcCuy6FgFZSEOWT0vbjW4jcyN4p9CWTMaRjbRkVMw0dImkQenPXSDJ0eTnGxSo&usqp=CAU" alt="Descripción de la imagen" width="300"/>


**Contexto**: Imagina que eres un coleccionista de juguetes muy detallista, y tienes juguetes de diferentes tipos. Algunos juguetes tienen múltiples partes móviles, otros pueden "interactuar" entre sí o tener características complejas, como luces y sonidos.

**Cómo funciona la base de datos orientada a objetos en este caso**:
- Los **juguetes** se tratan como **objetos reales**, con todos sus detalles incluidos. Por ejemplo, cada cochecito de juguete tiene sus propias ruedas, puertas y colores, y puede contener funcionalidades, como "sonido cuando se presiona un botón".
- Cuando guardas un cochecito en esta base de datos, no necesitas descomponerlo en piezas; puedes guardarlo como un todo, con sus propiedades y comportamientos.
- Si quieres hacer cambios, puedes simplemente modificar el objeto (por ejemplo, cambiar el color del coche), y el sistema actualiza todo el objeto sin tener que reconstruirlo desde piezas separadas.
- **Caso de uso ideal**: Si estás manejando datos complejos con relaciones internas y comportamientos únicos (como videojuegos, simulaciones o datos que tienen estructura y comportamientos que se deben mantener), una base de datos orientada a objetos es perfecta.

**Analógico**: Es como tener tus juguetes en cajas, y cada caja guarda todas las partes y funciones del juguete. Si quieres cambiar algo, puedes abrir la caja y modificarlo directamente sin tener que desarmar todas las piezas o buscar en varias cajas separadas.

---

### Resumen de Cuándo Usar Cada Tipo de Base de Datos

- **Base de datos objeto-relacional**: Úsala cuando necesites organizar grandes cantidades de datos de forma estructurada, hacer consultas rápidas y manejar relaciones entre tablas (como un almacén bien organizado).
- **Base de datos orientada a objetos**: Úsala cuando necesites manejar datos complejos que tengan características únicas y relaciones jerárquicas (como juguetes en una colección compleja que deben conservar su estructura interna).

