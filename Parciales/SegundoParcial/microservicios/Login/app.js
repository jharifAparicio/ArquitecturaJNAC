var express = require('express');

var app = express();

var LoginController = require('./src/routes/LoginController');

app.use('/api/login', LoginController);

module.exports = app;