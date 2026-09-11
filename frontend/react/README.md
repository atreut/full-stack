# 🟣 Full-Stack Ecosystem - Next.js Frontend

Aplicação cliente desenvolvida em **Next.js 14+** utilizando o **App Router**, integrada ao monorepo do ecossistema full-stack. Este front-end aproveita renderização híbrida (SSR/SSG), rotas baseadas em diretórios, otimização automática de recursos e estilização moderna.


## 🛠️ Tecnologias e Dependências Utilizadas

* **Framework Principal**: Next.js (App Router)
* **Biblioteca UI**: React 18+
* **Linguagem**: TypeScript
* **Estilização**: Tailwind CSS
* **Gerenciador de Pacotes**: npm


## 📂 Estrutura de Diretórios da Aplicação

```text
/frontend/next
├── app/                      # App Router: páginas, layouts e rotas da aplicação
│   ├── favicon.ico           # Ícone do site
│   ├── globals.css           # Estilos globais (Tailwind CSS)
│   ├── layout.tsx            # Layout raiz compartilhado entre as páginas
│   └── page.tsx              # Página inicial (index)
├── public/                   # Arquivos estáticos públicos (imagens, fontes)
├── next.config.ts            # Configurações do Next.js
├── package.json              # Dependências e scripts do projeto Node.js
└── tsconfig.json             # Configurações do TypeScript

```


## ⚙️ Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

* **Node.js** (versão LTS recomendada, ex: v18+ ou v20+)
* **npm** (geralmente instalado junto com o Node.js)


## 🚀 Como Executar o Projeto em Desenvolvimento

1. **Abra o terminal** e navegue até a pasta da aplicação Next.js a partir da raiz do monorepo:
```bash
cd frontend/next

```


2. **Instale as dependências** do projeto:
```bash
npm install

```


3. **Inicie o servidor de desenvolvimento** com hot-reload:
```bash
npm run dev

```


4. A aplicação estará ativa e acessível no navegador em:
👉 **`http://localhost:3000`**


## 🌐 Integração com o Back-end

A aplicação consome a API RESTful em Spring Boot. Certifique-se de que a API está rodando na porta correta (`http://localhost:8081`) e configure as variáveis de ambiente necessárias (como a URL base da API) caso utilize requisições do lado do servidor ou cliente.


## 📦 Build para Produção

Para gerar a versão otimizada de produção da aplicação Next.js:

```bash
npm run build

```

Para iniciar o servidor de produção localmente após o build:

```bash
npm run start

```