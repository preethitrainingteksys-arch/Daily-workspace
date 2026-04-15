import { useState } from "react";
import OrderForm from "./components/OrderForm";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import OrderHistory from "./components/OrderHistory";
import NavigationBar from "./components/NavigationBar";
import "./App.css";

function App() {
  const [addedItems, setAddedItems] = useState([]);
  const addItemToList = (newItem) => {
    setAddedItems([...addedItems, newItem]);
    
  };
    const clearItems = () => {
    setAddedItems([]);
  };
  return (
    <Router>
    <div className="App">
      <h1>OMS Frontend</h1>
      <NavigationBar/>
      <Routes>
        <Route
        path="/"
        element={
          <>
      
      <OrderForm 
      addedItems={addedItems}
      addItemToList={addItemToList}
      clearItems={clearItems}
      />
      <h3>Added Items</h3>
      {addedItems.length === 0 ? (
        <p>No items added</p>
      ) : (
        <ul>
          {addedItems.map((itemObj, index) => (
            <li key={index}>
              {itemObj.item} -Quantity: {itemObj.quantity}-₹{itemObj.price}
            </li>
          ))}
        </ul>
      )}
      </>
        }
        />
        <Route path="/history" element={<OrderHistory/>}/>
        </Routes>
    </div>
    </Router>
  );
}
export default App;