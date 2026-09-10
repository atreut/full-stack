import { useQuery } from "@tanstack/react-query";
import keycloak from "./services/keycloak";
import api from "./services/api";

interface Order {
  id: number;
  customerName: string;
  amount: number;
  status: string;
  createdAt: string;
}

interface OrderResponse {
  order: Order;
  statusMessage: string;
}

// Defina a interface para as propriedades aceitas pelo componente
interface AppProps {
  authenticated: boolean;
}

function App({ authenticated }: AppProps) {
  const {
    data: orders = [],
    isLoading,
    error,
  } = useQuery<OrderResponse[]>({
    queryKey: ["orders"],
    queryFn: async () => {
      const response = await api.get("/orders");
      return response.data;
    },
    enabled: authenticated,
  });

  return (
    <div className="min-h-screen bg-slate-50 p-8 font-sans text-slate-900">
      <div className="mx-auto max-w-5xl rounded-lg bg-white p-6 shadow-md">
        <div className="flex items-center justify-between border-b pb-4 mb-6">
          <h1 className="text-2xl font-bold">Painel de Ordens (React SPA)</h1>
          <div className="flex items-center gap-4">
            <span className="text-sm text-slate-600">
              Usuário:{" "}
              <strong>{keycloak.tokenParsed?.preferred_username}</strong>
            </span>
            <button
              onClick={() => keycloak.logout()}
              className="rounded bg-red-600 px-4 py-2 text-sm font-semibold text-white hover:bg-red-700 transition"
            >
              Sair
            </button>
          </div>
        </div>

        {isLoading && (
          <p className="text-center py-4 text-slate-500">
            Sincronizando ordens via TanStack Query...
          </p>
        )}
        {error && (
          <p className="text-center py-4 text-red-500">
            Erro ao carregar ordens do back-end Spring Boot.
          </p>
        )}

        {!isLoading && !error && (
          <div className="overflow-x-auto">
            <table className="w-full border-collapse text-left text-sm">
              <thead>
                <tr className="border-b bg-slate-100 text-slate-700">
                  <th className="p-3">ID</th>
                  <th className="p-3">Cliente</th>
                  <th className="p-3">Valor Total</th>
                  <th className="p-3">Status</th>
                  <th className="p-3">Data</th>
                </tr>
              </thead>
              <tbody>
                {orders.length === 0 ? (
                  <tr>
                    <td colSpan={5} className="p-4 text-center text-slate-500">
                      Nenhuma ordem encontrada.
                    </td>
                  </tr>
                ) : (
                  orders.map(({ order, statusMessage }) => (
                    <tr key={order.id} className="border-b hover:bg-slate-50">
                      <td className="p-3 font-medium">{order.id}</td>
                      <td className="p-3">{order.customerName}</td>
                      <td className="p-3">R$ {order.amount}</td>
                      <td className="p-3">
                        <span
                          className="rounded-full bg-blue-100 px-2.5 py-1 text-xs font-semibold text-blue-800"
                          title={statusMessage}
                        >
                          {order.status}
                        </span>
                      </td>
                      <td className="p-3">{order.createdAt}</td>
                    </tr>
                  ))
                )}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
