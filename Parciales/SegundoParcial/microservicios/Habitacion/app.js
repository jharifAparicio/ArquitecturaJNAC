const express = require('express');
const app = express();
const roomRoutes = require('./src/routes/HabitacionesController');

app.use(express.json());

app.use('/api/habitaciones', roomRoutes);

const PORT = 3005;
app.listen(PORT, () => {
    console.log(`✅ Microservicio Habitaciones corriendo en puerto ${PORT}`);
});
