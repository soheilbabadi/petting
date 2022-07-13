docker run --name postgresql -e POSTGRES_USER=root -e POSTGRES_PASSWORD=sb1234@ -p 5432:5432 -v /data:/var/lib/postgresql/data -d bitnami/postgresql
