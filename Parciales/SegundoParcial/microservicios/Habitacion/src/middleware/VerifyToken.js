const jwt = require('jsonwebtoken');
const config = require('../../config/config');

function verifyToken(req, res, next) {
    let token = req.headers['authorization'];
    if (!token) return res.status(403).send({ auth: false, message: 'Token no provisto' });

    token = token.replace('Bearer ', '');

    jwt.verify(token, config.secret, (err, decoded) => {
        if (err) return res.status(500).send({ auth: false, message: 'Token inválido' });
        req.userId = decoded.id;
        next();
    });
}

module.exports = verifyToken;