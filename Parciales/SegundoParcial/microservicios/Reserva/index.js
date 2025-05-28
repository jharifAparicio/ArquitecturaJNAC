const express = require('express');
const mongoose = require('mongoose');
const { mongoURI, port } = require('./config/config');
const reservaRoutes = require('./routes/ReservaController');

const app = express();
app.use(express.json());

mongoose.connect(mongoURI, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
});

mongoose.connection.on('error', console.error.bind(console, 'MongoDB error:'));
mongoose.connection.once('open', () => console.log('MongoDB conectado'));

app.use('/reservas', reservaRoutes);

app.listen(port, () => console.log(`Servidor corriendo en puerto ${port}`));
