import { useState } from "react";
import NoteForm from "./components/NoteForm";
import NoteList from "./components/NoteList";
import "./App.css";

function App() {
  const [notes, setNotes] = useState([]);
  const addNote = (note) => {
    const newNote = { ...note };
    newNote.id = Date.now();
    setNotes([...notes, newNote]);
  };
  const deleteNote = (id) => {
    setNotes(notes.filter((n) => n.id !== id));
  };
  return (
    <div className="App">
      <header className="App-header">
        <h1>My Notes App</h1>
      </header>

      <main>
        <NoteForm addNote={addNote} />
        <NoteList notes={notes} deleteNote={deleteNote} />
      </main>
    </div>
  );
}
export default App;

