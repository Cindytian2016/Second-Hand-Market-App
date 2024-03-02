import React, { useState } from "react";
import "./register.css"; // Import the CSS for styling the registration form

const Register = ({ onRegister }) => {
  const [userDetails, setUserDetails] = useState({
    username: "",
    password: "",
    email: "", // Include this if you wish to capture email addresses
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUserDetails((prevDetails) => ({
      ...prevDetails,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onRegister(userDetails);
  };

  return (
    <div className="registerContainer">
      <form className="registerForm" onSubmit={handleSubmit}>
        <h2>Register</h2>
        <div className="inputGroup">
          <label htmlFor="username">Username</label>
          <input
            type="text"
            id="username"
            name="username"
            value={userDetails.username}
            onChange={handleChange}
            required
          />
        </div>
        <div className="inputGroup">
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            value={userDetails.email}
            onChange={handleChange}
            required
          />
        </div>
        <div className="inputGroup">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            value={userDetails.password}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit" className="registerButton">
          Register
        </button>
      </form>
    </div>
  );
};

export default Register;
