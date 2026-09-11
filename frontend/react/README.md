# ⚛️ Full-Stack Ecosystem - React Frontend

Aplicação cliente desenvolvida em **React 18+** utilizando **Vite** como empacotador de alta performance, integrada ao monorepo do ecossistema full-stack. Este front-end foca em uma experiência de Single Page Application (SPA) fluida, componentes modulares, hooks customizados e estilização moderna.


## 🛠️ Tecnologias e Dependências Utilizadas

* **Biblioteca Principal**: React 18+
* **Build Tool / Bundler**: Vite
* **Linguagem**: TypeScript
* **Roteamento**: React Router
* **Estilização**: Tailwind CSS
* **Gerenciador de Pacotes**: npm


## 📂 Estrutura de Diretórios da Aplicação

```text
/frontend/react
├── src/
│   ├── assets/               # Recursos estáticos (imagens, ícones)
│   ├── components/           # Componentes reutilizáveis da interface
│   ├── hooks/                # Custom hooks para lógica compartilhada
│   ├── services/             # Configuração de clientes HTTP (ex: Axios / Fetch para a API)
│   ├── App.tsx               # Componente raiz da aplicação
│   ├── main.tsx              # Ponto de entrada do React no DOM
│   └── index.css             # Estilos globais (Tailwind CSS)
├── index.html                # Template HTML principal
├── package.json              # Dependências e scripts do projeto Node.js
├── tsconfig.json             # Configurações do TypeScript
└── vite.config.ts            # Configurações do empacotador Vite

```


## ⚙️ Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

* **Node.js** (versão LTS recomendada, ex: v18+ ou v20+)
* **npm** (geralmente instalado junto com o Node.js)


## 🚀 Como Executar o Projeto em Desenvolvimento

1. **Abra o terminal** e navegue até a pasta da aplicação React a partir da raiz do monorepo:
```bash
cd frontend/react

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
👉 **`http://localhost:5173`** *(ou a porta indicada no terminal pelo Vite)*


## 🌐 Integração com o Back-end

A aplicação consome a API RESTful do Spring Boot. Certifique-se de que a API está rodando na porta correta (`http://localhost:8081`) e configure as variáveis de ambiente ou o cliente de requisições para apontar para o back-end.


## 📦 Build para Produção

Para compilar e gerar os arquivos estáticos otimizados para produção (geralmente gerados na pasta `dist/`):

```bash
npm run build

```

Para visualizar o build de produção localmente antes do deploy:

```bash
npm run preview

```