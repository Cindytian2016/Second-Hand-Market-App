import React, { useState } from "react";
import "./search.css"; // Import the CSS for styling

const Search = ({ onSearch }) => {
  const [query, setQuery] = useState("");

  const handleInputChange = (e) => {
    setQuery(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent the default form submit action
    onSearch(query); // Execute the onSearch function passed as a prop with the current query
  };

  return (
    <form className="searchForm" onSubmit={handleSubmit}>
      <input
        type="text"
        className="searchInput"
        placeholder="Search for items..."
        value={query}
        onChange={handleInputChange}
      />
      <button type="submit" className="searchButton">
        Search
      </button>
    </form>
  );
};

export default Search;
