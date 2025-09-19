import React, { useState, useEffect } from 'react';
import { HeatmapGrid } from './components/HeatmapGrid';
import { IndustryFilter } from './components/IndustryFilter';
import { stockDataService } from './services/StockDataService';
import { HeatmapStock } from './types';
import './App.css';

const industries = [
  { label: '全部行業', value: 'All' },
  { label: '科技', value: 'Technology' },
  { label: '金融', value: 'Financials' },
  { label: '醫療保健', value: 'Healthcare' },
  { label: '消費循環', value: 'Consumer Cyclical' },
  { label: '工業', value: 'Industrials' },
  { label: '消費防禦', value: 'Consumer Defensive' },
  { label: '能源', value: 'Energy' },
  { label: '公用事業', value: 'Utilities' },
  { label: '房地產', value: 'Real Estate' },
  { label: '通信服務', value: 'Communication Services' },
  { label: '基礎材料', value: 'Basic Materials' }
];

function App() {
  const [stocks, setStocks] = useState<HeatmapStock[]>([]);
  const [industry, setIndustry] = useState('Technology');
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [selectedStock, setSelectedStock] = useState<HeatmapStock | null>(null);

  useEffect(() => {
    fetchHeatmapData();
    
    // 每30秒更新一次
    const interval = setInterval(fetchHeatmapData, 30000);
    return () => clearInterval(interval);
  }, [industry]);

  const fetchHeatmapData = async () => {
    setLoading(true);
    setError(null);
    
    try {
      const data = await stockDataService.getHeatmapData(industry);
      setStocks(data.stocks);
    } catch (err) {
      console.error('Failed to fetch data:', err);
      setError('數據載入失敗，請稍後重試');
    } finally {
      setLoading(false);
    }
  };

  const handleIndustryChange = (newIndustry: string) => {
    setIndustry(newIndustry);
  };

  const handleStockClick = (stock: HeatmapStock) => {
    setSelectedStock(stock);
  };

  return (
    <div className="app">
      <header className="app-header">
        <h1>📈 S&P 500 股票熱力圖</h1>
        <p className="subtitle">實時監控美國主要公司漲跌表現</p>
        <div className="stats">
          <div className="stat">
            <span className="stat-number">{stocks.length}</span>
            <span className="stat-label">支股票</span>
          </div>
          <div className="stat">
            <span className="stat-number">
              {stocks.length > 0 
                ? stocks.reduce((sum, stock) => sum + stock.change, 0) / stocks.length
                : 0}
            </span>
            <span className="stat-label">% 平均漲跌</span>
          </div>
        </div>
      </header>

      <main className="main-content">
        <div className="controls">
          <IndustryFilter
            selectedIndustry={industry}
            onIndustryChange={handleIndustryChange}
          />
          <button 
            onClick={fetchHeatmapData} 
            className="refresh-btn"
            disabled={loading}
          >
            {loading ? '⏳ 更新中...' : '🔄 刷新數據'}
          </button>
        </div>

        {error && (
          <div className="error-message">
            <p>❌ {error}</p>
            <button onClick={fetchHeatmapData}>重試</button>
          </div>
        )}

        <div className="heatmap-section">
          <div className="industry-header">
            <div 
              className="industry-color"
              style={{ backgroundColor: getIndustryColor(industry) }}
            ></div>
            <h2>{industry === 'All' ? '所有行業' : industries.find(i => i.value === industry)?.label}</h2>
            <span className="stock-count">{stocks.length} 支股票</span>
          </div>
          
          <HeatmapGrid
            stocks={stocks}
            industry={industry}
            onStockClick={handleStockClick}
            loading={loading}
          />
        </div>

        {selectedStock && (
          <div className="stock-detail">
            <h3>📊 {selectedStock.company}</h3>
            <div className="detail-grid">
              <div className="detail-item">
                <span className="label">當前價格</span>
                <span className="value">${selectedStock.price.toLocaleString()}</span>
              </div>
              <div className="detail-item">
                <span className="label">今日漲跌</span>
                <span className={`value ${selectedStock.change >= 0 ? 'positive' : 'negative'}`}>
                  {selectedStock.change >= 0 ? '+' : ''}{selectedStock.change.toFixed(2)}%
                </span>
              </div>
              <div className="detail-item">
                <span className="label">成交量</span>
                <span className="value">{selectedStock.volume.toLocaleString()}</span>
              </div>
              <div className="detail-item">
                <span className="label">市值</span>
                <span className="value">${(selectedStock.marketCap / 1e9).toFixed(1)}B</span>
              </div>
            </div>
            <button onClick={() => setSelectedStock(null)} className="close-detail">
              ✕ 關閉
            </button>
          </div>
        )}
      </main>

      <footer className="app-footer">
        <p>數據來源：Finnhub API + Yahoo Finance | S&P 500 熱力圖</p>
        <p>最後更新：{new Date().toLocaleString()}</p>
      </footer>
    </div>
  );
}

function getIndustryColor(industry: string) {
  const colors = {
    'Technology': '#1f77b4',
    'Financials': '#ff7f0e',
    'Healthcare': '#2ca02c',
    'Consumer Cyclical': '#d62728',
    'Industrials': '#9467bd',
    'Consumer Defensive': '#8c564b',
    'Energy': '#e377c2',
    'Utilities': '#7f7f7f',
    'Real Estate': '#bcbd22',
    'Communication Services': '#17becf',
    'Basic Materials': '#ff9896',
    'All': '#333'
  };
  return colors[industry as keyof typeof colors] || '#333';
}

export default App;
