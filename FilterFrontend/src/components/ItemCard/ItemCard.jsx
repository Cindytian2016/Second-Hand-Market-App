import React from "react";
import "./itemCard.css"; // Import the CSS for styling the item card

const ItemCard = ({ item }) => {
  return (
    <div className="itemCard">
      <img src={item.image} alt={item.name} className="itemImage" />
      <div className="itemDetails">
        <h3 className="itemName">{item.name}</h3>
        <p className="itemCategory">{item.category}</p>
        <p className="itemPrice">${item.price}</p>
        <p className="itemDescription">{item.description}</p>
      </div>
    </div>
  );
};

export default ItemCard;
