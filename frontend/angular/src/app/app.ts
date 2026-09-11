import { Component, OnInit, PLATFORM_ID, Inject, ChangeDetectorRef } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { OrderService, OrderResponse } from './services/order.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="min-h-screen bg-slate-50 p-8 font-sans text-slate-900">
      <div class="mx-auto max-w-5xl rounded-lg bg-white p-6 shadow-md">
        <div class="flex items-center justify-between border-b pb-4 mb-6">
          <h1 class="text-2xl font-bold">Painel de Ordens (Angular SPA)</h1>
        </div>

        <div *ngIf="isLoading" class="text-center py-4 text-slate-500">
          Carregando ordens do back-end Spring Boot...
        </div>

        <div *ngIf="errorMessage" class="text-center py-4 text-red-500">
          {{ errorMessage }}
        </div>

        <div *ngIf="!isLoading && !errorMessage" class="overflow-x-auto">
          <table class="w-full border-collapse text-left text-sm">
            <thead>
              <tr class="border-b bg-slate-100 text-slate-700">
                <th class="p-3">ID</th>
                <th class="p-3">Cliente</th>
                <th class="p-3">Valor Total</th>
                <th class="p-3">Status</th>
                <th class="p-3">Data</th>
              </tr>
            </thead>
            <tbody>
              <tr *ngIf="orders.length === 0">
                <td colspan="5" class="p-4 text-center text-slate-500">
                  Nenhuma ordem encontrada.
                </td>
              </tr>
              <tr *ngFor="let item of orders" class="border-b hover:bg-slate-50">
                <td class="p-3 font-medium">{{ item.order.id }}</td>
                <td class="p-3">{{ item.order.customerName }}</td>
                <td class="p-3">R$ {{ item.order.amount }}</td>
                <td class="p-3">
                  <span
                    class="rounded-full bg-blue-100 px-2.5 py-1 text-xs font-semibold text-blue-800"
                    [title]="item.statusMessage"
                  >
                    {{ item.order.status }}
                  </span>
                </td>
                <td class="p-3">{{ item.order.createdAt }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  `
})
export class App implements OnInit {
  orders: OrderResponse[] = [];
  isLoading = true;
  errorMessage = '';

  constructor(
    private orderService: OrderService,
    @Inject(PLATFORM_ID) private platformId: Object,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    if (isPlatformBrowser(this.platformId)) {
      this.orderService.getOrders().subscribe({
        next: (data) => {
          this.orders = data;
          this.isLoading = false;
          this.cdr.detectChanges(); 
        },
        error: (err) => {
          console.error('Erro detalhado:', err);
          this.errorMessage = 'Erro ao carregar ordens do back-end.';
          this.isLoading = false;
          this.cdr.detectChanges();
        }
      });
    } else {
      this.isLoading = false;
    }
  }
}