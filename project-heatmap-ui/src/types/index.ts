export interface StockQuote {
  symbol: string;
  c: number;        // Current price
  d: number;        // Change
  dp: number;       // Percent change
  h: number;        // High
  l: number;        // Low
  o: number;        // Open
  pc: number;       // Previous close
  t: number;        // Timestamp
}

export interface StockProfile {
  symbol: string;
  name: string;
  country: string;
  currency: string;
  exchange: string;
  finnhubIndustry: string;
  ipo: string;
  logo: string;
  marketCapitalization: number;
  phone: string;
  shareOutstanding: number;
  weburl: string;
}

export interface Snp500Stock {
  symbol: string;
  security: string;
  gics_sector: string;
  gics_sub_industry: string;
  hq_location: string;
  date_added: string;
  cik: number;
  founded: number;
}

export interface HeatmapStock {
  symbol: string;
  company: string;
  sector: string;
  change: number;
  price: number;
  volume: number;
  marketCap: number;
  color: string;
  founded: number;
}

export interface HeatmapData {
  industry: string;
  stocks: HeatmapStock[];
  timestamp: string;
  totalStocks: number;
  avgChange: number;
}

export interface ApiError {
  code: number;
  message: string;
}
