- Clone the project `git clone`
- Build it `mvn clean install`
- Connect to docker engine (daemon on host) `docker -version`
- Invoke Docker Compose `docker-compose -p demo up`
- Put some data (key) into KVLite instance `curl --data "test" http://<docker_host_ip>:8080/`
- See when it (the key) was inserted `curl http://<docker_host_ip>:8080/test`
- Clean up! `docker-compose down`
- Change code, rebuild again `docker up build`