const express = require("express");
const cors = require("cors");
const fs = require("fs");
const path = require("path");
const app = express();
const port = 5000;
app.use(cors());
app.use(express.json());
const questionsPath = path.join(__dirname, "data", "questions.json");//here _dirname says the location od current fle
const responsesPath = path.join(__dirname, "data", "responses.json");
app.get("/questions", (request, response) => {
  const questions = JSON.parse(
    fs.readFileSync(questionsPath, "utf8")
  );
  const responsesData = JSON.parse(
    fs.readFileSync(responsesPath, "utf8")
  );
  const answeredIds = responsesData.map(item =>
    String(item.selectedQuestion)
  );
  const availableQuestions = questions.filter(item =>
    !answeredIds.includes(String(item.id))
  );
  response.json(availableQuestions);
});
app.post("/responses", (request, response) => {
  const newResponses = request.body;
  const existingResponses = JSON.parse(
    fs.readFileSync(responsesPath, "utf8")
  );
  for (let index = 0; index < newResponses.length; index++) {
    existingResponses.push({
      selectedQuestion: newResponses[index].selectedQuestion,
      answer: newResponses[index].answer
    });
  }
  fs.writeFileSync(
    responsesPath,
    JSON.stringify(existingResponses, null, 2)
  );
  response.json({
    message: "Responses saved"
  });
});
app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});