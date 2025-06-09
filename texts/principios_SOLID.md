# Los **principios SOLID**

Los **principios SOLID** son un conjunto de reglas de diseño orientado a objetos (OOP) que buscan hacer el código más mantenible, escalable y fácil de entender.

---

## **1. Principio de Responsabilidad Única (SRP - Single Responsibility Principle)**
> *"Una clase debe tener una única razón para cambiar."*  

Cada clase debe encargarse de **una sola responsabilidad**. Si una clase hace demasiadas cosas, es más difícil de mantener.

### **Ejemplo en Java:**
#### ❌ **Incorrecto** (Violación de SRP)
```java
public class User {
    private String name;
    private String email;

    // Responsabilidad 1: Almacenar datos del usuario
    public void saveUserToDatabase(User user) {
        // Lógica para guardar en BD...
    }

    // Responsabilidad 2: Enviar email
    public void sendEmail(String message) {
        // Lógica para enviar email...
    }
}
```
**Problema**: La clase `User` maneja tanto la **persistencia** como el **envío de emails**.

#### ✅ **Correcto** (Cumple SRP)
```java
public class User {
    private String name;
    private String email;
    // Solo maneja datos del usuario.
}

public class UserRepository {
    public void saveUserToDatabase(User user) {
        // Lógica para guardar en BD...
    }
}

public class EmailService {
    public void sendEmail(User user, String message) {
        // Lógica para enviar email...
    }
}
```
**Beneficio**: Cada clase tiene **una única responsabilidad**.

---

## **2. Principio de Abierto/Cerrado (OCP - Open/Closed Principle)**
> *"Las entidades deben estar abiertas para extensión, pero cerradas para modificación."*  

Debemos poder **añadir nuevas funcionalidades** sin modificar el código existente.

### **Ejemplo en Java:**
#### ❌ **Incorrecto** (Violación de OCP)
```java
public class AreaCalculator {
    public double calculateArea(Object shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        } else if (shape instanceof Square) {
            Square square = (Square) shape;
            return square.getSide() * square.getSide();
        }
        throw new IllegalArgumentException("Forma no soportada");
    }
}
```
**Problema**: Cada vez que añadimos una nueva forma (ej. `Triangle`), hay que modificar `AreaCalculator`.

#### ✅ **Correcto** (Cumple OCP con **interfaces**)
```java
public interface Shape {
    double calculateArea();
}

public class Circle implements Shape {
    private double radius;

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class Square implements Shape {
    private double side;

    @Override
    public double calculateArea() {
        return side * side;
    }
}

public class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea(); // No necesita modificarse para nuevas formas.
    }
}
```
**Beneficio**: Para añadir `Triangle`, solo implementamos `Shape` sin tocar `AreaCalculator`.

---

## **3. Principio de Sustitución de Liskov (LSP - Liskov Substitution Principle)**
> *"Las clases derivadas deben poder sustituir a sus clases base sin alterar el comportamiento."*  

Si una clase `B` hereda de `A`, deberíamos poder usar `B` donde esperamos `A` sin problemas.

### **Ejemplo en Java:**
#### ❌ **Incorrecto** (Violación de LSP)
```java
public class Bird {
    public void fly() {
        System.out.println("Volando...");
    }
}

public class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("¡Los pingüinos no vuelan!");
    }
}

// Uso:
Bird bird = new Penguin();
bird.fly(); // ¡Lanza excepción! Rompe el principio.
```
**Problema**: `Penguin` no puede reemplazar a `Bird` porque no vuela.

#### ✅ **Correcto** (Cumple LSP)
```java
public class Bird {
    // Comportamiento común...
}

public class FlyingBird extends Bird {
    public void fly() {
        System.out.println("Volando...");
    }
}

public class Penguin extends Bird {
    // No implementa fly(), pero no rompe el contrato.
}
```
**Beneficio**: Ahora `Penguin` no hereda `fly()`, evitando comportamientos inesperados.

---

## **4. Principio de Segregación de Interfaces (ISP - Interface Segregation Principle)**
> *"Los clientes no deben depender de interfaces que no usan."*  

Es mejor tener **varias interfaces pequeñas** que una grande con métodos innecesarios.

### **Ejemplo en Java:**
#### ❌ **Incorrecto** (Violación de ISP)
```java
public interface Worker {
    void work();
    void eat();
    void sleep();
}

public class Robot implements Worker {
    @Override
    public void work() { /* OK */ }

    @Override
    public void eat() { throw new UnsupportedOperationException(); } // ¡Los robots no comen!

    @Override
    public void sleep() { throw new UnsupportedOperationException(); } // ¡Los robots no duermen!
}
```
**Problema**: `Robot` está obligado a implementar métodos que no necesita.

#### ✅ **Correcto** (Cumple ISP)
```java
public interface Workable {
    void work();
}

public interface Eatable {
    void eat();
}

public interface Sleepable {
    void sleep();
}

public class Human implements Workable, Eatable, Sleepable {
    // Implementa todos los métodos...
}

public class Robot implements Workable {
    @Override
    public void work() { /* Solo trabaja */ }
}
```
**Beneficio**: Cada clase implementa **solo lo que necesita**.

---

## **5. Principio de Inversión de Dependencias (DIP - Dependency Inversion Principle)**
> *"Depende de abstracciones, no de implementaciones concretas."*  

Los módulos de alto nivel no deben depender de los de bajo nivel, sino de **interfaces/abstractciones**.

### **Ejemplo en Java:**
#### ❌ **Incorrecto** (Violación de DIP)
```java
public class MySQLDatabase {
    public void saveData(String data) {
        System.out.println("Guardando en MySQL: " + data);
    }
}

public class App {
    private MySQLDatabase database; // Dependencia concreta.

    public App() {
        this.database = new MySQLDatabase(); // Acoplado a MySQL.
    }

    public void save(String data) {
        database.saveData(data);
    }
}
```
**Problema**: Si cambiamos a `PostgreSQL`, hay que modificar `App`.

#### ✅ **Correcto** (Cumple DIP con **inyección de dependencias**)
```java
public interface Database {
    void save(String data);
}

public class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Guardando en MySQL: " + data);
    }
}

public class PostgreSQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Guardando en PostgreSQL: " + data);
    }
}

public class App {
    private Database database; // Dependencia abstracta.

    public App(Database database) { // Inyección de dependencia.
        this.database = database;
    }

    public void save(String data) {
        database.save(data);
    }
}

// Uso:
Database db = new PostgreSQLDatabase();
App app = new App(db); // Fácil cambiar de MySQL a PostgreSQL.
```
**Beneficio**: `App` no sabe qué base de datos se usa, solo depende de la interfaz `Database`.

---

## **Conclusión**
- **SRP**: Una clase, una responsabilidad.  
- **OCP**: Extiende sin modificar.  
- **LSP**: Las subclases deben ser sustituibles.  
- **ISP**: Interfaces pequeñas y específicas.  
- **DIP**: Depende de abstracciones, no de implementaciones.  

Aplicar SOLID mejora la **calidad del código**, haciéndolo más **flexible, mantenible y testeable**. 🚀