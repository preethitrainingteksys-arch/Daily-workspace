import { useState } from "react";
import OrderForm from "./components/OrderForm";
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
    <div className="App">
      <h1>OMS Frontend</h1>
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
              {itemObj.item} -
              ₹{itemObj.price}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
export default App;