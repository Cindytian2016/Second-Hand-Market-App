import React from "react";
import "./input.css"; // Import the CSS for styling the input

// A functional component for input, accepting props for customization
const Input = ({
  type = "text",
  placeholder,
  value,
  onChange,
  className = "input",
  ...props
}) => {
  return (
    <input
      type={type} // Defines the input type (e.g., text, password)
      placeholder={placeholder} // Text to display when the input is empty
      value={value} // The current value of the input
      onChange={onChange} // Function to call when the input value changes
      className={className} // CSS class for styling
      {...props} // Spreads any additional props passed to the component
    />
  );
};

export default Input;
