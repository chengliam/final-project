export const getColorForChange = (change: number): string => {
  if (change >= 3) return '#00FF00';        // 深綠
  if (change >= 1) return '#32CD32';        // 綠色
  if (change > 0) return '#90EE90';         // 淺綠
  if (change <= -3) return '#FF0000';       // 深紅
  if (change <= -1) return '#DC143C';       // 紅色
  if (change < 0) return '#FFB6C1';         // 粉紅
  return '#FFFF00';                         // 黃色
};

export const getIndustryColor = (industry: string): string => {
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
    'All': '#333333'
  };
  return colors[industry as keyof typeof colors] || '#333333';
};
