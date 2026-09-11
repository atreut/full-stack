# 🟢 Full-Stack Ecosystem - Vue 3 Frontend

Aplicação cliente desenvolvida em **Vue 3** utilizando **Vite** como empacotador de alta performance, integrada ao monorepo do ecossistema full-stack. Este front-end é focado em reatividade avançada, composição de componentes com a *Composition API*, gerenciamento de estado global e estilização moderna.


## 🛠️ Tecnologias e Dependências Utilizadas

* **Framework Principal**: Vue.js 3 (Composition API / `<script setup>`)
* **Build Tool / Bundler**: Vite
* **Linguagem**: TypeScript
* **Gerenciamento de Estado**: Pinia
* **Roteamento**: Vue Router
* **Estilização**: Tailwind CSS (`@tailwindcss/postcss`)
* **Gerenciador de Pacotes**: npm


## 📂 Estrutura de Diretórios da Aplicação

```text
/frontend/vue
├── src/
│   ├── assets/               # Recursos estáticos (imagens, ícones, estilos globais)
│   ├── components/           # Componentes SFC (.vue) reutilizáveis
│   ├── router/               # Configuração de rotas da aplicação (Vue Router)
│   ├── stores/               # Gerenciamento de estado global (Pinia)
│   ├── views/                # Componentes de páginas principais
│   ├── App.vue               # Componente raiz da aplicação
│   └── main.ts               # Ponto de entrada e inicialização do Vue
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

1. **Abra o terminal** e navegue até a pasta da aplicação Vue a partir da raiz do monorepo:
   ```bash
   cd frontend/vue
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

A aplicação consome a API RESTful do Spring Boot. Certifique-se de que a API está rodando na porta correta (`http://localhost:8081`) e configure o endpoint de conexão nos serviços ou variáveis de ambiente conforme necessário.


## 📦 Build para Produção

Para compilar e gerar os arquivos estáticos otimizados para produção (geralmente gerados na pasta `dist/`):

```bash
npm run build
```

Para visualizar o build de produção localmente antes do deploy:
```bash
npm run preview
```