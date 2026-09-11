async function getOrders() {
  const baseUrl = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8081';
  const res = await fetch(`${baseUrl}/orders`, { cache: 'no-store' });
  if (!res.ok) {
    throw new Error('Falha ao buscar ordens do backend');
  }
  return res.json();
}

export default async function OrdersPage() {
  const responseData = await getOrders();
  // Garante compatibilidade caso o backend retorne direto um array ou um objeto embrulhado
  const orders = Array.isArray(responseData) ? responseData : responseData.orders || [];

  return (
    <main className="p-8 max-w-5xl mx-auto font-sans text-slate-900">
      <h1 className="text-2xl font-bold mb-6 text-white">Lista de Ordens</h1>
      <div className="bg-white shadow rounded-lg overflow-hidden border border-slate-200">
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
              orders.map((item: any, index: number) => {
                const order = item.order || item;
                const statusMessage = item.statusMessage || '';

                return (
                  <tr key={order.id || index} className="border-b hover:bg-slate-50">
                    <td className="p-3 font-medium">{order.id}</td>
                    <td className="p-3">{order.customerName || order.clientName}</td>
                    <td className="p-3">R$ {order.amount ?? order.totalAmount}</td>
                    <td className="p-3">
                      <span
                        className="rounded-full bg-blue-100 px-2.5 py-1 text-xs font-semibold text-blue-800"
                        title={statusMessage}
                      >
                        {order.status}
                      </span>
                    </td>
                    <td className="p-3">{order.createdAt || '-'}</td>
                  </tr>
                );
              })
            )}
          </tbody>
        </table>
      </div>
    </main>
  );
}