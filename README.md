![Commit Stage](https://github.com/pebrisulistiyo/catalog-service/actions/workflows/commit-stage.yml/badge.svg)
# catalog-service

### Run apps with Docker
Remove previous docker image if necessary
```shell
docker rm -fv book-postgres
```

Create Network
```shell
docker network create catalog-network
docker ```

Create database
```shell
docker run -d \
  --name book-postgres \
  --net catalog-network \
  -e POSTGRES_USER=user \
  -e POSTGRES_PASSWORD=password \
  -e POSTGRES_DB=bookdb_catalog \
  -p 5432:5432 \
  postgres:14.4
```

Build Image Project
```shell
docker build \
  -t catalog-service .
```

Run Docker Service for Catalog Project
```shell
docker run -d \
  --name catalog-service \
  --net catalog-network \
  -p 9001:9001
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://book-postgres:5432/bookdb_catalog \
  -e SPRING_PROFILES_ACTIVE=testdata \
  catalog-service
```
### Run Project
Run project with specific profile
```shell
./mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=testdata"
```

### Run Integration Test
```shell
./mvnw test -Dtest="BookRepositoryJdbcTests"
```

### List port
```shell 
lsof -i :9001
```