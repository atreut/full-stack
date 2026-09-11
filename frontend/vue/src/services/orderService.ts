import axios from 'axios';

export interface Order {
  id: number;
  customerName: string;
  amount: number;
  status: string;
  createdAt: string;
}

export interface OrderResponse {
  order: Order;
  statusMessage: string;
}

const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8081';

export const getOrders = async (): Promise<OrderResponse[]> => {
  const response = await axios.get<OrderResponse[]>(`${API_URL}/orders`);
  return response.data;
};