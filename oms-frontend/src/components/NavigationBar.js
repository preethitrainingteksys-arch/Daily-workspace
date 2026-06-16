import { Link } from "react-router-dom";

function NavigationBar() {
  return (
    <nav className="NavigationBar/">
      <Link to="/" className="nav-link">Create Order</Link>
      <Link to="/history" className="nav-link">Order History</Link>
    </nav>
  );
}

export default NavigationBar;