![Commit Stage](https://github.com/pebrisulistiyo/catalog-service/actions/workflows/commit-stage.yml/badge.svg)
# catalog-service

### Create Postgresql Database with Docker
```shell
docker run -d \
  --name book-postgres \
  -e POSTGRES_USER=user \
  -e POSTGRES_PASSWORD=password \
  -e POSTGRES_DB=bookdb_catalog \
  -p 5432:5432 \
  postgres:14.4
```
### Run Project
`./mvnw spring-boot:run`

