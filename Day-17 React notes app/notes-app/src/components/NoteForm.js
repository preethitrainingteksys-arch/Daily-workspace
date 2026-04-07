import { useState } from "react";
import { useNavigate } from "react-router-dom";

function NoteForm({ addNote }) {
  const navigate = useNavigate();

  const [note, setNote] = useState({
    title: "",
    content: "",
    status: "open",
    time: "",
    priority: 5,
  });

  const handleSubmit = async (e) => {
    e.preventDefault();

    const success = await addNote(note);

    if (success) {
      setNote({
        title: "",
        content: "",
        status: "open",
        time: "",
        priority: 5,
      });

      navigate("/");
    } else {
      alert("Note was not saved. Please check json-server.");
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNote((prevNote) => ({
      ...prevNote,
      [name]: value,
    }));
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginTop: "20px", textAlign: "center" }}>
      <div style={{ marginBottom: "10px" }}>
        <input
          type="text"
          name="title"
          value={note.title}
          onChange={handleChange}
          placeholder="Enter Note Title"
          required
        />
      </div>

      <div style={{ marginBottom: "10px" }}>
        <textarea
          name="content"
          value={note.content}
          onChange={handleChange}
          placeholder="Enter Content"
          required
        />
      </div>

      <div style={{ marginBottom: "10px" }}>
        <label>Status: </label>
        <input
          type="checkbox"
          checked={note.status === "closed"}
          onChange={() =>
            setNote((prevNote) => ({
              ...prevNote,
              status: prevNote.status === "closed" ? "open" : "closed",
            }))
          }
        />
        Closed
      </div>

      <div style={{ marginBottom: "10px" }}>
        <label>Select Date and Time: </label>
        <input
          type="datetime-local"
          name="time"
          value={note.time}
          onChange={handleChange}
          required
        />
      </div>

      <div style={{ marginBottom: "10px" }}>
        <label>Priority: {note.priority}</label>
        <br />
        <input
          type="range"
          name="priority"
          min="1"
          max="10"
          value={note.priority}
          onChange={handleChange}
        />
      </div>

      <button type="submit">Add Note</button>
    </form>
  );
}

export default NoteForm;