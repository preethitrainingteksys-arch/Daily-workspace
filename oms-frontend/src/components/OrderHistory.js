import { useEffect, useState } from "react";
import axios from "axios";
function OrderHistory() {
  const [orders, setOrders] = useState([]);
  useEffect(() => {
    fetchOrders();
  }, []);

  const fetchOrders = async () => {
    try {
      const response = await axios.get("http://localhost:8080/order");
      setOrders(response.data);
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <div className="history-container">
      <h2>Order History</h2>
      {orders.length === 0 ? (
        <p>No orders found</p>
      ) : (
        orders.map((order) => (
          <div key={order.id} className="order-card">
            <h3>Order ID: {order.id}</h3>
            <p>Status: {order.status}</p>
            <p>Created At: {order.createdAt}</p>
            <table>
              <thead>
                <tr>
                  <th>Item</th>
                  <th>Price</th>
                  <th>Quantity</th>
                </tr>
              </thead>
              <tbody>
                {order.orderLines.map((line) => (
                  <tr key={line.id}>
                    <td>{line.item}</td>
                    <td>₹{line.price}</td>
                    <td>{line.quantity}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        ))
      )}
    </div>
  );
}

export default OrderHistory;