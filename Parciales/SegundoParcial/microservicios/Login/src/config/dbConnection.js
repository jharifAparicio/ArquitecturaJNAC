const mysql = require('mysql');

let pool = mysql.createPool({
    host: "localhost",
    user: "root",
    password: "",
    database: 'reservasdehotel',
});

exports.pool = pool;