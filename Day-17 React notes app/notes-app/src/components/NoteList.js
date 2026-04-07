import React, { useState } from "react";

function NoteList({ notes, deleteNote }) {
  const [searchTerm, setSearchTerm] = useState("");

  const filteredNotes = notes.filter((note) =>
    note.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
    note.content.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div style={{ marginTop: "20px", textAlign: "center" }}>
      
      <div style={{ marginBottom: "20px" }}>
        <input
          type="text"
          placeholder="Search notes..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          style={{
            padding: "8px",
            width: "250px",
            borderRadius: "5px",
            border: "1px solid #ccc"
          }}
        />
      </div>

      {/* when no notes exist */}
      {notes.length === 0 ? (
        <p>No notes available</p>

      /* when search has no result */
      ) : filteredNotes.length === 0 ? (
        <p>No matching notes found</p>

      /* show table */
      ) : (
        <table
          border="1"
          cellPadding="10"
          style={{
            margin: "20px auto",
            borderCollapse: "collapse",
            width: "90%",
            backgroundColor: "white",
            color: "black"
          }}
        >
          <thead>
            <tr>
              <th>Title</th>
              <th>Content</th>
              <th>Status</th>
              <th>Time</th>
              <th>Priority</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {filteredNotes.map((note) => (
              <tr key={note.id}>
                <td>{note.title}</td>
                <td>{note.content}</td>
                <td>{note.status}</td>
                <td>
                  {note.time
                    ? new Date(note.time).toLocaleString()
                    : ""}
                </td>
                <td>{note.priority}</td>

                <td>
                  <button
                    onClick={() => {
                      const confirmDelete = window.confirm(
                        "Are you sure you want to delete this note?"
                      );

                      if (confirmDelete) {
                        deleteNote(note.id);
                      }
                    }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>

        </table>
      )}
    </div>
  );
}

export default NoteList;