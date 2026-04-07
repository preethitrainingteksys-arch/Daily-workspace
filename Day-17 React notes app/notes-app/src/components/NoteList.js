import React from "react";

function NoteList({ notes, deleteNote }) {
  return (
    <div style={{ marginTop: "20px" }}>
      {notes.length === 0 ? (
        <p style={{ textAlign: "center" }}>No notes available</p>
      ) : (
        <table
          border="1"
          cellPadding="10"
          style={{
            margin: "20px auto",
            borderCollapse: "collapse",
            width: "90%",
            backgroundColor: "white",
            color: "black",
          }}
        >
          <thead>
            <tr>
              <th>Title</th>
              <th>Content</th>
              <th>Status</th>
              <th>Time</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {notes.map((note) => (
              <tr key={note.id}>
                <td>{note.title}</td>
                <td>{note.content}</td>
                <td>{note.status}</td>
                <td>{note.time ? new Date(note.time).toLocaleString() : ""}</td>
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