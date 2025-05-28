const jwt = require('jsonwebtoken');
const config = require('../config/config');

function verifyToken(req, res, next) {
    let token = req.headers['authorization'];
    if (!token)
        return res.status(403).send({ auth: false, message: 'No token provided.' });

    token = token.startsWith('Bearer ') ? token.slice(7) : token;

    jwt.verify(token, config.secret, function (err, decoded) {
        if (err)
            return res.status(500).send({ auth: false, message: 'Failed to authenticate token.' });

        const isAdmin = decoded.tipo_usuario === 'admin';

        // Autorización GET
        if (req.route.methods.get) {
            if (!isAdmin && req.baseUrl !== "/api/login")
                return res.status(401).send({ auth: false, message: 'Unauthorized to get user info.' });
        }

        // Autorización PUT
        if (req.route.methods.put) {
            if (!isAdmin && decoded.id != req.url.substring(1))
                return res.status(401).send({ auth: false, message: 'Unauthorized to update user.' });
        }

        // Autorización DELETE
        if (req.route.methods.delete) {
            if (!isAdmin && decoded.id != req.url.substring(1))
                return res.status(401).send({ auth: false, message: 'Unauthorized to delete user.' });
        }

        req.userId = decoded.id;
        req.tipo_usuario = decoded.tipo_usuario;
        next();
    });
}

module.exports = verifyToken;