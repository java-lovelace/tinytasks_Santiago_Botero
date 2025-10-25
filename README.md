# 🧩 ProjectSync — Gestión y Trazabilidad de Proyectos

## 📖 Descripción
**ProjectSync** es una aplicación desarrollada con **Spring Boot** que permite registrar, administrar y realizar seguimiento a los proyectos activos dentro de una organización.  

## 🧱 Arquitectura
El sistema sigue el patrón de **arquitectura por capas**, dividiendo responsabilidades en:
- **Capa Controller:** Gestiona las peticiones HTTP y respuestas REST.
- **Capa Service:** Contiene la lógica de negocio y validaciones.
- **Capa Repository:** Maneja la persistencia de datos en memoria (para esta versión inicial).
- **Modelo (Entities):** Define las estructuras de datos del dominio del proyecto.

## ⚙️ Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Maven**
- **JUnit 5** (para pruebas unitarias)
- **Bootstrap / Tailwind CSS** (interfaz básica)
- **Azure DevOps** (control de versiones, gestión de tareas y trazabilidad)
- **Git** (versionamiento)

## 📋 Funcionalidades Principales
- Crear, listar, actualizar y eliminar proyectos (CRUD completo).
- Validaciones básicas sobre datos de entrada.

## 🧩 Estructura del Proyecto

<img width="573" height="919" alt="image" src="https://github.com/user-attachments/assets/78cb3aca-9d57-48cb-ad7c-3e5eebcc62c3" />


## 🚀 Ejecución del Proyecto
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/java-lovelace/tinytasks_Santiago_Botero
Entrar al directorio del proyecto:
Compilar y ejecutar:


mvn spring-boot:run
Acceder en el navegador:

http://localhost:8080
🧪 Pruebas Unitarias
Ejecutar:

mvn test
Las pruebas validan la lógica central del servicio de proyectos.
