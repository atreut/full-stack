import React from "react";
import ReactDOM from "react-dom/client";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import App from "./App";
import keycloak from "./services/keycloak";
import "./index.css";

const queryClient = new QueryClient();
const rootElement = document.getElementById("root")!;

keycloak
  .init({ onLoad: "login-required", checkLoginIframe: false })
  .then((authenticated) => {
    ReactDOM.createRoot(rootElement).render(
      <React.StrictMode>
        <QueryClientProvider client={queryClient}>
          <App authenticated={authenticated} />
        </QueryClientProvider>
      </React.StrictMode>,
    );
  })
  .catch((err) => {
    console.error("Falha ao inicializar o Keycloak:", err);
    rootElement.innerHTML = `<div style="padding: 20px; color: red; font-family: sans-serif;">
    <h3>Erro de Autenticação</h3>
    <p>Não foi possível conectar ao Keycloak. Verifique se o container está rodando na porta 8080.</p>
  </div>`;
  });
