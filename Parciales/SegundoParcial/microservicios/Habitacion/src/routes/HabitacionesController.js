const express = require('express');
const router = express.Router();
const connection = require('../database');
const verifyToken = require('../middleware/VerifyToken');

// Obtener todas las habitaciones
router.get('/', verifyToken, (req, res) => {
    connection.query('SELECT * FROM habitacions', (err, results) => {
        if (err) return res.status(500).send(err);
        res.status(200).json(results);
    });
});

// obtener habitación por ID
router.get('/:id', verifyToken, (req, res) => {
    connection.query('SELECT * FROM habitacions WHERE id = ?', [req.params.id], (err, results) => {
        if (err) return res.status(500).send(err);
        if (results.length === 0) return res.status(404).send({ message: 'Habitación no encontrada' });
        res.status(200).json(results[0]);
    });
});

// Crear nueva habitación
router.post('/', verifyToken, (req, res) => {
    const { nombre, capacidad } = req.body;
    connection.query('INSERT INTO habitacions (nombre, capacidad) VALUES (?, ?)', [nombre, capacidad], (err) => {
        if (err) return res.status(500).send(err);
        res.status(201).send({ message: 'Habitación creada' });
    });
});

// Actualizar habitación
router.put('/:id', verifyToken, (req, res) => {
    const { nombre, capacidad } = req.body;
    connection.query('UPDATE habitacions SET nombre = ?, capacidad = ? WHERE id = ?', [nombre, capacidad, req.params.id], (err) => {
        if (err) return res.status(500).send(err);
        res.status(200).send({ message: 'Habitación actualizada' });
    });
});

// Eliminar habitación
router.delete('/:id', verifyToken, (req, res) => {
    connection.query('DELETE FROM habitacions WHERE id = ?', [req.params.id], (err) => {
        if (err) return res.status(500).send(err);
        res.status(200).send({ message: 'Habitación eliminada' });
    });
});

module.exports = router;
