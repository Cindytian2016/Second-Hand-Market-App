import React from "react";
import "./App.css";
import PostProduct from "./components/PostProduct";
import Search from "./components/Search";
import Transaction from "./components/Transaction";
import LoginRegister from "./components/Register";
import ItemCard from "./components/ItemCard"; // Assume this will be used inside ItemFeed
import Favorite from "./components/Favorite";
import Filter from "./components/Filter";

function App() {
  // Mock data for ItemCard, replace with your data fetching logic
  const items = [
    {
      id: 1,
      name: "Item 1",
      category: "Category 1",
      price: "100",
      description: "Description 1",
    },
    // Add more items as needed
  ];

  return (
    <div className="App">
      <h1>Second Hand Market App</h1>
      <Search />
      <Filter />
      <div className="itemFeed">
        {items.map((item) => (
          <ItemCard key={item.id} item={item} />
        ))}
      </div>
      <PostProduct />
      <Transaction />
      <Favorite />
      <LoginRegister />
    </div>
  );
}

// export default App;
