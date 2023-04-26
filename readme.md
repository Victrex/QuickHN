# Instrucciones para ejecutar el servidor SpringBoot

Estas instrucciones detallan los pasos necesarios para ejecutar un servidor SpringBoot utilizando SQL Server como base de datos y NetBeans como IDE. A continuación, se describen los pasos necesarios.

## Requisitos

Antes de comenzar, asegúrese de tener lo siguiente:

- SQL Server instalado y configurado con el puerto 1433 habilitado
- JDK 17 instalado en su sistema https://download.oracle.com/java/17/archive/jdk-17.0.7_windows-x64_bin.exe
- IDE NetBeans instalado en su sistema
- Plugin NBSpringBoot instalado en su NetBeans

## Configuración de la base de datos

Para crear la base de datos y sus inserts, ejecute los scripts de SQL Server proporcionados. Asegúrese de tener acceso de administrador a SQL Server y ejecute los scripts en orden.

¡Tiene razón! Aquí están los pasos para instalar el plugin NBSpringBoot en NetBeans en formato markdown:

## Instrucciones para instalar el plugin NBSpringBoot en NetBeans

Pasos necesarios para instalar el plugin NBSpringBoot en NetBeans para poder ejecutar y depurar aplicaciones SpringBoot desde NetBeans.

### Pasos para instalar el plugin

1. Abra NetBeans y haga clic en `Tools` -> `Plugins`.
2. En la pestaña `Available Plugins`, busque `NBSpringBoot` en la barra de búsqueda.
3. Seleccione el complemento `NBSpringBoot` y haga clic en `Install`.
4. Siga las instrucciones en pantalla para completar la instalación.
5. Una vez que se complete la instalación, reinicie NetBeans para que los cambios surtan efecto.

Una vez que haya instalado el complemento NBSpringBoot, debería ver nuevas opciones en el menú de contexto del proyecto, como `Run Spring Boot App` y `Debug Spring Boot App`, que le permitirán ejecutar y depurar su aplicación SpringBoot desde NetBeans.


## Configuración de la aplicación

Abra NetBeans y haga clic en "File" -> "Open Project". Seleccione el proyecto SpringBoot que desea ejecutar.

A continuación, asegúrese de que las propiedades de application.properties estén configuradas correctamente para conectarse a la base de datos de SQL Server que ha creado previamente.

## Ejecución del servidor

Una vez que se hayan completado los pasos anteriores, puede ejecutar el servidor SpringBoot en NetBeans.

Seleccione el proyecto y ejecute un clean and build, luego haga click en Run.

para acceder al servidor utilizará la dirección

localhost:8080