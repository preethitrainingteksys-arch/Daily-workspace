const express = require('express');
const app=express();

const notesRoutes=require('./routes/notesRoutes');
//console.log('errorrrrrrrrrrrrrrrr##',notesRoutes);
app.use(express.json());
app.use('/notes',notesRoutes);
app.listen(3001,()=>
{
    console.log('Server running on http://localhost:3001');
});
module.exports=app;