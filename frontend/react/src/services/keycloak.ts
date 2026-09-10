import Keycloak from 'keycloak-js';

const keycloak = new Keycloak({
  url: 'http://localhost:8080',
  realm: 'corporate-realm',
  clientId: 'ordens-api'
});

export default keycloak;