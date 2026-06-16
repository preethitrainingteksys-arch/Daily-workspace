function NoteItem({note,deleteNote})
{
    return (
        <li>
            <input
            type="checkbox"
            checked={note.status==="closed"}
            readOnly/>
            <span>{note.title}</span>
            <span>Status: {note.status==="closed"?"Closed":"open"}</span>
            <button onClick ={()=>deleteNote(note.id)}>Delete</button>
        </li>
    );
}
export default NoteItem;
