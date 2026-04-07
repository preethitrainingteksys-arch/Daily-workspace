import React, { useState } from "react";

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

    const openCount = notes.filter((n) => n.status === "open").length;
    const closedCount = notes.filter((n) => n.status === "closed").length;
    const maxValue = Math.max(openCount, closedCount, 1);


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
            <h3>Status Chart</h3>
            <div
                style={{
                    width: "300px",
                    margin: "20px auto",
                    textAlign: "left",
                }}
            >
                <p>Open ({openCount})</p>
                <div
                    style={{
                        height: "25px",
                        width: `${(openCount / maxValue) * 100}%`,
                        backgroundColor: "#05da05",
                        marginBottom: "10px",
                        borderRadius: "4px",
                    }}
                ></div>
                <p>Closed ({closedCount})</p>
                <div
                    style={{
                        height: "25px",
                        width: `${( closedCount / maxValue)*100}%`,
                        backgroundColor: "#f70707",
                        marginBottom: "20px",
                        borderRadius: "4px",

                    }}
                ></div>
                </div>

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
                                                backgroundColor: "#ffb3b3",
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
                )}
            </div>
            );
}

            export default NoteList;