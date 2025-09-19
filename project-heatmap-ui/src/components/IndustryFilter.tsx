import React from 'react';
import { industries } from '../data/industries';

interface IndustryFilterProps {
  selectedIndustry: string;
  onIndustryChange: (industry: string) => void;
}

export const IndustryFilter: React.FC<IndustryFilterProps> = ({
  selectedIndustry,
  onIndustryChange
}) => {
  return (
    <div className="industry-filter">
      <label htmlFor="industry-select">行業：</label>
      <select
        id="industry-select"
        value={selectedIndustry}
        onChange={(e) => onIndustryChange(e.target.value)}
        className="industry-select"
      >
        {industries.map((industry) => (
          <option key={industry.value} value={industry.value}>
            {industry.label}
          </option>
        ))}
      </select>
    </div>
  );
};
