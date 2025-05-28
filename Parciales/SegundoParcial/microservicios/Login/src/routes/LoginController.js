const express = require('express');
const router = express.Router();
const bodyParser = require('body-parser');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');
const config = require('../config/config');
const connection = require('../config/dbConnection');
const VerifyToken = require('./VerifyToken');

router.use(bodyParser.urlencoded({ extended: true }));
router.use(bodyParser.json());

// LOGIN
router.post('/', function (req, res) {
    const email = req.body.email;
    const password = req.body.password;

    connection.pool.query('SELECT * FROM usuarios WHERE email = ?', [email], (err, results) => {
        if (err) return res.status(500).send('Error en el servidor.');
        if (results.length === 0) return res.status(404).send('Usuario no encontrado.');

        const user = results[0];

        const passwordIsValid = bcrypt.compareSync(password, user.password);
        if (!passwordIsValid) return res.status(401).send({ auth: false, token: null });

        const payload = {
            id: user.id,
            tipo_usuario: user.tipo_usuario,
            nombre: user.nombre,
            email: user.email
        };

        const token = jwt.sign(payload, config.secret, {
            expiresIn: 86400
        });

        res.status(200).send({ auth: true, token: token });
    });
});

// Obtener datos del usuario autenticado
router.get('/', VerifyToken, function (req, res) {
    connection.query('SELECT id, nombre, email, tipo_usuario FROM usuarios WHERE id = ?', [req.userId], (err, results) => {
        if (err) return res.status(500).send('Error al buscar el usuario.');
        if (results.length === 0) return res.status(404).send('Usuario no encontrado.');

        res.status(200).send(results[0]);
    });
});

module.exports = router;
