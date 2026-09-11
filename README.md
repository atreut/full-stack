# Full-Stack Multi-Frontend Ecosystem

Repositório centralizado em arquitetura de monorepo estruturado para integrar um back-end corporativo de alta performance com um ecossistema multiplataforma de front-ends modernos.

## 🛠️ Tecnologias, Versões e Frameworks

* **Back-end & Infraestrutura**:
  * **Java**: Versão 21 (LTS)
  * **Spring Boot**: Versão 3.5.0
  * **Ecossistema Spring**: Spring Data JPA, Spring Security, Spring Web
  * **Ferramenta de Build**: Maven (via Maven Wrapper `./mvnw`)
  * **Banco de Dados & Serviços**: PostgreSQL, MongoDB, RabbitMQ, Keycloak (orquestrados via Docker Compose)

* **Ecossistemas Front-end**:
  * **Vue.js**: Vue 3, Vite, TypeScript, Tailwind CSS (`@tailwindcss/postcss`), Pinia, Vue Router
  * **Angular**: Angular CLI (Versão atualizada), TypeScript, RxJS, Tailwind CSS
  * **React**: React 18+, Vite, TypeScript, Tailwind CSS, React Router
  * **Next.js**: Next.js (App Router), React, TypeScript, Tailwind CSS

## 📂 Estrutura de Diretórios do Monorepo

```text
/full-stack
├── backend/                  # API Restful em Spring Boot (Java 21)
│   ├── .mvn/                 # Wrapper e configurações do Maven
│   ├── src/                  # Código-fonte Java (Controllers, Services, Repositories)
│   ├── pom.xml               # Gerenciador de dependências do back-end
│   └── docker-compose.yml    # Infraestrutura de suporte (Postgres, Mongo, RabbitMQ, Keycloak)
│
├── frontend/                 # Repositórios de interfaces de usuário
│   ├── angular/              # Aplicação modularizada em Angular
│   │   ├── src/app/          # Componentes, rotas e serviços (ex: order.service.ts)
│   │   ├── angular.json      # Configurações do Angular CLI
│   │   └── package.json      # Dependências Node.js do Angular
│   │
│   ├── next/                 # Aplicação Next.js baseada em App Router (SSR/SSG)
│   │   ├── app/              # Estrutura de páginas e rotas do Next.js
│   │   └── package.json      # Dependências Node.js do Next.js
│   │
│   ├── react/                # Aplicação Single Page Application com React & Vite
│   │   ├── src/              # Componentes e hooks React
│   │   └── package.json      # Dependências Node.js do React
│   │
│   └── vue/                  # Aplicação Single Page Application com Vue 3 & Vite
│       ├── src/              # Componentes SFC (.vue) e rotas
│       └── package.json      # Dependências Node.js do Vue
│
└── docker-compose.yml        # Orquestrador geral do ecossistema

```

## 🚀 Como Executar o Projeto

### 1. Inicializando o Back-end (Spring Boot)

No terminal, navegue até a pasta do back-end e inicie o serviço da API:

```bash
cd backend
./mvnw spring-boot:run

```

*A API estará ativa em `http://localhost:8081`.*

---

### 2. Inicializando os Front-ends

Escolha **apenas uma** das opções abaixo conforme a interface desejada:

* **Opção A: Vue 3 (Vite)**
```bash
cd frontend/vue
npm install
npm run dev

```


*(Disponível em `http://localhost:5173`)*
* **Opção B: Angular**
```bash
cd frontend/angular
npm install
npm start

```


*(Disponível em `http://localhost:4200`)*
* **Opção C: React (Vite)**
```bash
cd frontend/react
npm install
npm run dev

```


*(Disponível em `http://localhost:5173`)*
* **Opção D: Next.js**
```bash
cd frontend/next
npm install
npm run dev

```


*(Disponível em `http://localhost:3000`)*