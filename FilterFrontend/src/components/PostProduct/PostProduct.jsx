import React, { useState } from "react";
import "./postProduct.css"; // Importing the CSS for styling

const PostProduct = () => {
  // State for the product form
  const [product, setProduct] = useState({
    name: "",
    description: "",
    price: "",
    category: "",
  });

  // Function to handle form input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  // Function to submit the product form
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Product submitted:", product);
    // Here you would usually send the product data to your backend server
  };

  return (
    <div className="postProduct">
      <h2>Post a Product</h2>
      <form onSubmit={handleSubmit} className="productForm">
        <input
          type="text"
          name="name"
          placeholder="Product Name"
          value={product.name}
          onChange={handleChange}
          required
        />
        <textarea
          name="description"
          placeholder="Product Description"
          value={product.description}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          name="price"
          placeholder="Price"
          value={product.price}
          onChange={handleChange}
          required
        />
        <select
          name="category"
          value={product.category}
          onChange={handleChange}
          required
        >
          <option value="">Select a Category</option>
          <option value="electronics">Electronics</option>
          <option value="furniture">Furniture</option>
          <option value="clothing">Clothing</option>
          {/* Add more categories as needed */}
        </select>
        <button type="submit">Post Product</button>
      </form>
    </div>
  );
};

export default PostProduct;
