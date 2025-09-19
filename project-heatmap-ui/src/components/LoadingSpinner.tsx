import React from 'react';

export const LoadingSpinner: React.FC = () => {
  return (
    <div className="loading-spinner">
      <div className="spinner"></div>
      <p>載入股票數據中...</p>
    </div>
  );
};
