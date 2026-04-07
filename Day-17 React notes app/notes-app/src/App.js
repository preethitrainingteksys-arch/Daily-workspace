import { useState, useEffect } from "react";
import axios from "axios";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import NavigationBar from "./NavigationBar";
import NoteForm from "./components/NoteForm";
import NoteList from "./components/NoteList";
import "./App.css";

function App() {
  const [notes, setNotes] = useState([]);

  useEffect(() => {
    fetchNotes();
  }, []);

  const fetchNotes = async () => {
    try {
      const res = await axios.get("http://localhost:3001/notes");
      setNotes(res.data);
    } catch (err) {
      console.log("Error fetching notes:", err);
    }
  };

  const addNote = async (note) => {
    try {
      const res = await axios.post("http://localhost:3001/notes", note);
      setNotes((prevNotes) => [...prevNotes, res.data]);
      return true;
    } catch (err) {
      console.log("Error adding note:", err);
      return false;
    }
  };

  const deleteNote = async (id) => {
    try {
      await axios.delete(`http://localhost:3001/notes/${id}`);
      setNotes((prevNotes) => prevNotes.filter((n) => n.id !== id));
    } catch (err) {
      console.log("Error deleting note:", err);
    }
  };

  return (
    <Router>
      <div className="App">
        <NavigationBar />

        <header className="App-header">
          <h1>My Notes App</h1>
        </header>

        <main>
          <Routes>
            <Route path="/add" element={<NoteForm addNote={addNote} />} />
            <Route
              path="/"
              element={<NoteList notes={notes} deleteNote={deleteNote} />}
            />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;