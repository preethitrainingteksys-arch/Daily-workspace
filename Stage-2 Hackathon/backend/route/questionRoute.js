const express = require("express");
const router = express.Router();
const { getQuestions, saveResponses } = require("../services/questionServices");

router.get("/questions", getQuestions);
router.post("/responses", saveResponses);

module.exports = router;