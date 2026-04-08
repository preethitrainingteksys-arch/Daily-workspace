import React, { useEffect, useState } from "react";
import axios from "axios";
import QuestionDropdown from "./components/QuestionDropdown";
function App() {
  const [questions, setQuestions] = useState([]);
  const [formData, setFormData] = useState([]);//formdata=the value entered by the user in the frm
  const [hideAnswers, setHideAnswers] = useState(false);
  useEffect(() => {
    axios.get("http://localhost:5000/questions")
      .then((response) => {
        setQuestions(response.data);
        const initialData = response.data.map(() => ({
          selectedQuestion: "",
          answer: "",
          confirmAnswer: ""
        }));
        setFormData(initialData);
      })
      .catch((error) => {
        console.error("Error fetching questions:", error);
      });
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
    for (let i = 0; i < formData.length; i++) {
      if (!formData[i].selectedQuestion) {
        alert("Please select all questions");
        return;
      }
      if (!formData[i].answer) {
        alert("Answer cannot be empty");
        return;
      }
      if (!formData[i].confirmAnswer) {
        alert("Please enter contents in confirm answer field");
        return;
      }
      if (formData[i].answer !== formData[i].confirmAnswer) {
        alert("Answer and Confirm Answer do not match.");
        return;
      }
    }
    axios.post("http://localhost:5000/responses", formData)
      .then((response) => {
        console.log(response.data);
        alert("Responses saved successfully");
      })
      .catch((error) => {
        console.log(error);
        alert("Error saving responses");
      });
  }
  const selectedQuestions = formData.map((item) => item.selectedQuestion);
  return (
    <div>
      <h2>Security Questions</h2>
      {formData.map((item, index) => {
        const availableQuestions = questions.filter(
          (q) =>
            !selectedQuestions.includes(String(q.id)) ||
            String(q.id) === item.selectedQuestion
        );
        return (
          <div
            key={index}
            style={{ display: "flex", gap: "10px", marginBottom: "15px" }}
          >
            <QuestionDropdown
              questions={availableQuestions}
              value={item.selectedQuestion}
              onChange={(event) => handleQuestionChange(index, event)}
            />
            <input
              type={hideAnswers ? "password" : "text"}
              placeholder="Answer"
              value={item.answer}
              onChange={(event) => handleAnswerChange(index, event)}
            />
            <input
              type={hideAnswers ? "password" : "text"}
              placeholder="Confirm Answer"
              value={item.confirmAnswer}
              onChange={(event) => handleConfirmAnswerChange(index, event)}
            />
          </div>
        );
      })}
      <label>
        <input
          type="checkbox"
          checked={hideAnswers}
          onChange={(event) => setHideAnswers(event.target.checked)}
        />
        Hide answers
      </label>
      <br />
      <br />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}
export default App;