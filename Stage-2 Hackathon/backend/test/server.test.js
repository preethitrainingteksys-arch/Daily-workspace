const request = require("supertest");
const { expect } = require("chai");
const app = require("../server");
describe("Backend API Testing", () => {
  it("should return all questions from GET /questions", (done) => {
    request(app)
      .get("/questions")
      .end((error, response) => {
        expect(response.status).to.equal(200);
        expect(response.body).to.be.an("array");
        done();
      });
  });
  it("should return 4 questions", (done) => {
  request(app)
    .get("/questions")
    .end((error, response) => {
      expect(response.status).to.equal(200);
      expect(response.body.length).to.equal(4);
      done();
    });
});
it("should save responses using POST /responses", (done) => {
  const testData = [
    {
      selectedQuestion: "1",
      answer: "daisy"
    },
    {
      selectedQuestion: "2",
      answer: "Cross origin"
    }
  ];
  request(app)
    .post("/responses")
    .send(testData)
    .end((error, response) => {
      expect(response.status).to.equal(200);
      expect(response.body).to.have.property("message");
      done();
    });
});
it("should return success message after saving responses", (done) => {
  const testData = [
    {
      selectedQuestion: "3",
      answer: "UI library"
    }
  ];
  request(app)
    .post("/responses")
    .send(testData)
    .end((error, response) => {
      expect(response.body.message).to.equal("Responses saved");
      done();
    });
});
it("should return 404 for invalid route", (done) => {
  request(app)
    .get("/wrongroute")
    .end((error, response) => {
      expect(response.status).to.equal(404);
      done();
    });
});
});