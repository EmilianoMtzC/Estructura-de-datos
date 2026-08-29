# Sistema de gestión para cafetería

Proyecto académico en Java que utiliza estructuras de datos para administrar clientes, compras e inventario de una cafetería.

## Requisitos

- Java JDK 26.
- Gradle (el proyecto incluye `gradlew`, por lo que no es necesario instalar Gradle por separado).
- NetBeans, IntelliJ IDEA u otro IDE compatible con proyectos Gradle.

## Descargar el proyecto

Desde una terminal, clona el repositorio con:

```bash
git clone https://github.com/EmilianoMtzC/Estructura-de-datos
cd Estructura-De-Datos
```

También puedes descargar el proyecto como archivo ZIP desde el repositorio. Después, descomprime el archivo y abre la carpeta principal, donde se encuentra `build.gradle`.

## Abrir el proyecto

En NetBeans o IntelliJ IDEA, abre la carpeta raíz del proyecto. No abras únicamente la carpeta `src`, porque Gradle y las dependencias de JavaFX se configuran desde `build.gradle`.

## Ejecutar el programa

Desde la carpeta raíz ejecuta:

En Linux o macOS:

```bash
./gradlew run
```

En Windows:

```bat
gradlew.bat run
```

La aplicación debe ejecutarse mediante Gradle para que se incluyan automáticamente los componentes de JavaFX. Si se ejecuta directamente el archivo `App.java`, puede aparecer el mensaje de que faltan los componentes de JavaFX.

## Funciones disponibles

La ventana contiene tres pestañas:

- **Clientes:** agregar clientes a la fila, atenderlos y mostrar los clientes pendientes.
- **Compras:** registrar compras, eliminar la última compra y consultar el historial.
- **Inventario:** guardar productos con su cantidad, buscar productos y mostrar el inventario.

## Compilar y probar

Para comprobar que el código compila:

```bash
./gradlew clean test
```

El proyecto utiliza una pila para el historial de compras, una cola para la fila de clientes y una tabla hash para el inventario.
