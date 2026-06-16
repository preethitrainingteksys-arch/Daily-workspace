import React from "react";
import { Link } from "react-router-dom";

function NavigationBar() {
  return (
    <nav
      style={{
        backgroundColor: "#f9c1c1",
        padding: "10px 20px",
        marginBottom: "20px",
        textAlign: "center",
      }}
    >
      <Link to="/" style={{ marginRight: "20px" }}>
        Notes
      </Link>
      <Link to="/add">Add Notes</Link>
    </nav>
  );
}

export default NavigationBar;