import React from 'react';
import { HeatmapStock } from '../types';

interface StockTooltipProps {
  stock: HeatmapStock;
  position: { x: number; y: number };
}

export const StockTooltip: React.FC<StockTooltipProps> = ({ stock, position }) => {
  return (
    <div
      className="stock-tooltip"
      style={{
        left: position.x,
        top: position.y,
      }}
    >
      <h4>{stock.company}</h4>
      <p><strong>代碼：</strong>{stock.symbol}</p>
      <p><strong>漲跌：</strong><span className={`change ${stock.change >= 0 ? 'positive' : 'negative'}`}>
        {stock.change.toFixed(2)}%
      </span></p>
      <p><strong>價格：</strong>${stock.price.toLocaleString()}</p>
      <p><strong>市值：</strong>${(stock.marketCap / 1e9).toFixed(1)}B</p>
      <p><strong>成交量：</strong>{stock.volume.toLocaleString()}</p>
    </div>
  );
};
