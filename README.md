# 📚 App Librería Online - Evaluación Final

**Desarrollo de la Interfaz de Usuario Android**

Esta aplicación es una librería online que permite a los usuarios explorar libros, filtrarlos por categoría, ver detalles de cada libro y agregarlos a un carrito de compras.".

🔗 **Repositorio en GitHub:** [github.com/N-Armijo/efm4](https://github.com/N-Armijo/efm4)
---

## ❓ Respuestas a Requerimientos Teóricos y Prácticos

### 1. Establecer el Contexto del Proyecto: Tecnologías y Herramientas Clave

En el desarrollo de aplicaciones móviles Android, se utilizan diversas tecnologías y herramientas que forman un ecosistema robusto y eficiente. Tres de las más importantes son:

*   **Android Studio:** Es el entorno de desarrollo integrado (IDE) oficial para Android. Proporciona un editor de código inteligente, un emulador de dispositivos, herramientas de depuración, un diseñador visual de interfaces (Layout Editor) y una integración perfecta con Gradle. Es la herramienta fundamental donde se escribe, prueba y depura todo el código de la aplicación.
*   **Lenguaje de Programación Java/Kotlin:** Java ha sido históricamente el lenguaje principal, pero Kotlin es ahora el lenguaje preferido y oficialmente recomendado por Google. Ambos permiten definir la lógica de la aplicación, manejar eventos de usuario, gestionar datos y controlar el flujo entre pantallas. En este proyecto, se utilizó Java por requerimiento específico.
*   **Gradle (Sistema de Compilación):** Es la herramienta que automatiza la compilación, el empaquetado y la gestión de dependencias del proyecto. A través del archivo `build.gradle`, se definen las bibliotecas externas necesarias (como `RecyclerView`, `CardView`, etc.), la versión mínima de Android compatible y otras configuraciones esenciales. Sin Gradle, sería muy complejo gestionar las librerías y construir el APK final.

### 2. Entorno de Desarrollo Android: Configuración Inicial del Proyecto

Para configurar un nuevo proyecto nativo en Android Studio, se siguieron estos pasos esenciales:

1.  **Tipo de Proyecto:** Se seleccionó la plantilla **“Empty Views Activity”**. Esta plantilla crea una actividad básica con una interfaz de usuario basada en vistas (XML), que es ideal para proyectos que no usan Jetpack Compose, permitiendo un control total sobre la estructura de la interfaz.
2.  **Nombre del Proyecto y Paquete:** Se definió el nombre de la aplicación como `LibreriaOnlineApp` y el nombre del paquete como `com.example.libreriaonlineapp`. El nombre del paquete es único y actúa como el identificador de la aplicación en el sistema Android y en Google Play.
3.  **Versión Mínima de Android (Min SDK):** Se estableció la versión mínima en **API 26: Android 8.0 (Oreo)**. Esta decisión se tomó para asegurar la compatibilidad con una amplia gama de dispositivos (cubriendo un 97,4% del mercado actual), mientras se tiene acceso a las APIs modernas necesarias para implementar componentes como `RecyclerView` y `CardView` sin limitaciones.

### 3. Elementos de Configuración del Proyecto: Manejo de Assets

Los “assets” o recursos en un proyecto Android incluyen imágenes, fuentes, archivos de audio, videos y otros archivos estáticos. Se manejan de la siguiente manera:

*   **Ubicación:** Se organizan dentro de la carpeta `app/src/main/res/`. Las imágenes se colocan en subcarpetas como `drawable-hdpi`, `drawable-xhdpi`, `drawable-xxhdpi` y `drawable-xxxhdpi`, según su densidad de píxeles. Esto permite que el sistema operativo elija automáticamente la imagen más adecuada para la pantalla del dispositivo del usuario.
*   **Optimización:** Es crucial optimizar estos recursos porque:
    *   **Rendimiento:** Imágenes demasiado grandes consumen mucha memoria RAM, lo que puede causar lentitud o incluso que la aplicación se cierre inesperadamente (crash).
    *   **Tamaño del APK:** Un APK grande tarda más en descargarse e instalar, lo que puede disuadir a los usuarios.
    *   **Experiencia de Usuario:** Imágenes no optimizadas pueden verse pixeladas en pantallas de alta densidad o borrosas en pantallas de baja densidad.
*   En este proyecto, las imágenes de portada de los libros se guardaron en formato `.jpg` (para reducir el tamaño) y se colocaron en la carpeta `drawable-xxxhdpi` para garantizar una excelente calidad en dispositivos modernos de alta resolución.

---

## 🎯 Funcionalidades Principales

1.  **Pantalla Principal (Inicio):**
    *   Muestra una lista de libros usando un `RecyclerView`.
    *   Cada libro se presenta en una tarjeta (`CardView`) con su portada (`ImageView`), título (`TextView`), descripción (`TextView`) y un botón para agregarlo al carrito (`Button`).
    *   Permite filtrar los libros por categoría (Fantasía, Ciencia Ficción, Infantil, etc.) desde la pestaña "Categorías".

2.  **Pantalla de Detalles:**
    *   Al hacer clic en un libro, se abre una nueva actividad (`DetalleLibroActivity`) que muestra la portada a mayor tamaño, el título, la descripción completa y un botón de "Comprar Ahora".
    *   Se implementa una barra de navegación superior con un botón "<" para regresar a la lista.

3.  **Carrito de Compras:**
    *   La pestaña "Carrito" muestra todos los libros que el usuario ha agregado.
    *   El carrito persiste mientras la app esté en memoria (implementado con un singleton `CarritoManager`).

4.  **Navegación:**
    *   Se utiliza un `BottomNavigationView` en la parte inferior para navegar entre las secciones principales: "Inicio", "Categorías" y "Carrito".
    *   La navegación a la pantalla de detalles se realiza mediante un `Intent`, pasando los datos del libro (título, descripción, imagen) como extras.

---

## 🚀 Cómo Ejecutar el Proyecto

1.  **Requisitos:**
    *   Tener instalado **Android Studio** (usamos la versión Narwhal).
    *   Tener configurado el **SDK de Android** (API 26 o superior).

2.  **Pasos:**
    1.  Clona este repositorio en tu máquina local:
        ```bash
        git clone https://github.com/N-Armijo/efm4.git
        ```
    2.  Abre Android Studio.
    3.  Selecciona **"Open an existing Android Studio project"**.
    4.  Navega hasta la carpeta del proyecto clonado y selecciónala.
    5.  Espera a que Android Studio sincronice los archivos Gradle.
    6.  Conecta un dispositivo físico o inicia un emulador.
    7.  Haz clic en el botón **"Run"** (▶️) en la barra de herramientas.

---

## 🛠️ Decisiones Clave de Desarrollo

*   **Arquitectura de Navegación:** Se optó por usar `Fragment` dentro de una `MainActivity` contenedora para gestionar las pestañas del `BottomNavigationView` ("Inicio", "Categorías", "Carrito"). Esto permite que la barra de navegación inferior permanezca visible y activa en todo momento, mejorando la experiencia de usuario. La pantalla de detalles, al ser un destino secundario, se implementó como una `Activity` separada, iniciada con un `Intent`, cumpliendo con el requerimiento específico de la evaluación.
*   **Gestión del Carrito:** Para permitir que el carrito sea accesible desde cualquier fragmento, se implementó una clase singleton `CarritoManager`. Esta clase actúa como un contenedor global y persistente (mientras dure la sesión de la app) para los libros agregados.
*   **Filtrado de Categorías:** El sistema de filtrado se diseñó para ser dinámico. Al seleccionar una categoría en el `CategoriasFragment`, se comunica con la `MainActivity`, que a su vez carga un nuevo `HomeFragment` pre-filtrado. Esto garantiza que el estado del filtro se mantenga incluso si el usuario navega a otras pestañas y regresa.
*   **Optimización de Assets:** Las imágenes de portada de los libros se colocaron en la carpeta `res/drawable-xxxhdpi` para garantizar una buena calidad en dispositivos de alta resolución. Se usaron formatos `.jpg` para optimizar el tamaño del APK.
*   **Convenciones de Código:** Se siguieron las buenas prácticas de nombrado, utilizando `snake_case` y prefijos semánticos para los IDs en los archivos XML (por ejemplo, `tv_titulo`, `btn_agregar`, `rv_libros`). Esto mejora la legibilidad y el mantenimiento del código.
*   **Manejo de Datos:** Los datos de los libros (título, descripción, categoría, imagen) se generan de forma estática en el código para este prototipo. En una app real, estos datos se obtendrían de una API o base de datos.

---

## 📸 Capturas de Pantalla

*Pantalla Principal*

<p align="center">
  <img src="capturas/pantalla_principal.png" alt="Pantalla Principal">
</p>

*Muestra la lista de libros en la pestaña "Inicio".*

<p align="center">
  <img src="capturas/pantalla_detalles.png" alt="Pantalla de Detalles">
</p>

*Muestra la información completa de un libro.*

<p align="center">
  <img src="capturas/pantalla_categorias.png" alt="Pantalla de Categorías">
</p>

*Permite al usuario filtrar los libros por género.*

<p align="center">
  <img src="capturas/pantalla_carrito.png" alt="Pantalla del Carrito">
</p>
*Muestra los libros que el usuario ha agregado.*

---

## 📁 Estructura del Proyecto

*   `app/src/main/java/`: Contiene todos los archivos Java (actividades, fragmentos, adaptadores, modelo).
*   `app/src/main/res/layout/`: Archivos XML de diseño de las interfaces.
*   `app/src/main/res/drawable-xxxhdpi/`: Imágenes de alta resolución (portadas de libros).
*   `app/src/main/res/menu/`: Archivo XML para el menú del `BottomNavigationView`.

---