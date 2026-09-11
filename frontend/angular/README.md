

# 🅰️ Full-Stack Ecosystem - Angular Frontend

Aplicação cliente desenvolvida em **Angular** (versão atualizada), integrada à arquitetura de monorepo do ecossistema full-stack. Este front-end consome a API RESTful em Spring Boot e utiliza componentes modernos para gerenciamento de rotas, reatividade com RxJS e estilização utilitária.


## 🛠️ Tecnologias e Dependências Utilizadas

* **Framework Principal**: Angular (Angular CLI)
* **Linguagem**: TypeScript
* **Gerenciamento de Estado & Reatividade**: RxJS
* **Estilização**: Tailwind CSS / CSS Modular
* **Gerenciador de Pacotes**: npm


## 📂 Estrutura de Diretórios da Aplicação

```text
/frontend/angular
├── src/
│   ├── app/                  # Componentes principais, rotas e serviços
│   │   ├── components/       # Componentes reutilizáveis da interface
│   │   ├── services/         # Serviços de integração HTTP (ex: order.service.ts)
│   │   ├── app.component.ts  # Componente raiz
│   │   ├── app.routes.ts     # Configuração de rotas da aplicação
│   │   └── app.config.ts     # Configurações globais e provedores (DI)
│   ├── assets/               # Imagens, ícones e arquivos estáticos
│   ├── environments/         # Variáveis de ambiente (desenvolvimento/produção)
│   ├── index.html            # Página HTML principal
│   ├── main.ts               # Ponto de entrada da aplicação TypeScript
│   └── styles.css            # Folha de estilos global (Tailwind)
├── angular.json              # Configurações do Angular CLI para build e serve
├── package.json              # Dependências e scripts do projeto Node.js
└── tsconfig.json             # Configurações do compilador TypeScript

```

## ⚙️ Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

* **Node.js** (versão LTS recomendada, ex: v18+ ou v20+)
* **npm** (geralmente instalado junto com o Node.js)
* **Angular CLI** (opcional, mas recomendado globalmente: `npm install -g @angular/cli`)


## 🚀 Como Executar o Projeto em Desenvolvimento

1. **Abra o terminal** e navegue até a pasta da aplicação Angular a partir da raiz do monorepo:
```bash
cd frontend/angular

```


2. **Instale as dependências** do projeto:
```bash
npm install

```


3. **Inicie o servidor de desenvolvimento**:
```bash
npm start

```


*(Ou utilize diretamente: `ng serve`)*
4. A aplicação estará ativa e acessível no navegador em:
👉 **`http://localhost:4200`**


## 🌐 Configuração de Conexão com o Back-end

Por padrão, a aplicação espera que a API do Spring Boot esteja rodando localmente. Verifique e ajuste a URL base da API nos arquivos de ambiente localizados em `src/environments/`:

* `environment.ts` (Desenvolvimento):
```typescript
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8081'
};

```

## 📦 Build para Produção

Para gerar os arquivos otimizados e minificados prontos para deploy (geralmente gerados na pasta `dist/`):

```bash
npm run build

```

*(Ou utilize o comando de produção do CLI: `ng build --configuration production`)*
