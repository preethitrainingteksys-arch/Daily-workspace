const fs = require("fs");
const path = require("path");
const questionsFilePath = path.join(__dirname, "../data/questions.json");//here _dirname says where the current file is located
const responsesFilePath = path.join(__dirname, "../data/responses.json");
function getQuestions(req, res) {
  fs.readFile(questionsFilePath, "utf8", (error, data) => {
    if (error) {
      response.status(500).json({ error: "Cannot read questions file" });
      return;
    }

    response.json(JSON.parse(data));
  });
}
function saveResponses(request, response) {
  const newResponse = request.body;
  fs.readFile(responsesFilePath, "utf8", (err, data) => {
    if (error) {
      response.status(500).json({ error: "Cannot read responses file" });
      return;
    }
    const responses = JSON.parse(data);
    responses.push(newResponse);
    fs.writeFile(
      responsesFilePath,
      JSON.stringify(responses, null, 2),
      "utf8",
      (error) => {
        if (err) {
          response.status(500).json({ error: "Cannot save response" });
          return;
        }

        response.json({ message: "Responses saved successfully" });
      }
    );
  });
}
module.exports = { getQuestions, saveResponses };