import axios from 'axios';
import { HeatmapData, ApiError } from '../types';

class StockDataService {
  private baseUrl = 'http://localhost:8080/api';
  
  async getHeatmapData(industry: string = 'Technology', limit: number = 50): Promise<HeatmapData> {
    try {
      const response = await axios.get<HeatmapData>(`${this.baseUrl}/fh/heatmap`, {
        params: { industry, limit }
      });
      return response.data;
    } catch (error) {
      const apiError = error as ApiError;
      console.error('Failed to fetch heatmap data:', apiError);
      throw new Error(`API Error: ${apiError.message}`);
    }
  }
}

export const stockDataService = new StockDataService();
