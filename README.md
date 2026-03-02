[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[POSTGRES_BADGE]:https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white
[DOCKER_BADGE]:https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white

<h1 align="center" style="font-weight: bold;">API Cursos 🎓</h1>

![java][JAVA_BADGE]
![spring][SPRING_BADGE]
![postgres][POSTGRES_BADGE]
![docker][DOCKER_BADGE]

<details open="open">
<summary>Índice</summary>

- [🚀 Como executar](#started)
  - [Pré-requisitos](#prerequisites)
  - [Clonando](#cloning)
  - [Variáveis de Ambiente](#env)
  - [Iniciando](#starting)
- [📍 Endpoints da API](#routes)
  - [Cursos](#courses)
- [🤝 Colaboradores](#colab)
- [📫 Contribua](#contribute)

</details>

<p align="center">
  <b>Uma API RESTful para gerenciamento de cursos desenvolvida com Spring Boot e PostgreSQL. Permite criar, listar, atualizar, ativar/desativar e remover cursos, com suporte a busca por nome e/ou categoria.</b>
</p>

<h2 id="started">🚀 Como executar</h2>

<h3 id="prerequisites">Pré-requisitos</h3>

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/)
- [Git](https://git-scm.com/)

<h3 id="cloning">Clonando</h3>

```bash
git clone https://github.com/seu-usuario/api-cursos.git
```

<h3 id="env">Variáveis de Ambiente</h3>

As configurações do banco de dados estão em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/api_cursos
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
```

<h3 id="starting">Iniciando</h3>

Primeiro, suba o banco de dados com o Docker Compose:

```bash
cd api-cursos
docker-compose up -d
```

Em seguida, inicie a aplicação:

```bash
./mvnw spring-boot:run
```

A aplicação será iniciada em `http://localhost:8080`.

<h2 id="routes">📍 Endpoints da API</h2>

### Cursos

| Rota | Descrição |
|------|-----------|
| `POST /course/` | Cria um novo curso |
| `GET /course/` | Lista todos os cursos |
| `GET /course/?name={name}` | Busca curso por nome |
| `GET /course/?category={category}` | Busca cursos por categoria |
| `GET /course/?name={name}&category={category}` | Busca cursos por nome e categoria |
| `POST /course/{id}` | Atualiza nome e/ou categoria de um curso |
| `PATCH /course/{id}` | Ativa ou desativa um curso |
| `DELETE /course/{id}` | Remove um curso |

**POST /course/ — Requisição**
```json
{
  "name": "Java com Spring Boot",
  "category": "Back-end"
}
```

**POST /course/ — Resposta**
```json
{
  "id": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
  "name": "Java com Spring Boot",
  "category": "Back-end",
  "active": "ACTIVE",
  "created_at": "2024-01-01T10:00:00",
  "updated_at": "2024-01-01T10:00:00"
}
```

**GET /course/ — Resposta**
```json
[
  {
    "id": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
    "name": "Java com Spring Boot",
    "category": "Back-end",
    "active": "ACTIVE",
    "created_at": "2024-01-01T10:00:00",
    "updated_at": "2024-01-01T10:00:00"
  }
]
```

**PATCH /course/{id} — Resposta**
```
"Curso ativado"
// ou
"Curso desativado"
```
