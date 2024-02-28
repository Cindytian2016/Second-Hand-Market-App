import React from "react";
import "./favorite.css"; // Import the CSS for styling

const Favorite = ({ favorites, onRemove }) => {
  return (
    <div className="favoriteContainer">
      <h2>My Favorites</h2>
      <ul className="favoriteList">
        {favorites.map((item, index) => (
          <li key={index} className="favoriteItem">
            <span>{item.name}</span>
            <button onClick={() => onRemove(item.id)} className="removeButton">
              Remove
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Favorite;
