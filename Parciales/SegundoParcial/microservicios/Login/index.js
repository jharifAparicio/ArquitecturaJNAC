var app = require('./app');
var port = process.env.PORT || 3000;

app.listen(port, function () {
    console.log('Express server for Login escuchando on port ' + port);
});