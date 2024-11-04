### docker-demo
- Shortcut to compile jar, build docker image, run as docker containers
  - mvn clean install
  - docker build
  - docker compose

```
./run.sh
```

- Within Docker infratructure network (app-network)
  - demo-docker-frontend call demo-docker-backend (Within Container)
    - http://container1:8090/ohlc
    - or localhost
  - demo-docker-backend call demo-docker-external (Cross Containers)
    - http://container2:8090/ohlc
  - demo-docker-backend call PostgreSQL Database (Cross Containers)
    - http://postgresdb:5432
  - demo-docker-backend call Redis (Cross Containers)
    - http://redisserver:6379

Infrastructure:
![docker](/docker.jpeg)

References:
- public network
![public-network](/public-network.jpeg)# docker
