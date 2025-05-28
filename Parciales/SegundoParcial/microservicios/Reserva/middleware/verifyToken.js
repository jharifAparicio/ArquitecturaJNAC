const jwt = require('jsonwebtoken');
const { jwtSecret } = require('../config/config');

function verifyToken(req, res, next) {
    const authHeader = req.headers['authorization'];
    if (!authHeader) return res.status(401).json({ message: 'No token provided' });

    const token = authHeader.split(' ')[1];
    if (!token) return res.status(401).json({ message: 'Token malformed' });

    jwt.verify(token, jwtSecret, (err, decoded) => {
        if (err) return res.status(401).json({ message: 'Invalid token' });
        req.userId = decoded.id;
        req.isAdmin = decoded.isAdmin;
        next();
    });
}

module.exports = verifyToken;
