# 📦 Demo Order - API de Pedidos

API REST para cadastro e consulta de pedidos desenvolvida com Spring Boot 3.

## 🛠️ Tecnologias

- Java 21
- Spring Boot 3.0.9
- Spring Data JPA
- Spring Cloud OpenFeign
- H2 Database (em memória)
- MapStruct
- Lombok
- SpringDoc OpenAPI (Swagger)

---



### Pré-requisitos

- Java 21+
- Maven 3.8+

### Passos

```bash
# 1. Clone o repositório
git clone <url-do-repositorio>
cd demo

# 2. Compile o projeto
mvn clean install

# 3. Execute a aplicação
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

---

## 📚 Documentação da API (Swagger)

Após iniciar a aplicação, acesse:

| Recurso | URL                                                 |
|---------|-----------------------------------------------------|
| Swagger UI | http://localhost:8080/v1/demo/swagger-ui/index.html |
| OpenAPI JSON | http://localhost:8080/v1/demo/api-doc               |

---

## 🗄️ Banco de Dados H2

Console disponível em: `http://localhost:8080/h2-console`

| Configuração | Valor |
|--------------|-------|
| JDBC URL | `jdbc:h2:mem:testdb` |
| Username | `sa` |
| Password | *(vazio)* |


---

## ⚙️ Configurações (application.yml)

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  h2:
    console:
      enabled: true
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true

springdoc:
  swagger-ui:
    path: /swagger-ui.html
    enabled: true
  api-docs:
    path: /api-docs
    enabled: true
```

---

## 🧪 Executar Testes

```bash
mvn test
```


## 👤 Autor - Bruno Abner da silva Santos.

Desenvolvido como projeto de demonstração Spring Boot 

---

## 📄 Licença

Este projeto está sob a licença MIT.