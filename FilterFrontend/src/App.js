/*import React from "react";
import "./App.css";
//import PostProduct from "./components/PostProduct/PostProduct";
//import Search from "./components/Search/Search";
//import Transaction from "./components/Transaction/Transaction";
//import Login from "./components/Login/Login";
//import Register from "./components/Register/Register";
//import ItemCard from "./components/ItemCard/ItemCard";
//mport Favorite from "./components/Favorite/Favorite";
//import Filter from "./components/Filter/Filter";
//import Register from "./components/Register/Register";

// Dummy data for the purpose of example
/*const items = [
  {
    id: 1,
    name: "Vintage Lamp",
    category: "Home Decor",
    price: "25",
    description: "A beautiful vintage lamp to light up your room.",
  },
  // Add more items as needed
];*/

/*function App() {
  return (
    <div className="App">
      <h1>Second Hand Market App</h1>
      <Search />
      <Filter />
      <div className="itemsFeed">
        {items.map((item) => (
          <ItemCard key={item.id} item={item} />
        ))}
      </div>
      <PostProduct />
      <Transaction />
      <Favorite />
      <Login />
      <Register />
    </div>
  );
}*/
/*function App() {
  return <div>Second Hand Market</div>;
}
export default App;*/

/*import React from "react";
import "./App.css";
import Search from "./components/Search/Search"; // Adjust the import path as necessary

function App() {
  const handleSearch = (query) => {
    console.log("Searching for:", query);
    // Here, you would typically handle the search logic,
    // such as filtering data or making an API call based on the query.
  };

  return (
    <div className="App">
      <h1>Second Hand Market</h1>
      <Search onSearch={handleSearch} />
      
    </div>
  );
}

export default App;*/

import React, { useState } from "react";
import "./App.css";
import Search from "./components/Search/Search";
import Filter from "./components/Filter/Filter";

// Dummy data for the purpose of example
const allItems = [
  { id: 1, name: "Laptop", category: "electronics", price: 1000 },
  { id: 2, name: "Sofa", category: "furniture", price: 500 },
  // Add more items as needed
];

const App = () => {
  const [items, setItems] = useState(allItems);
  const [searchQuery, setSearchQuery] = useState("");

  const handleSearch = (query) => {
    setSearchQuery(query);
  };

  const handleFilterChange = (filters) => {
    let filteredItems = allItems;

    // Filter by category
    if (filters.category) {
      filteredItems = filteredItems.filter(
        (item) => item.category === filters.category
      );
    }

    // Filter by price range
    if (filters.minPrice) {
      filteredItems = filteredItems.filter(
        (item) => item.price >= filters.minPrice
      );
    }
    if (filters.maxPrice) {
      filteredItems = filteredItems.filter(
        (item) => item.price <= filters.maxPrice
      );
    }

    // Apply search query
    if (searchQuery) {
      filteredItems = filteredItems.filter((item) =>
        item.name.toLowerCase().includes(searchQuery.toLowerCase())
      );
    }

    setItems(filteredItems);
  };

  return (
    <div className="App">
      <h1>Second Hand Market App</h1>
      <Search onSearch={handleSearch} />
      <Filter onFilterChange={handleFilterChange} />
      <div className="itemsFeed">
        {items.map((item) => (
          <div key={item.id}>
            <h3>{item.name}</h3>
            <p>Category: {item.category}</p>
            <p>Price: ${item.price}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default App;
