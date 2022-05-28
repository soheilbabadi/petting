docker pull bitnami/postgresql
docker run --name postgresql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=sb1234@ -p 5432:5432 -v /data:/var/lib/postgresql/data -d bitnami/postgresql
docker exec -it postgresql postgres -U root -c "CREATE USER soheil WITH PASSWORD 'sb1234@';"