// In Button.jsx
import React from "react";
import "./button.css"; // Importing the CSS for styling

const Button = ({ children, onClick, buttonStyle, buttonSize }) => {
  return (
    <button className={`btn ${buttonStyle} ${buttonSize}`} onClick={onClick}>
      {children}
    </button>
  );
};

export default Button;
