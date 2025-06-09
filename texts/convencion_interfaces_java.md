
# La convención "-able"

La convención de usar "-able" (como `Runnable`, `Serializable`, `Comparable`) es común en Java, pero no es una regla absoluta ni siempre la más lógica. Las interfaces deben nombrarse de manera que describan claramente su propósito, y a veces eso no encaja con el sufijo "-able".

### Casos donde "-able" funciona bien:
- Cuando la interfaz describe una capacidad intrínseca del objeto:
  - `Runnable`: puede ser ejecutado (run).
  - `Comparable`: puede ser comparado.
  - `Serializable`: puede ser serializado.

### Casos donde "-able" no es ideal:
- Cuando la interfaz define un rol o comportamiento activo (no pasivo):
  - `BlackBoardCommand`: describe un comando que actúa sobre una pizarra (mejor que `Executable` o `Rollbackable`).
  - `List` (en lugar de `Listable`): define un contrato para una lista, no una capacidad pasiva.
  - `Observer` (en lugar de `Observable`): define un rol activo (el que observa).

### Ejemplo: `BlackBoardCommand`
- **Correcto**: Si la interfaz agrupa los métodos `execute()` y `rollback()`, `BlackBoardCommand` es un nombre claro y conciso. No necesitas separarlo en `Executable`/`Rollbackable`.
- **Ventaja**: El nombre refleja el **rol** del objeto (un comando) y su ámbito (pizarra), sin limitarse a describir capacidades sueltas.

### Alternativas si prefieres usar sufijos:
- Si la interfaz fuera solo para ejecución: `BlackBoardExecutable`.
- Si fuera solo para revertir: `BlackBoardRollbackable`.
Pero esto fragmenta el diseño y no es práctico.

### Conclusión:
Java usa "-able" en interfaces que describen capacidades pasivas (lo que el objeto "puede sufrir o hacer"), pero no es obligatorio. Para comportamientos activos o roles complejos, es mejor usar nombres que describan el propósito (como `Command`, `Service`, `Handler`, etc.). 

**Recomendación**:  
Usa `BlackBoardCommand` (sin "-able") porque:
1. Es más descriptivo del rol.
2. Evita la fragmentación innecesaria.
3. Sigue el principio de cohesión (agrupa métodos relacionados).

## ¿Y si la convertimos en una clase?

Podría argumentarse que en nuestro ejemplo, BlackBoardCommand debería ser una clase, pero como en Java no hay herencia múltiple, muchas veces estamos limitados por ese hecho y si algunas clases que se necesita que implementen determinada firma tienen superclases distintas, no se puede implementar de ese modo.
Ese es un argumento clave para justificar el uso de una **interfaz** en lugar de una clase abstracta en tu ejemplo (`BlackBoardCommand`). Vamos a desglosarlo:

---

### **1. Problema con las clases abstractas: Herencia múltiple**
Java no soporta herencia múltiple de clases, por lo que si:
- Algunas clases que deben ser comandos ya heredan de otra superclase (ej. `Thread`, `AbstractController`, etc.), **no podrían** extender también una clase abstracta `BlackBoardCommand`.
- Las interfaces sí permiten "implementar" múltiples contratos sin este conflicto.

**Ejemplo:**
```java
public class FileUploadCommand extends HttpServlet implements BlackBoardCommand { 
    // OK: HttpServlet es clase, BlackBoardCommand es interfaz.
}

// Con clase abstracta sería IMPOSIBLE:
public class FileUploadCommand extends HttpServlet, AbstractBlackBoardCommand { 
    // ERROR: Java no permite herencia múltiple.
}
```

---

### **2. Interfaz vs. Clase abstracta: Flexibilidad**
- **Interfaz**:
  - Define un **contrato** (qué debe hacer el objeto).
  - Permite que clases heterogéneas (sin relación jerárquica) compartan comportamiento.
  - Ejemplo: `Runnable` lo implementan tanto `Thread` como clases de negocio arbitrarias.

- **Clase abstracta**:
  - Define **estado + comportamiento común** (cómo lo hace).
  - Útil cuando hay lógica compartida que puede reutilizarse (ej. métodos implementados).

En tu caso, `BlackBoardCommand` es un **contrato puro** (`execute()`, `rollback()`), por lo que una interfaz es la opción natural.

---

### **3. Nomenclatura: ¿Por qué no "-able"?**
Como mencionaste, el sufijo `-able` sugiere una capacidad pasiva ("puede ser X"), pero:
- `BlackBoardCommand` es un **rol activo** (un comando que "actúa" sobre algo).
- El nombre refleja mejor su propósito semántico:
  - **"Command"**: Patrón de diseño reconocible (encaja con `execute()`/`rollback()`).
  - **"BlackBoard"**: Contexto específico (no genérico como `-able`).

**Alternativa con "-able"** (menos intuitiva):
```java
interface Executable { void execute(); }
interface Rollbackable { void rollback(); }

// Problema: ahora la clase debe implementar DOS interfaces:
class FileUploadCommand implements Executable, Rollbackable { ... }
```
Esto fragmenta el diseño y pierde la relación conceptual entre `execute()` y `rollback()`.

---

### **4. Ejemplo en el mundo real**
Java mismo rompe la regla "-able" cuando corresponde:
- `java.util.Iterator` (no `Iterable`, que es otra interfaz).
- `java.sql.Connection` (no `Connectable`).
- `javax.servlet.Servlet` (no `Runnable` o `Executable`).

---

### **Conclusión Final**
Usar `BlackBoardCommand` como interfaz es correcto porque:
1. **Evita la limitación de herencia múltiple** de Java.
2. **Describe un rol** (no una capacidad pasiva).
3. **Agrupa métodos relacionados** coherentemente (mejor que separarlos en interfaces con "-able").
4. **Sigue el principio de segregación de interfaces** (ISP): Si alguien solo necesita `execute()`, podrías dividirlo en sub-interfaces más adelante, pero sin sacrificar la cohesión inicial.

Las convenciones son útiles, pero no deben forzar un modelo menos expresivo.
