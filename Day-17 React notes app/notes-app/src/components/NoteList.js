import React, { useState } from "react";
import StatusChart from "./StatusChart";

function NoteList({ notes, deleteNote }) {
  const [search, setSearch] = useState("");
  const [sortType, setSortType] = useState("");

  let displayNotes = [...notes];

  if (search !== "") {
    displayNotes = displayNotes.filter((note) =>
      note.title.toLowerCase().includes(search.toLowerCase())
    );
  }

  if (sortType === "az") {
    displayNotes.sort((a, b) => a.title.localeCompare(b.title));
  }

  if (sortType === "priority") {
    displayNotes.sort((a, b) => Number(b.priority) - Number(a.priority));
  }

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <input
        type="text"
        placeholder="Search title..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
        style={{
          padding: "8px",
          borderRadius: "5px",
          border: "1px solid gray",
        }}
      />

      <br /><br />

      <button onClick={() => setSortType("az")}>Sort A-Z</button>

      <button
        onClick={() => setSortType("priority")}
        style={{ marginLeft: "10px" }}
      >
        Sort by Priority
      </button>

      <br /><br />

      {displayNotes.length === 0 ? (
        <p>No notes found</p>
      ) : (
        <div>
          <table
            border="1"
            cellPadding="10"
            style={{
              margin: "auto",
              backgroundColor: "white",
              color: "black",
              borderCollapse: "collapse",
              width: "90%",
              boxShadow: "0 2px 8px rgba(0,0,0,0.1)",
            }}
          >
            <thead style={{ backgroundColor: "#ffe6e6" }}>
              <tr>
                <th>Title</th>
                <th>Content</th>
                <th>Status</th>
                <th>Time</th>
                <th>Priority</th>
                <th>Delete</th>
              </tr>
            </thead>

            <tbody>
              {displayNotes.map((note) => (
                <tr key={note.id}>
                  <td>{note.title}</td>
                  <td>{note.content}</td>
                  <td>{note.status}</td>
                  <td>{note.time}</td>
                  <td>{note.priority}</td>
                  <td>
                    <button
                      onClick={() => deleteNote(note.id)}
                      style={{
                        backgroundColor: "#d60d0d",
                        border: "none",
                        padding: "5px 10px",
                        cursor: "pointer",
                      }}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>

          <br /><br />

          <StatusChart notes={notes} />
        </div>
      )}
    </div>
  );
}

export default NoteList;