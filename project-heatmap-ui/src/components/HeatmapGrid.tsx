import React, { useEffect, useRef } from 'react';
import * as d3 from 'd3';
import { HeatmapStock } from '../types';
import { getColorForChange } from '../utils/colorUtils';
import { StockTooltip } from './StockTooltip';
import { LoadingSpinner } from './LoadingSpinner';

interface HeatmapGridProps {
  stocks: HeatmapStock[];
  industry: string;
  onStockClick: (stock: HeatmapStock) => void;
  loading: boolean;
}

export const HeatmapGrid: React.FC<HeatmapGridProps> = ({
  stocks,
  industry,
  onStockClick,
  loading
}) => {
  const svgRef = useRef<SVGSVGElement>(null);
  const [hoveredStock, setHoveredStock] = React.useState<HeatmapStock | null>(null);
  const [tooltipPosition, setTooltipPosition] = React.useState({ x: 0, y: 0 });

  useEffect(() => {
    if (!stocks.length || !svgRef.current) return;

    const svg = d3.select(svgRef.current);
    const width = 800;
    const height = 600;
    const cellSize = 40;
    const cols = Math.floor(width / cellSize);
    const rows = Math.ceil(stocks.length / cols);

    svg.attr('width', width).attr('height', height * rows / cols);

    // 清空之前的內容
    svg.selectAll('*').remove();

    // 創建熱力圖格子
    const cells = svg.selectAll('g')
      .data(stocks)
      .enter()
      .append('g')
      .attr('transform', (d, i) => {
        const col = i % cols;
        const row = Math.floor(i / cols);
        return `translate(${col * cellSize}, ${row * cellSize})`;
      });

    cells.append('rect')
      .attr('width', cellSize - 1)
      .attr('height', cellSize - 1)
      .attr('rx', 2)
      .attr('fill', d => getColorForChange(d.change))
      .attr('stroke', '#fff')
      .attr('stroke-width', 1)
      .on('mouseover', function(event, d) {
        const [x, y] = d3.pointer(event, this);
        setHoveredStock(d);
        setTooltipPosition({ x: x + 10, y: y + 10 });
      })
      .on('mouseout', () => {
        setHoveredStock(null);
      })
      .on('click', (event, d) => {
        onStockClick(d);
      });

    cells.append('text')
      .attr('x', cellSize / 2)
      .attr('y', cellSize / 2)
      .attr('text-anchor', 'middle')
      .attr('dominant-baseline', 'middle')
      .attr('font-size', '10px')
      .attr('font-weight', 'bold')
      .attr('fill', d => d.change > 0 ? '#000' : '#fff')
      .text(d => d.symbol);

    // 行業標題
    svg.append('text')
      .attr('x', width / 2)
      .attr('y', 20)
      .attr('text-anchor', 'middle')
      .attr('font-size', '18px')
      .attr('font-weight', 'bold')
      .attr('fill', '#333')
      .text(`${industry} 行業熱力圖 (${stocks.length} 支股票)`);
  }, [stocks, industry, onStockClick]);

  if (loading) {
    return <LoadingSpinner />;
  }

  return (
    <div className="heatmap-container">
      <svg ref={svgRef} className="heatmap-svg"></svg>
      {hoveredStock && (
        <StockTooltip 
          stock={hoveredStock} 
          position={tooltipPosition} 
        />
      )}
    </div>
  );
};
