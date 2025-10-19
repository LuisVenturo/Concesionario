# 🚗 SISTEMA DE GESTIÓN DE CONCESIONARIO DE VEHÍCULOS

> 💡 *Proyecto educativo desarrollado en Java sin base de datos (por ahora), con una estructura escalable y preparada para futuras ampliaciones.*

---

## 📘 Descripción General

Este proyecto implementa un **sistema completo de gestión para un concesionario de vehículos**, aplicando de manera práctica los principios de la **Programación Orientada a Objetos (POO)**.

Permite **administrar vehículos, clientes y ventas**, demostrando el uso de conceptos como abstracción, herencia, polimorfismo, encapsulamiento y composición de clases.

> 🧱 Actualmente funciona completamente en memoria (sin BD), pero su diseño modular lo hace **escalable**, permitiendo futuras integraciones con:
> - Persistencia en base de datos (JPA, JDBC, Hibernate)
> - API REST con Spring Boot
> - Interfaz gráfica con JavaFX o Swing
> - Almacenamiento en archivos o JSON

---

## 🎯 Objetivos de Aprendizaje

- Comprender cómo diseñar un sistema orientado a objetos desde cero.  
- Aplicar correctamente **clases abstractas**, **herencia** y **polimorfismo**.  
- Utilizar **encapsulamiento**, **constructores**, **atributos estáticos** y **constantes**.  
- Implementar relaciones **uno a muchos** (Concesionario → Vehículos / Clientes).  
- Desarrollar un flujo de ejecución completo con **validaciones, reportes y operaciones.**

---

## 🧩 Estructura del Proyecto

```

src/
└── domain/
├── Vehiculo.java              # Clase abstracta base
├── Auto.java                  # Subclase de Vehiculo
├── Motocicleta.java           # Subclase de Vehiculo
├── Camioneta.java             # Subclase de Vehiculo
├── Cliente.java               # Representa un cliente del concesionario
├── Concesionario.java         # Gestiona vehículos, clientes y ventas
└── SistemaConcesionario.java  # Clase principal con el método main

````

---

## ⚙️ Clases Principales

<details>
<summary>🔹 Vehiculo (Clase abstracta)</summary>

- Clase base que define atributos y comportamientos comunes de todos los vehículos.  
- Contiene métodos concretos (como `marcarComoVendido`, `aplicarDescuento`) y abstractos (`obtenerTipoVehiculo`, `obtenerDetalles`).

**Conceptos aplicados:** Abstracción, encapsulamiento, herencia.

</details>

<details>
<summary>🔹 Auto / Motocicleta / Camioneta</summary>

- Heredan de `Vehiculo` e implementan los métodos abstractos.  
- Cada subclase agrega atributos específicos (puertas, cilindrada, tracción, etc.) y métodos únicos.  
- Implementan polimorfismo a través del método `obtenerDetalles()`.

**Conceptos aplicados:** Herencia, polimorfismo, especialización.

</details>

<details>
<summary>🔹 Cliente</summary>

- Representa a los compradores del concesionario.  
- Controla el presupuesto, las compras realizadas y el total de clientes creados.  
- Incluye un atributo estático `totalClientes`.

**Conceptos aplicados:** Encapsulamiento, métodos estáticos, sobreescritura de `toString()`.

</details>

<details>
<summary>🔹 Concesionario</summary>

- Clase principal que **gestiona todo el sistema**: vehículos, clientes y ventas.  
- Usa arrays fijos para simular una base de datos (vehículos y clientes).  
- Implementa las operaciones de registro, búsqueda, venta, reportes y descuentos.

**Conceptos aplicados:** Composición, validación, reutilización de código, constantes.

</details>

<details>
<summary>🔹 SistemaConcesionario (Main)</summary>

- Contiene el método `main` que ejecuta el flujo completo:
  1. Crear el concesionario  
  2. Agregar vehículos y clientes  
  3. Aplicar descuentos  
  4. Realizar ventas  
  5. Mostrar reportes finales  

**Conceptos aplicados:** Ejecución del flujo de negocio y pruebas del sistema.

</details>

---

## 💻 Ejemplo de Uso (Main)

```java
public class SistemaConcesionario {
    public static void main(String[] args) {
        // Paso 1: Crear el concesionario
        Concesionario concesionario = new Concesionario("AutoExpress Premium");

        // Paso 2: Crear y agregar vehículos
        Auto auto1 = new Auto("Toyota", "Corolla", 2023, 25000.0, 15000, 4, "Automática", true);
        Auto auto2 = new Auto("Honda", "Civic", 2022, 22000.0, 20000, 2, "Manual", false);
        Motocicleta moto1 = new Motocicleta("Yamaha", "R3", 2023, 8000.0, 5000, 321, "Deportiva", false);

        concesionario.agregarVehiculo(auto1);
        concesionario.agregarVehiculo(auto2);
        concesionario.agregarVehiculo(moto1);

        // Paso 3: Registrar clientes
        Cliente cliente1 = new Cliente("Luis Venturo", "12345678", "987654321", 30000.0);
        concesionario.registrarCliente(cliente1);

        // Paso 4: Mostrar inventario inicial
        concesionario.mostrarInventario();

        // Paso 5: Realizar una venta
        concesionario.realizarVenta("12345678", "Toyota", "Corolla");

        // Paso 6: Generar reporte final
        concesionario.generarReporte();
    }
}
````

