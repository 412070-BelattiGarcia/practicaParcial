## 🧹 Simulacro Parcial

### Sistema de Encuestas Web

Se debe desarrollar una **aplicación web fullstack** para gestionar **encuestas online** y sus **respuestas**. El
sistema permitirá:

- Crear encuestas con título y preguntas.
- Responder encuestas.
- Visualizar las estadísticas de respuestas.

---

## 🚀 BACKEND

### Requisitos

- Proyecto Spring Boot 3+.
- Capas: `Entity`, `DTO`, `Repository`, `Service`, `Controller`.
- Evitar uso de **ModelMapper** para conversión entre Entity y DTO.
- Base de datos: H2 embebida (persistente).
- Validación con anotaciones (`@NotNull`, `@NotBlank`, etc.).
- Uso de Spring Data JPA.

### Entidades

#### 📊 `Encuesta`

- `id` (Long)
- `titulo` (String)
- `preguntas` (List)

#### ❓ `Pregunta`

- `id` (Long)
- `contenido` (String)
- `encuesta` (Encuesta)

#### ✍️ `Respuesta`

- `id` (Long)
- `pregunta` (Pregunta)
- `contenido` (String)
- `fechaRespuesta` (LocalDateTime)

### Endpoints

#### Encuestas

- `GET /api/encuestas` → devuelve todas las encuestas (sin preguntas)
- `GET /api/encuestas/{id}` → devuelve la encuesta con sus preguntas
- `POST /api/encuestas` → crea una encuesta nueva con preguntas (opcional)

#### Respuestas

- `POST /api/respuestas` → recibe un `RespuestaDTO` con respuestas para una encuesta.
- `GET /api/encuestas/{id}/estadisticas` → devuelve cantidad de respuestas por pregunta.
- `GET /api/respuestas/hoy` → devuelve todas las respuestas registradas hoy.
- `GET /api/respuestas?desde=yyyy-MM-dd&hasta=yyyy-MM-dd` → filtra respuestas por rango de fechas.

### Ejemplos JSON para Backend

Estos son los formatos JSON que usarás para interactuar con tu API.

DTOs de Entrada y Salida
Para crear una Encuesta (POST /api/encuestas)
Cuando envías una nueva encuesta al sistema:

```json
{
  "titulo": "Encuesta de Satisfacción",
  "preguntas": [
    {
      "contenido": "¿Qué tal nuestro servicio?"
    },
    {
      "contenido": "¿Nos recomendarías?"
    }
  ]
}
```

Listado de Encuestas (GET /api/encuestas)
Lo que recibes al pedir la lista de encuestas:

```json
[
  {
    "id": 1,
    "titulo": "Encuesta de Satisfacción",
    "cantidadPreguntas": 2,
    "cantidadRespuestas": 10
  },
  {
    "id": 2,
    "titulo": "Encuesta de Producto X",
    "cantidadPreguntas": 3,
    "cantidadRespuestas": 5
  }
]
```

Detalle de una Encuesta (GET /api/encuestas/{id})
La información completa de una encuesta con sus preguntas:

```json
{
  "id": 1,
  "titulo": "Encuesta de Satisfacción",
  "preguntas": [
    {
      "id": 101,
      "contenido": "¿Qué tal nuestro servicio?"
    },
    {
      "id": 102,
      "contenido": "¿Nos recomendarías?"
    }
  ]
}
```

Para enviar Respuestas a una Encuesta (POST /api/respuestas)
El formato para enviar las respuestas de un usuario a una encuesta específica:

```json
{
  "encuestaId": 1,
  "respuestas": [
    {
      "preguntaId": 101,
      "contenido": "Excelente"
    },
    {
      "preguntaId": 102,
      "contenido": "Sí, claro"
    }
  ]
}
```

Estadísticas de una Encuesta (GET /api/encuestas/{id}/estadisticas)
Lo que obtienes al pedir las estadísticas de respuestas por pregunta:

```json
{
  "encuestaId": 1,
  "tituloEncuesta": "Encuesta de Satisfacción",
  "estadisticasPreguntas": [
    {
      "preguntaId": 101,
      "contenidoPregunta": "¿Qué tal nuestro servicio?",
      "cantidadTotalRespuestas": 10
    },
    {
      "preguntaId": 102,
      "contenidoPregunta": "¿Nos recomendarías?",
      "cantidadTotalRespuestas": 10
    }
  ]
}
```

---


