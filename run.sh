# Stop and remove existing containers if any
docker-compose down

# Remove old images (if needed)
docker rmi container1:0.0.1
docker rmi container2:0.0.1

# Run Postgres by docker-compose
# docker run --name my_postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres

# Build docker images for containers
cd container1/demo-docker-backend
mvn clean install -Pdev
cd ../demo-docker-frontend
mvn clean install
cd ..
docker build -t container1:0.0.1 -f Dockerfile .

cd ../container2/demo-docker-external
mvn clean install
cd ..
docker build -t container2:0.0.1 -f Dockerfile .
cd ..

# Redeploy containers
docker-compose up -d