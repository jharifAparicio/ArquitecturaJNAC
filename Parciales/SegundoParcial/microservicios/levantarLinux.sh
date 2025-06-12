
## descomentar si es necesario configurar el nginx
sudo cp nginx.conf /etc/nginx/nginx.conf

# recargamos los archivos de configuracion de nginx
sudo systemctl daemon-reload
sudo systemctl restart nginx

# levantar el servicion de mysql en xamop
sudo /opt/lampp/lampp start

# creamos los contenedores de docker
echo "Creando contenedores de docker..."
echo "construyendo el docker de Login"
docker build -t login:1.0 ./Login

echo "construyendo el docker de Habitaciones"
docker build -t habitacion:1.0 ./Habitacion

echo "construyendo el docker de Reservas"
docker build -t reserva:1.0 ./Reserva

# levantamos los microservicios
docker-compose up