# Avengers API 🚀

API REST para gerenciar **heróis Vingadores** com Spring Boot, Kotlin, PostgreSQL e Flyway.

## 🛠️ Tecnologias
Backend: Spring Boot 3.x - Kotlin - JPA/Hibernate
Banco: PostgreSQL 16 - Flyway (migrações)
Servidor: Undertow (porta 9090)
Testes: JUnit 5 - Kotlin Test
Build: Gradle (Groovy)

## ✨ Funcionalidades

- `POST /avengers` - Criar novo vingador
- `GET /avengers/{id}` - Buscar vingador por ID
- Migrações automáticas via Flyway
- Validação de dados (`@Valid`)
- Configuração otimizada para produção

## 📋 Pré-requisitos

- Java 21+
- PostgreSQL rodando
- Gradle 8.10+
- Banco `avengers` com user `dio.avenger`

## 🚀 Instalação

```bash
# Clone o projeto
git clone <seu-repo>

# Crie o .sh de inicialização
chmod +x start-dev.sh

# Execute (profile dev)
./start-dev.sh
```

**Ou via Gradle:**
```bash
./gradlew bootRun --args="--spring.profiles.active=dev --DB_USER=dio.avenger --DB_PASSWORD=dio.avenger --DB_NAME=avengers"
```

## 🌐 Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/avengers` | Criar vingador |
| `GET` | `/avengers/{id}` | Buscar por ID |

**Base URL:** `http://localhost:9090/avengers`

## 📁 Estrutura

src/main/resources/</br>
├── db/migration/</br>
│   └── V1__Create_avenger_table.sql</br>
└── application.yml</br>

⚙️ Configurações Importantes
Porta: 9090

## ⚙️ Configurações Importantes

- **Porta:** 9090
- **Context:** `/avengers`
- **Profile:** `dev`
- **JPA:** `ddl-auto: none` (usa Flyway)
- **Hibernate:** Batch size 25, UTC timezone

## 🐛 Problemas Comuns & Fixes

| Erro | Solução |
|------|---------|
| `relation "avenger" does not exist` | Renomeie SQL para `V1__Create_avenger_table.sql` |
| `HttpMediaTypeNotAcceptableException` | Use `.body()` no `ResponseEntity.created()` |
| `MissingPathVariableException` | `@PathVariable("id")` **sem chaves** |

## 📚 Scripts Úteis

```bash
#!/bin/bash
# start-dev.sh
./gradlew bootRun --args="--spring.profiles.active=dev --DB_USER=dio.avenger --DB_PASSWORD=dio.avenger --DB_NAME=avengers" -Porg.gradle.jvmargs="-Xmx256m -Xms128m"
```

## 🤝 Contribuição

1. Fork o projeto
2. Crie sua branch (`git checkout -b feature`)
3. Commit (`git commit -m 'feat: descrição'`)
4. Push (`git push origin feature`)
5. Abra um Pull Request

## 📄 Licença

[MIT License](https://opensource.org/license/mit/)