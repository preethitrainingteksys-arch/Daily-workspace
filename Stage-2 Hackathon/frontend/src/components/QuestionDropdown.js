 
import React from "react";

function QuestionDropdown({ questions, value, onChange }) {
  return (
    <div>
      <label>Choose question</label>
      <br />
      <select value={value} onChange={onChange}>
        <option value="">Select question</option>
        {questions && questions.map((item) => (
          <option key={item.id} value={item.id}>
             
            {item.question || item.question_text}
          </option>
        ))}
      </select>
    </div>
  );
}

export default QuestionDropdown;