import { useState } from "react";
import axios from "axios";
function OrderForm({ addedItems,addItemToList,clearItems})
{
    const[item,setItem]=useState("");
    const[price,setPrice]=useState("");
    const handleAddItem = () => {

    addItemToList({
      item: item,
      price: Number(price)
    });

    setItem("");
    setPrice("");
  };

    const handleSubmit=async(e)=>{
        e.preventDefault();
          const data = {
      orderLines: addedItems
    };
        
    
    try{
        await axios.post("http://localhost:8080/order",data);
        addItemToList({
        item: item,
        price: price
      });
      clearItems("");
        setItem("");
        setPrice("");
    }
    catch (error) {
      console.log("Full error:", error);
      console.log("Response data:", error.response?.data);
      console.log("Status code:", error.response?.status);
      alert(error.response?.data || "Error saving order");
    }
    };
return(
    <form onSubmit={handleSubmit}>
        <div>
            <label>Item</label>
            <input type="text"
    value={item}
    onChange={(e)=>setItem(e.target.value)}
    placeholder="Enter the Item"

    />
        </div>
        <div>
            <label>Price</label>
            <input type="number"
            value={price}
            onChange={(e)=>setPrice(e.target.value)}
            placeholder="Enter amount"

            />
            <br/>
            <button type="button" onClick={handleAddItem}>Add Item</button>
        </div>
        <button type="submit">Submit</button>

    </form>
    

);
}
export default OrderForm;
