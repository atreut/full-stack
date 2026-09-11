<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { getOrders, type OrderResponse } from './services/orderService';

const orders = ref<OrderResponse[]>([]);
const isLoading = ref(true);
const errorMessage = ref('');

onMounted(async () => {
  try {
    orders.value = await getOrders();
  } catch (err) {
    console.error(err);
    errorMessage.value = 'Erro ao carregar ordens do back-end Spring Boot.';
  } finally {
    isLoading.value = false;
  }
});
</script>

<template>
  <main class="min-h-screen bg-slate-900 text-slate-100 flex items-center justify-center p-6">
    <div class="w-full max-w-4xl bg-slate-800 rounded-xl shadow-2xl border border-slate-700 p-8">
      
      <header class="flex items-center justify-between border-b border-slate-700 pb-5 mb-6">
        <h1 class="text-2xl font-bold tracking-tight text-white flex items-center gap-2">
          📦 Painel de Ordens <span class="text-xs font-medium px-2.5 py-1 rounded-full bg-indigo-500/20 text-indigo-400 border border-indigo-500/30">Vue 3 + Tailwind</span>
        </h1>
      </header>

      <section v-if="isLoading" class="flex flex-col items-center justify-center py-12 text-slate-400 gap-3">
        <div class="w-8 h-8 border-4 border-indigo-500 border-t-transparent rounded-full animate-spin"></div>
        <p class="text-sm font-medium">Carregando ordens do back-end Spring Boot...</p>
      </section>

      <section v-if="errorMessage" class="bg-red-500/10 border border-red-500/20 text-red-400 p-4 rounded-lg text-center text-sm font-medium">
        {{ errorMessage }}
      </section>

      <section v-if="!isLoading && !errorMessage" class="overflow-x-auto">
        <table class="w-full text-left text-sm border-collapse">
          <thead>
            <tr class="border-b border-slate-700 text-slate-400 uppercase tracking-wider text-xs">
              <th class="p-4 font-semibold">ID</th>
              <th class="p-4 font-semibold">Cliente</th>
              <th class="p-4 font-semibold">Valor Total</th>
              <th class="p-4 font-semibold">Status</th>
              <th class="p-4 font-semibold">Data</th>
            </tr>
          </thead>
          <tbody class="divide-y divide-slate-700/60">
            <tr v-if="orders.length === 0">
              <td colspan="5" class="p-8 text-center text-slate-500">
                Nenhuma ordem encontrada.
              </td>
            </tr>
            <tr v-for="item in orders" :key="item.order.id" class="hover:bg-slate-700/30 transition-colors">
              <td class="p-4 font-mono font-semibold text-indigo-400">#{{ item.order.id }}</td>
              <td class="p-4 font-medium text-slate-200">{{ item.order.customerName }}</td>
              <td class="p-4 font-mono text-emerald-400">R$ {{ item.order.amount.toFixed(2) }}</td>
              <td class="p-4">
                <span 
                  class="inline-flex items-center px-2.5 py-1 rounded-md text-xs font-medium bg-amber-500/10 text-amber-400 border border-amber-500/20"
                  :title="item.statusMessage"
                >
                  {{ item.order.status }}
                </span>
              </td>
              <td class="p-4 text-slate-400 text-xs font-mono">{{ new Date(item.order.createdAt).toLocaleString() }}</td>
            </tr>
          </tbody>
        </table>
      </section>

    </div>
  </main>
</template>