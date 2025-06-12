const mysql = require('mysql2');

const connection = mysql.createConnection({
    host: "host.docker.internal",
    user: "root",
    password: "",
    database: "reservasdehotel",
    port: 3306,
});

connection.connect(err => {
    if (err) throw err;
    console.log('✅ Conectado a MySQL');
});

module.exports = connection;
