// App.test.js
import { render, screen } from "@testing-library/react";
import App from "./App";
import React from "react";

test("renders home link", () => {
  render(<App />);
  const linkElement = screen.getByText(/home/i);
  expect(linkElement).toBeInTheDocument();
});
