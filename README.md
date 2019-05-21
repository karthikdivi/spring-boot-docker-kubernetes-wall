### Build Springboot application
```sh
mvn clean install
```

### Build Docker Image
```sh
docker build -t wall:8 .
```

### Push Image

```sh
docker tag 0e8bbd95211b karthikdivi/wall:8
docker push karthikdivi/wall:8
docker tag 0e8bbd95211b gcr.io/karthikdivi/wall:8
docker push gcr.io/karthikdivi/wall:8
```