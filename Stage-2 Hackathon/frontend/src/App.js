import React, { useEffect, useState } from "react";
import axios from "axios";
import QuestionDropdown from "./components/QuestionDropdown";
import "./App.css";

function App() {
  const [questions, setQuestions] = useState([]);
  const [formData, setFormData] = useState([]);
  const [hideAnswers, setHideAnswers] = useState(false);
  const [successMessage, setSuccessMessage] = useState("");
  const [errors, setErrors] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:5000/questions")
      .then((response) => {
        setQuestions(response.data);
        const initialRows = [
          { selectedQuestion: "", answer: "", confirmAnswer: "" },
          { selectedQuestion: "", answer: "", confirmAnswer: "" },
          { selectedQuestion: "", answer: "", confirmAnswer: "" },
          { selectedQuestion: "", answer: "", confirmAnswer: "" }
        ];
        setFormData(initialRows);
        setErrors(initialRows.map(() => ({ selectedQuestion: "", answer: "", confirmAnswer: "" })));
      })
      .catch((error) => console.error(error));
  }, []);

  function handleQuestionChange(index, event) {
    const updated = [...formData];
    updated[index].selectedQuestion = event.target.value;
    setFormData(updated);
  }

  function handleAnswerChange(index, event) {
    const updated = [...formData];
    updated[index].answer = event.target.value;
    setFormData(updated);
  }

  function handleConfirmAnswerChange(index, event) {
    const updated = [...formData];
    updated[index].confirmAnswer = event.target.value;
    setFormData(updated);
  }

  function handleSubmit() {
    axios.post("http://localhost:5000/responses", formData)
      .then(() => {
        setSuccessMessage("responses saved successfully");
        setTimeout(() => setSuccessMessage(""), 5000);
      })
      .catch(() => setSuccessMessage("error saving responses"));
  }

  const isFormIncomplete = formData.some(item => 
    !item.selectedQuestion || !item.answer.trim() || !item.confirmAnswer.trim()
  );
  const allSelectedIds = formData.map(row => row.selectedQuestion);
  return (
    <div className="container">
      <h2>Security Questions</h2>
      {formData.map((item, index) => {
        const filteredQuestions = questions.filter(q => {
          const isSelectedElsewhere = allSelectedIds.includes(String(q.id));
          const isSelectedInThisRow = String(q.id) === String(item.selectedQuestion);
          return !isSelectedElsewhere || isSelectedInThisRow;
        });
        return (
          <div key={index} className="row-container" style={{ marginBottom: "20px" }}>
            <QuestionDropdown
              questions={filteredQuestions}
              value={item.selectedQuestion}
              onChange={(e) => handleQuestionChange(index, e)}
            />
            <input
              type={hideAnswers ? "password" : "text"}
              placeholder="Answer"
              value={item.answer}
              onChange={(e) => handleAnswerChange(index, e)}
            />
            <input
              type={hideAnswers ? "password" : "text"}
              placeholder="Confirm Answer"
              value={item.confirmAnswer}
              onChange={(e) => handleConfirmAnswerChange(index, e)}
            />
          </div>
        );
      })}
      
      <label>
        <input 
          type="checkbox" 
          checked={hideAnswers} 
          onChange={(e) => setHideAnswers(e.target.checked)} 
        />
        Hide answers
      </label>     
      <br /><br />     
      <button 
        onClick={handleSubmit} 
        disabled={isFormIncomplete}
        style={{
          backgroundColor: isFormIncomplete ? "#ccc" : "#007bff",
          color: "white",
          padding: "10px 20px"
        }}
      >
        Submit
      </button>
      {successMessage && <p style={{ color: "green" }}>{successMessage}</p>}
    </div>
  );
}

export default App;