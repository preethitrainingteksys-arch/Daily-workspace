import { render, screen ,fireEvent} from "@testing-library/react";
import axios from "axios";
import App from "./App";
jest.mock("axios");
test("renders Security Questions heading", async () => {
  axios.get.mockResolvedValue({
    data: []
  });
  render(<App />);
  const heading = await screen.findByText("Security Questions");
  expect(heading).toBeInTheDocument();
});
test("renders dropdown with Select question option", async () => {
  axios.get.mockResolvedValue({
    data: [
      { id: 1, question: "What is your mother's name?" }
    ]
  });
  render(<App />);
  const dropdownOption = await screen.findAllByText("Select question");
  expect(dropdownOption.length).toBeGreaterThan(0);
});
test("user can type in Answer textbox", async () => {
  axios.get.mockResolvedValue({
    data: [
      { id: 1, question: "What is your mother's name?" }
    ]
  });
  render(<App />);
  const answerInputs = await screen.findAllByPlaceholderText("Answer");
  fireEvent.change(answerInputs[0], {
    target: { value: "Daisy" }
  });
  expect(answerInputs[0].value).toBe("Daisy");
});
test("user can type in Confirm Answer textbox", async () => {
  axios.get.mockResolvedValue({
    data: [
      { id: 1, question: "What is React?" }
    ]
  });
  render(<App />);
  const confirmInputs = await screen.findAllByPlaceholderText("Confirm Answer");
  fireEvent.change(confirmInputs[0], {
    target: { value: "Javascript UI library" }
  });
  expect(confirmInputs[0].value).toBe("Javascript UI library");
});
test("submit button is disabled when form is incomplete", async () => {
  axios.get.mockResolvedValue({
    data: [
      { id: 3, question: "What is CORS?" }
    ]
  });
  render(<App />);
  await screen.findAllByPlaceholderText("Answer");
  const submitButton = await screen.findByText("Submit");
  expect(submitButton).toBeDisabled();
});
test("calls API when submit button is clicked", async () => {

  axios.get.mockResolvedValue({
    data: [
      { id: 1, question: "What is your mother's name?" },
      { id: 2, question: "What is CORS?" },
      { id: 3, question: "What is React?" },
      { id: 4, question: "What is JavaScript?" }
    ]
  });
  axios.post.mockResolvedValue({});
  render(<App />);
  const dropdowns = await screen.findAllByRole("combobox");
  const answers = await screen.findAllByPlaceholderText("Answer");
  const confirms = await screen.findAllByPlaceholderText("Confirm Answer");
  fireEvent.change(dropdowns[0], { target: { value: "1" } });
  fireEvent.change(answers[0], { target: { value: "Daisy" } });
  fireEvent.change(confirms[0], { target: { value: "Daisy" } });
  fireEvent.change(dropdowns[1], { target: { value: "2" } });
  fireEvent.change(answers[1], { target: { value: "Cross origin" } });
  fireEvent.change(confirms[1], { target: { value: "Cross origin" } });
  fireEvent.change(dropdowns[2], { target: { value: "3" } });
  fireEvent.change(answers[2], { target: { value: "UI library" } });
  fireEvent.change(confirms[2], { target: { value: "UI library" } });
  fireEvent.change(dropdowns[3], { target: { value: "4" } });
  fireEvent.change(answers[3], { target: { value: "Programming language" } });
  fireEvent.change(confirms[3], { target: { value: "Programming language" } });
  const submitButton = await screen.findByText("Submit");
  fireEvent.click(submitButton);
  expect(axios.post).toHaveBeenCalled();
});