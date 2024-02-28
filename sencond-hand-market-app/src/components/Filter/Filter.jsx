import React, { useState } from "react";
import "./filter.css"; // Import the CSS for styling

const Filter = ({ onFilterChange }) => {
  const [filters, setFilters] = useState({
    category: "",
    minPrice: "",
    maxPrice: "",
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFilters({
      ...filters,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onFilterChange(filters);
  };

  return (
    <form className="filterForm" onSubmit={handleSubmit}>
      <select
        name="category"
        value={filters.category}
        onChange={handleInputChange}
      >
        <option value="">Select a Category</option>
        <option value="electronics">Electronics</option>
        <option value="furniture">Furniture</option>
        <option value="clothing">Clothing</option>
        {/* Add more categories as needed */}
      </select>
      <div className="priceRange">
        <input
          type="number"
          name="minPrice"
          placeholder="Min Price"
          value={filters.minPrice}
          onChange={handleInputChange}
        />
        <input
          type="number"
          name="maxPrice"
          placeholder="Max Price"
          value={filters.maxPrice}
          onChange={handleInputChange}
        />
      </div>
      <button type="submit">Apply Filters</button>
    </form>
  );
};

export default Filter;