---

## 📊 Ejemplo de Salida

```
✓ Vehículo agregado: Toyota Corolla
✓ Cliente registrado: Luis Venturo
Inventario del concesionario AutoExpress Premium:
--------------------------------------------------
[AUTOMÓVIL] Toyota Corolla (2023) - $25000.0 - DISPONIBLE
[AUTOMÓVIL] Honda Civic (2022) - $22000.0 - DISPONIBLE
[MOTOCICLETA] Yamaha R3 (2023) - $8000.0 - DISPONIBLE
--------------------------------------------------

✓ Vehículo vendido: Toyota Corolla
Compra realizada por Luis Venturo - Monto: $25000.0
Comisión generada: $750.0

--- REPORTE FINAL ---
Vehículos totales: 3
Vendidos: 1 | Disponibles: 2
Clientes registrados: 1
Vehículo más caro: Toyota Corolla - $25000.0
Vehículo más barato: Yamaha R3 - $8000.0
Total recaudado: $25000.0
```

---

## 🧠 Temas Clave que Refuerza este Ejercicio

| Concepto                   | Descripción                                                             |
| -------------------------- | ----------------------------------------------------------------------- |
| **Abstracción**            | Se define la clase `Vehiculo` como base conceptual.                     |
| **Herencia**               | Las subclases heredan y personalizan comportamiento.                    |
| **Polimorfismo**           | Se manipulan distintos tipos de vehículos desde referencias `Vehiculo`. |
| **Encapsulamiento**        | Atributos privados con acceso controlado mediante getters/setters.      |
| **Composición**            | El `Concesionario` agrupa objetos `Vehiculo` y `Cliente`.               |
| **Constantes y Estáticos** | Uso de `final` y `static` para valores comunes o contadores.            |
| **Escalabilidad**          | Estructura lista para crecer a BD, servicios REST o GUI.                |

---

## 🧰 Posibles Extensiones

* 💾 **Persistencia en base de datos:** agregar repositorios con JPA o JDBC.
* 🌐 **API REST:** migrar la lógica a un proyecto Spring Boot.
* 🖥️ **Interfaz gráfica:** implementar con JavaFX o Swing.
* 📄 **Exportar reportes:** generar PDF o Excel.
* 🧮 **Colecciones dinámicas:** reemplazar arrays por `ArrayList` o `HashMap`.

---

## 🧑‍🏫 Guía

1. Clona o descarga el repositorio.
2. Abre el proyecto en **IntelliJ IDEA** o **Eclipse**.
3. Compila y ejecuta la clase `SistemaConcesionario.java`.
4. Lee los comentarios en el código: cada sección está documentada paso a paso.
5. Experimenta:

   * Agrega más vehículos o clientes.
   * Modifica precios y aplica descuentos.
   * Intenta realizar ventas con errores para probar validaciones.

---

## 👨‍💻 Autor

**Luis Venturo**
Backend Developer | Java & Spring Boot
> 💬 “Este proyecto fue desarrollado como ejemplo educativo para practicar y enseñar los fundamentos de la Programación Orientada a Objetos en Java.”

---

## 🧩 Licencia

Este proyecto es de libre uso educativo.
Puedes adaptarlo, ampliarlo o integrarlo a tus propias prácticas y ejercicios.
Puede considerarse escalable, para poderlo integrar con BD y Web
