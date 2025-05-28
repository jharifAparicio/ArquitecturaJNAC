const express = require('express');
const router = express.Router();
const Reserva = require('../models/Reserva');
const verifyToken = require('../middleware/verifyToken');

// Crear reserva
router.post('/', verifyToken, async (req, res) => {
    try {
        const reserva = new Reserva(req.body);
        const saved = await reserva.save();
        res.status(201).json(saved);
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
});

// Obtener todas reservas (solo admin)
router.get('/', verifyToken, (req, res, next) => {
    next();
}, async (req, res) => {
    try {
        const reservas = await Reserva.find();
        res.json(reservas);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

// Obtener reserva por ID
router.get('/:id', verifyToken, async (req, res) => {
    try {
        const reserva = await Reserva.findById(req.params.id);
        if (!reserva) return res.status(404).json({ message: 'No encontrada' });
        res.json(reserva);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

// Actualizar reserva (solo admin)
router.put('/:id', verifyToken, (req, res, next) => {
    next();
}, async (req, res) => {
    try {
        const updated = await Reserva.findByIdAndUpdate(req.params.id, req.body, { new: true });
        if (!updated) return res.status(404).json({ message: 'No encontrada' });
        res.json(updated);
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
});

// Eliminar reserva (solo admin)
router.delete('/:id', verifyToken, (req, res, next) => {
    next();
}, async (req, res) => {
    try {
        const deleted = await Reserva.findByIdAndDelete(req.params.id);
        if (!deleted) return res.status(404).json({ message: 'No encontrada' });
        res.json({ message: 'Eliminada' });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

module.exports = router;
