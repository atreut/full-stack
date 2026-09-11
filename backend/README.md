# Microsserviço de Ordens (Orders API)

Microsserviço corporativo voltado para o gerenciamento e processamento de ordens, construído com uma arquitetura moderna e escalável utilizando ecossistema Spring Boot e infraestrutura conteinerizada via Docker.

## 🛠️ Tecnologias e Versões

| Componente | Tecnologia | Versão |
| --- | --- | --- |
| **Linguagem** | Java | 21 |
| **Framework** | Spring Boot | 3.5.0 |
| **Persistência Relacional** | Spring Data JPA / PostgreSQL | 15-alpine |
| **Persistência NoSQL** | Spring Data MongoDB | 7.0 |
| **Mensageria** | Spring AMQP / RabbitMQ | 3.11-management-alpine |
| **Segurança** | Spring Security OAuth2 Resource Server / Keycloak | 24.0.1 |
| **Processamento em Lote** | Spring Batch | 3.5.0 (Starter) |
| **Testes** | JUnit 5 / Testcontainers | 3.5.0 / (Managed) |

## 📐 Arquitetura dos Microsserviços e Infraestrutura

O projeto possui stack completa rodando via Docker Compose, estruturada com os seguintes serviços:

* **`orders-api`**: Aplicação principal Spring Boot (porta `8081`).
* **`postgres`**: Banco de dados relacional principal para persistência transacional de ordens (porta `5432`).
* **`mongo`**: Banco de dados NoSQL utilizado para auditoria e logs (porta `27017`).
* **`rabbitmq`**: Broker de mensageria para processamento assíncrono (portas `5672` e painel de gerência em `15672`).
* **`keycloak`**: Provedor de identidade e controle de acesso OAuth2/OIDC (porta `8080`), apoiado por seu próprio banco dedicado (`keycloak-db` na porta `5433`).

## 🚀 Como Executar o Projeto

1. **Pré-requisitos**: Certifique-se de ter o Docker, Docker Compose e o JDK 21 instalados na sua máquina.
2. **Subir a Infraestrutura (Docker Compose)**:
Na raiz onde se encontra o arquivo do Docker Compose, execute:
```bash
docker-compose up -d

```


3. **Executar a Aplicação**:
Com os containers em execução e saudáveis (`postgres`, `mongo`, `rabbitmq`), você pode iniciar a API a partir da sua IDE favorita ou via Maven:
```bash
mvn clean spring-boot:run

```



## 🧪 Testes

O projeto conta com testes integrados utilizando **Testcontainers** para garantir o comportamento isolado e fiel aos ambientes de produção com instâncias reais de banco de dados. Para rodar a suíte de testes:

```bash
mvn test

```
