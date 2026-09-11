export const environment = {
  production: false,
  apiUrl: ((import.meta as any).env?.NG_PUBLIC_API_URL || 'http://localhost:8081'),
  keycloak: {
    url: (import.meta as any).env?.NG_PUBLIC_KEYCLOAK_URL || 'http://localhost:8080',
    realm: (import.meta as any).env?.NG_PUBLIC_KEYCLOAK_REALM || 'corporate-realm',
    clientId: (import.meta as any).env?.NG_PUBLIC_KEYCLOAK_CLIENTID || 'ordens-api'
  }
};